package com.fiordy.proshop.users.kafka.producers

import com.fiordy.proshop.users.kafka.shared.UserEvents
import com.fiordy.proshop.users.model.User
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


@Component
class UserProducer(
    private val kafka: KafkaTemplate<String, User>
) {

    fun onCreated(user: User) = send(UserEvents.CREATED, user)

    fun onUpdated( user: User) = send(UserEvents.UPDATED, user)

    fun onDeleted(user: User) = send(UserEvents.DELETED, user)

    fun onVerified(user: User) = send(UserEvents.VERIFIED, user)

    // aggregator function to wrap as record
    private fun send(topic: String, user: User) = kafka.send(topic, user)
}
