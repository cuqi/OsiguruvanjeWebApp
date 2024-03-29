package com.webapp.insurance;
 
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 
@Configuration
public class SecurityConfig {
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
 
        return authProvider;
    }
 
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
        .requiresChannel(channel -> 
            channel.anyRequest().requiresSecure())
        .authorizeRequests(authorize -> {
            try {
                authorize.antMatchers("/insurance/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/process_login")
                        .successHandler(appAuthenticationSuccessHandler())
                        .permitAll()
                    .and()
                    .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/").permitAll();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).build();
    }
}
        // .authorizeRequests()
        //     .antMatchers("/insurance/**").authenticated()
        //     .anyRequest().permitAll()
        //     .and()
        //     .formLogin()
        //         .loginPage("/login")
        //         .loginProcessingUrl("/process_login")
        //         .successHandler(appAuthenticationSuccessHandler())
        //         .permitAll()
        //     .and()
        //     .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/").permitAll()
 
 
 
        // http.requiresChannel(channel -> 
//         // channel.anyRequest().requiresSecure())
//         // .authorizeRequests(authorize -> authorize.anyRequest().permitAll()).build();
//         //     .antMatchers("/insurance/**").authenticated()
//         //     .anyRequest().permitAll()
//         //     .and()
//         //     .formLogin()
//         //         .loginPage("/login")
//         //         .loginProcessingUrl("/process_login")
//         //         .successHandler(appAuthenticationSuccessHandler())
//         //         //.successForwardUrl("/index")
//         //         //.defaultSuccessUrl("/index.html", true)
//         //         .permitAll()
//         //     .and()
//         //     .logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/").permitAll();
 
//         // http.csrf().disable();
