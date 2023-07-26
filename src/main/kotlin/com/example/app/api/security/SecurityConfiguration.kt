package com.example.app.api.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
// @Import(SecurityProblemSupport::class)
class SecurityConfiguration {
    /* @Autowired
    private lateinit var problemSupport: SecurityProblemSupport */

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.csrf { it.disable() }
            .authorizeHttpRequests {
                it.anyRequest().permitAll()
            }
            .exceptionHandling {
                //          it.authenticationEntryPoint(problemSupport)
                //        it.accessDeniedHandler(problemSupport)
            }
        return httpSecurity.build()
    }

}