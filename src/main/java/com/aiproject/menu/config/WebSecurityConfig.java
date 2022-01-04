package com.aiproject.menu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
        // .anyRequest().permitAll();
                // image 폴더를 login 없이 허용
                .antMatchers("/img/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // js 폴더를 login 없이 허용
                .antMatchers("/js/**").permitAll()
                // 회원 관리 URL 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
                // h2-console URL을 login 없이 허용
                .antMatchers("/h2-console/**").permitAll() // h2디비를 사용 안하면 없어도 됨
                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated() // 어떤 요청이든 로그인 과정이 없으면 로그인을 하게 한다
                .and()
                .formLogin() // 로그인 페이지에 대해서는 허용
                .loginPage("/user/login") // 로그인 위치
                .loginProcessingUrl("/user/login") // 로그인 에러 위치
                .defaultSuccessUrl("/") // 로그인한 후 이동할 페이지
                .permitAll()
                .and()
                .logout() // 로그아웃 기능 허용
                .logoutUrl("/user/logout")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/user/forbidden"); // 인가되지 않았을 때 이동할 페이지
    }
}
