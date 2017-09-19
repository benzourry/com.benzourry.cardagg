package com.benzourry.cardagg.controller

import com.benzourry.cardagg.model.UserLink
import com.benzourry.cardagg.service.UserLinkService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@RestController
@RequestMapping("api/userlink")
@CrossOrigin
class UserLinkController (val userLinkService: com.benzourry.cardagg.service.UserLinkService) {

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = userLinkService.findById(id)

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable id: Long) = userLinkService.delete(id)

    @PostMapping
    fun create(@RequestBody client: com.benzourry.cardagg.model.UserLink) = userLinkService.save(client)

    @GetMapping
    fun find(@RequestParam("searchText",required = false, defaultValue = "") searchText: String = "", pageable: Pageable): Page<UserLink> = userLinkService.findByQuery(searchText, pageable)


}