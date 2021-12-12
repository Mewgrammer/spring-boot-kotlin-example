package com.mew.boilerplate.example.db.entities

import com.mew.boilerplate.common.types.BaseEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "example_user")
class User
    (
    id: UUID? = null,
    var email: String,
    var username: String,
    var password: String,
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "details_id", nullable = false)
    var details: PersonalInfo,
    @ManyToMany
    var roles: Collection<Role>? = null
) : BaseEntity(id) {

    @CreatedDate
    var createdAt: Date? = null

    @LastModifiedDate
    var updatedAt: Date? = null
}