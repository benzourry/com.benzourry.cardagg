package com.benzourry.cardagg.repository

import com.benzourry.cardagg.model.UserLink
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Created by MohdRazif on 5/23/2017.
 */
interface UserLinkRepository : JpaRepository<UserLink, Long> {


    fun findByCuid(cuid: String): UserLink

    fun findByUserid(userid: String): UserLink

    @Query("select u from UserLink u where (u.remark LIKE :q)")
    fun findByQuery(@Param("q") q: String, pageable: Pageable): Page<UserLink>
}