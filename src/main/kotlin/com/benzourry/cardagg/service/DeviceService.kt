package com.benzourry.cardagg.service

import com.benzourry.cardagg.model.Device
import com.benzourry.cardagg.repository.DeviceRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Service("deviceService")
class DeviceService(val deviceRepository: DeviceRepository){

    fun findById(id: Long) = deviceRepository.findOne(id)

    fun findByCode(code: String): Device = deviceRepository.findFirstByCode(code)

    fun findAll() = deviceRepository.findAll()

    fun save(device: Device) = deviceRepository.save(device)

    fun delete(id: Long) = deviceRepository.delete(id)

    fun findByQuery(q: String? = "", pageable: Pageable): Page<Device> = deviceRepository.findByQuery("%${q}%",pageable)


}