package com.benzourry.cardagg.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Entity
class UserLink(
    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    var id: Long = 0,
    var cuid: String = "",
    var userid: String = "",
    var remark: String = ""
)
