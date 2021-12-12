package com.mew.boilerplate.example.db.entities

import com.mew.boilerplate.common.types.BaseEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "role")
class Role
    (
    id: UUID? = null,
    val name: String,
    @ManyToMany
    var users: Collection<User>? = null
) : BaseEntity(id) {

    @CreatedDate
    var createdAt: Date? = null

    @LastModifiedDate
    var updatedAt: Date? = null
}