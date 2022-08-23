package com.fiordy.proshop.users.controllers

import com.fiordy.proshop.users.dto.CreateUserDto
import com.fiordy.proshop.users.dto.UserDetailsDto
import com.fiordy.proshop.users.service.UserService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/users")
@RestController
class UserController(
    val service: UserService
) {

    @RequestMapping(
        method = [RequestMethod.POST]
    )
    fun createUser(@RequestBody req: Mono<CreateUserDto>): Mono<UserDetailsDto> {
        return service.createUser(req)
    }
}