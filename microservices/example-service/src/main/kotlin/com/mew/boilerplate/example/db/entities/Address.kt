package com.mew.boilerplate.example.db.entities

import com.mew.boilerplate.common.types.BaseEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "address")
class Address(
    id: UUID? = null,
    val street: String,
    val house: String,
    val postalCode: String,
    val city: String,
    val state: String,
    val country: String,
    @OneToMany
    var residents: Collection<PersonalInfo>? = null
) : BaseEntity(id) {
    @CreatedDate
    var createdAt: Date? = null

    @LastModifiedDate
    var updatedAt: Date? = null
}