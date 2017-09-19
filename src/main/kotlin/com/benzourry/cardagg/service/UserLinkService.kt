package com.benzourry.cardagg.service

import com.benzourry.cardagg.model.UserLink
import com.benzourry.cardagg.repository.UserLinkRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Service("userLinkService")
class UserLinkService(val userLinkRepository: UserLinkRepository){

    fun save(userLink: UserLink): UserLink = userLinkRepository.save(userLink)

    fun findByCuid(cuid: String): UserLink = userLinkRepository.findByCuid(cuid)

    fun findByUserid(userid: String): UserLink = userLinkRepository.findByUserid(userid)

    fun findById(id: Long): UserLink = userLinkRepository.findOne(id)

    fun find(q: String, pageable: Pageable): Page<UserLink> = userLinkRepository.findByQuery(q, pageable)

    fun delete(id: Long) = userLinkRepository.delete(id)

    fun findByQuery(q: String? = "", pageable: Pageable): Page<UserLink> = userLinkRepository.findByQuery("%${q}%",pageable)

}