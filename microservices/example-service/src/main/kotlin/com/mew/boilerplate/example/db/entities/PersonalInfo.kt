package com.mew.boilerplate.example.db.entities

import com.mew.boilerplate.common.types.BaseEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "personal_info")
class PersonalInfo
    (
    id: UUID? = null,
    val firstName: String,
    val lastName: String,
    val birthDate: Instant,
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    var address: Address? = null
) : BaseEntity(id) {

    @CreatedDate
    var createdAt: Date? = null

    @LastModifiedDate
    var updatedAt: Date? = null
}