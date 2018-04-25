package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//ログインしていなくてもこのフォルダは表示できるようにする
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                    .antMatchers("/loginForm","/accountcreate").permitAll()
                    .antMatchers("/**").hasRole("ACCOUNT")
                    .anyRequest().authenticated()
            .and()
            .formLogin().loginProcessingUrl("/login")
                    .loginPage("/loginForm")
                    .failureUrl("/loginForm?error")
                    .defaultSuccessUrl("/shopping", true)
                    .usernameParameter("loginid").passwordParameter("pass")
            .and()
            .logout()
                    .logoutSuccessUrl("/loginForm");
    }
    
    //パスワードを暗号化するメソッド
    @Bean
    PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
    
}