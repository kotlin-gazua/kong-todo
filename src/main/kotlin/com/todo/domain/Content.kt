package com.todo.domain

import lombok.Data
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@Entity
data class Content(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var seq: Long? = null,

    var content: String? = null,
    var date: LocalDateTime? = LocalDateTime.now()

)


