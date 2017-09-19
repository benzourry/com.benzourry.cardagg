package com.benzourry.cardagg.repository

import com.benzourry.cardagg.model.Device
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by MohdRazif on 5/23/2017.
 */
interface DeviceRepository: JpaRepository<Device, Long> {
    fun  findFirstByCode(code: String): Device

    @Query("select d from Device d where (d.code LIKE :q OR d.description LIKE :q)")
    fun  findByQuery(@Param("q") s: String, pageable: Pageable): Page<Device>



}