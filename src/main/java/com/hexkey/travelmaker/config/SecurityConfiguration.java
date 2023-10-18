package com.hexkey.travelmaker.config;

import com.hexkey.travelmaker.user.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthenticationService authenticationService;

    public SecurityConfiguration(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // 비밀번호 암호화 제공
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                /* CSRF 공격 방지는 기본적으로 활성화되어 있어 비활성화 처리 */
                .csrf()
                .disable()
                /* 요청에 대한 권한 체크 */
                .authorizeHttpRequests()
                .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                /* hasRole에 전달하는 값은 "ROLE_"가 자동으로 앞에 붙는다. */
//                .antMatchers("/member/mypage").hasRole("MEMBER")
//                .antMatchers(HttpMethod.POST, "/admin/**").hasRole("ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
                /* 위에 서술된 패턴 외의 요청은 인증되지 않은 사용자도 요청 허가 */
                .anyRequest().permitAll()
                .and()
                /* 로그인 설정 */
                .formLogin()
                .loginPage("/user/user/login")
                .defaultSuccessUrl("/")
                .failureForwardUrl("/user/user/loginfail")
                .usernameParameter("memberId")
                .passwordParameter("memberPwd")
                .and()
                /* 로그아웃 설정 */
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .and()
                /* 인증, 인가 예외 처리 : 인증이 필요하면 로그인 페이지로 이동하므로 인가 처리만 설정 */
//                .exceptionHandling()
//                .accessDeniedPage("/error/denied")
//                .and()
                .build();
    }

}
