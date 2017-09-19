package com.benzourry.cardagg.controller

import com.benzourry.cardagg.model.Device
import com.benzourry.cardagg.service.DeviceService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@RestController
@RequestMapping("api/device")
@CrossOrigin
class DeviceController (val deviceService: com.benzourry.cardagg.service.DeviceService){

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = deviceService.findById(id)

    @GetMapping("{code}")
    fun findByCode(@PathVariable code: String) = deviceService.findByCode(code)

    @PostMapping
    fun save(@RequestBody device: com.benzourry.cardagg.model.Device) = deviceService.save(device)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = deviceService.delete(id)

    @GetMapping
    fun find(@RequestParam("searchText", required = false, defaultValue = "") searchText: String, pageable: Pageable) = deviceService.findByQuery(searchText, pageable)


}
