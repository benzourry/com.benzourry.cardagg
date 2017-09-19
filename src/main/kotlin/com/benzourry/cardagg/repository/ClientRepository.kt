package com.benzourry.cardagg.repository

import com.benzourry.cardagg.model.Client
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by MohdRazif on 5/23/2017.
 */

interface ClientRepository: JpaRepository<Client, Long> {
    fun  findFirstByCode(code: String): Any

    @Query("select c from Client c where (c.name like :searchText or c.description like :searchText)")
    fun  findByQuery(@Param("searchText") searchText: String, pageable: Pageable): Page<Client>

}