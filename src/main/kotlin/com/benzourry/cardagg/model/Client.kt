package com.benzourry.cardagg.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Entity
class Client(
        @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
        var id: Long = 0,
        var name: String = "",
        var code: String = "",
        var description: String = "",
        var callback: String = "",
        var callbackType: String =""
)