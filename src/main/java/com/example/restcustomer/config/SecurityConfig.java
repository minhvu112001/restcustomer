package com.example.restcustomer.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;
    //  @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth){
    //    try{
    //       auth.inMemoryAuthentication()
    //              .withUser("user").password("{noop}minhvu112001").roles("USER")
    //              .and()
    //              .withUser("admin").password("{noop}minhvu112001").roles("ADMIN");
    //   } catch (Exception e){
    //       e.printStackTrace();
    //  }
    // }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/customers").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.GET, "/api/customers/**").hasRole("EMPLOYEE")
                .antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER","ADMIN")
                .antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER","ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
}