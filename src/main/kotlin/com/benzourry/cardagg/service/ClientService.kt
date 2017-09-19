package com.benzourry.cardagg.service

import com.benzourry.cardagg.model.Client
import com.benzourry.cardagg.repository.ClientRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * Created by MohdRazif on 5/23/2017.
 */

@Service("clientService")
class ClientService (val clientRepository: ClientRepository){

    fun findById(id: Long) = clientRepository.findOne(id)

    fun findByCode(code: String) = clientRepository.findFirstByCode(code);

    fun save(client: Client) = clientRepository.save(client)

    fun delete(id: Long) = clientRepository.delete(id)

    fun findByQuery(q: String = "", pageable: Pageable): Page<Client> = clientRepository.findByQuery("%${q}%",pageable)

}
