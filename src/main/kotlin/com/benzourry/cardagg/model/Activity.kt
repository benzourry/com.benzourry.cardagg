package com.benzourry.cardagg.model

import java.util.*
import javax.persistence.*

/**
 * Created by MohdRazif on 5/23/2017.
 */
@Entity
class Activity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        var timestamp: Date = Date(),
        @OneToOne
        var device: com.benzourry.cardagg.model.Device? = null,
        var cuid: String = ""
)
