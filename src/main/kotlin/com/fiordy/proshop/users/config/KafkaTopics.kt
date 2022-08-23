package com.fiordy.proshop.users.config

import com.fiordy.proshop.users.kafka.shared.UserEvents
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin


@Configuration
class KafkaTopics {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        return KafkaAdmin(configs)
    }

    @Bean
    fun userCreated(): NewTopic {
        return NewTopic(UserEvents.CREATED, 3, 3)
    }

    @Bean
    fun userUpdated(): NewTopic {
        return NewTopic(UserEvents.UPDATED, 3, 3)
    }

    @Bean
    fun userDeleted(): NewTopic {
        return NewTopic(UserEvents.DELETED, 3, 3)
    }

    @Bean
    fun userVerified(): NewTopic {
        return NewTopic(UserEvents.VERIFIED, 3, 3)
    }
}