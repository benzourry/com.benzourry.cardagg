package com.benzourry.cardagg.service

import com.benzourry.cardagg.model.Activity
import com.benzourry.cardagg.model.Device
import com.benzourry.cardagg.model.UserLink
import com.benzourry.cardagg.repository.ActivityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.client.AsyncRestTemplate
import org.springframework.web.client.RestTemplate
import java.util.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Service("activityService")
class ActivityService(val activityRepository: ActivityRepository,
                      val deviceService: com.benzourry.cardagg.service.DeviceService,
                      val userLinkService: com.benzourry.cardagg.service.UserLinkService){

    var restTemplate: RestTemplate = RestTemplate()
    var asyncRestTemplate: AsyncRestTemplate = AsyncRestTemplate()

    fun findById(id: Long) = activityRepository.findOne(id)

    fun findByCode(code: String) = activityRepository.findFirstByCuid(code)

    fun findAll() = activityRepository.findAll()

    fun save(activity: Activity) = activityRepository.save(activity)

//    @Async
    fun log(cuid: String="", deviceId: String): Activity {
        val timestamp: Date = Date()
        val device: Device = deviceService.findByCode(deviceId)
        val userLink: UserLink = userLinkService.findByCuid(cuid)

        val uri: String = "${device.client?.callback}?timestamp=${timestamp.time}&device=${deviceId}&cuid=${cuid}&userid=${userLink?.userid}"
        asyncRestTemplate.getForEntity(uri, HashMap::class.java)
        println("uri:"+uri)
        return save(com.benzourry.cardagg.model.Activity(timestamp = timestamp, device = device, cuid = cuid))
    }

    fun delete(id: Long) = activityRepository.delete(id)

    fun findByQuery(q: String = "", pageable: Pageable): Page<Activity> = activityRepository.findByQuery("%${q}%",pageable)


}