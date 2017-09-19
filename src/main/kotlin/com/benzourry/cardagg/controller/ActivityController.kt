package com.benzourry.cardagg.controller

import com.benzourry.cardagg.model.Activity
import com.benzourry.cardagg.service.ActivityService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@RestController
@RequestMapping("api/activity")
@CrossOrigin
class ActivityController (val activityService: com.benzourry.cardagg.service.ActivityService){

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long) = activityService.findById(id)

    @GetMapping("{code}")
    fun findByCode(@PathVariable code: String) = activityService.findByCode(code)

    @PostMapping
    fun save(@RequestBody activity: com.benzourry.cardagg.model.Activity) = activityService.save(activity)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = activityService.delete(id)

    @GetMapping
    fun find(@RequestParam("searchText", required = false, defaultValue = "") searchText: String, pageable: Pageable) = activityService.findByQuery(searchText, pageable)

    @PostMapping("log")
    fun log(@RequestParam cuid: String, @RequestParam device: String) = activityService.log(cuid, device)

    @GetMapping("test-log")
    fun testLog(@RequestParam cuid: String, @RequestParam device: String) = activityService.log(cuid, device)

}
