package com.fiordy.proshop.users.kafka.consumers

import com.fiordy.proshop.users.model.User
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import com.fiordy.proshop.users.repository.UserRepository
import org.apache.kafka.clients.consumer.ConsumerRecord


@Component
class UserConsumer(
    private val userRepo: UserRepository
){

    @KafkaListener(topics = ["user-created"])
    fun onUserCreated(record: ConsumerRecord<String, User>) {
        val user = record.value()!!
        println("""
            Received event on topic: ${record.topic()}:
            Event:          ${record.headers()}
            User name:      ${user.name}
            User email:     ${user.email}
        """)
    }

}