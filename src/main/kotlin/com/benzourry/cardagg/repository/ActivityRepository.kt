package com.benzourry.cardagg.repository

import com.benzourry.cardagg.model.Activity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by MohdRazif on 5/23/2017.
 */
interface ActivityRepository: JpaRepository<Activity, Long> {
    fun  findFirstByCuid(code: String): Any

    @Query("select d from Activity d where (d.cuid LIKE :q OR d.device.description LIKE :q)")
    fun  findByQuery(@Param("q") s: String, pageable: Pageable): Page<Activity>



}