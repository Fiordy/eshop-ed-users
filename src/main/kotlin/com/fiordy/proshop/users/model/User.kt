package com.fiordy.proshop.users.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.Instant

@Document("users")
data class User(

    @Field("_id") @Id   var id        : String? = null,
    @Field("isAdmin")   var isAdmin   : Boolean,
    @Field("name")      var name      : String,
    @Field("email")     var email     : String,
    @Field("password")  var password  : String,
    @Field("createdAt") var createdAt : Instant? = null,
    @Field("updatedAt") var updatedAt : Instant? = null

) : java.io.Serializable