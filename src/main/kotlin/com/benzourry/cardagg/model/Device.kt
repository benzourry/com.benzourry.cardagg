package com.benzourry.cardagg.model

import javax.persistence.*

/**
 * Created by MohdRazif on 5/23/2017.
 */

@Cacheable
@Entity
class Device(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var code: String = "",
        var description: String = "",
        var location: String = "",
        var deviceType: String = "",
        @OneToOne
        var client: Client? = null
)