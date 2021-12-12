package com.mew.boilerplate.example.types

enum class UserRole(var value: String) {
    GUEST(Names.GUEST),
    USER(Names.USER),
    ADMIN(Names.ADMIN);

    class Names {
        companion object {
            const val GUEST = "guest"
            const val USER = "user"
            const val ADMIN = "admin"
        }
    }
}