package com.benzourry.cardagg.controller

import com.benzourry.cardagg.model.Client
import com.benzourry.cardagg.service.ClientService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@RestController
@RequestMapping("api/client")
@CrossOrigin
class ClientController (val clientService: com.benzourry.cardagg.service.ClientService) {

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = clientService.findById(id)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: Long) = clientService.delete(id)

    @PostMapping
    fun create(@RequestBody client: com.benzourry.cardagg.model.Client) = clientService.save(client)

    @GetMapping
    fun find(@RequestParam("searchText",required = false, defaultValue = "") searchText: String = "", pageable: Pageable): Page<Client> = clientService.findByQuery(searchText, pageable)


}