package com.fiordy.proshop.users.dto

import java.time.Instant

data class UserDetailsDto (
    var id          : String?,
    var isAdmin     : Boolean,
    var name        : String,
    var email       : String,
    var password    : String,
    var createdAt   : Instant?,
    var updatedAt   : Instant?
)