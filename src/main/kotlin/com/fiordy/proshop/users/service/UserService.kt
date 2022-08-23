package com.fiordy.proshop.users.service

import com.fiordy.proshop.users.dto.CreateUserDto
import com.fiordy.proshop.users.dto.UserDetailsDto
import com.fiordy.proshop.users.kafka.producers.UserProducer
import com.fiordy.proshop.users.model.User
import com.fiordy.proshop.users.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Instant

@Service
class UserService(
    private val producer: UserProducer,
    private val repo: UserRepository
) {
    fun createUser(req: Mono<CreateUserDto>): Mono<UserDetailsDto> = req
        .map {
            User(
                isAdmin = it.isAdmin,
                name = it.name,
                email = it.email,
                password = it.password,
                createdAt = Instant.now(),
                updatedAt = Instant.now()
            )
        }
        .doOnNext {
            repo.save(it)
        }
        .doOnSuccess {
            producer.onCreated(it)
        }
        .map {
            UserDetailsDto(
                id = it.id,
                isAdmin = it.isAdmin,
                name = it.name,
                email = it.email,
                password = it.password,
                createdAt = Instant.now(),
                updatedAt = Instant.now()
            )
        }
}