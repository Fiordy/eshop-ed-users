package com.fiordy.proshop.users.dto

data class CreateUserDto (
    val isAdmin: Boolean,
    val name: String,
    val email: String,
    val password: String
) : java.io.Serializable {

    constructor() : this(false, "", "", "")
}