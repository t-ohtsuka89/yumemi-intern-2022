package com.example.demo

import com.example.demo.domain.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        println(userRepository.findByEmail(email))
        return userRepository
            .findByEmail(email)
            ?.let {
                UserDetailsImpl(
                    email = it.email,
                    username = it.username,
                    password = it.password,
                    authorities = listOf(SimpleGrantedAuthority("USER"))
                )
            } ?: throw UsernameNotFoundException("User not found")

    }
}