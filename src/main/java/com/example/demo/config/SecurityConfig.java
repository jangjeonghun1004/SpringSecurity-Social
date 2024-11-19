package com.example.demo.config;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SecurityConfig {

    // The request was rejected because the URL contained a potentially malicious String "//"
    @Bean
    public HttpFirewall httpFirewall() {
        StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
        strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
        return strictHttpFirewall;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        //.requestMatchers("/**").permitAll()
                        .requestMatchers("/","/WEB-INF/views/index.jsp").permitAll()
                        .requestMatchers("/login","/WEB-INF/views/login.jsp").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/loginResult", true)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        //.logoutSuccessUrl("/index")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .addLogoutHandler((request, response, authentication) -> {
                            // Optional: Add additional logout logic if needed
                        })
                        .logoutSuccessHandler((request, response, authentication) -> {
                            // After logout, redirect to Google Logout URL
                            //response.sendRedirect("/index");
                        })
                );

        return http.build();
    }

}
