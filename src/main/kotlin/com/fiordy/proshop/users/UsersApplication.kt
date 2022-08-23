package com.fiordy.proshop.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.bind.annotation.*

@EnableReactiveMongoRepositories
@SpringBootApplication(exclude= [MongoAutoConfiguration::class, MongoDataAutoConfiguration::class])
class UsersApplication

fun main(args: Array<String>) {
	runApplication<UsersApplication>(*args)
}