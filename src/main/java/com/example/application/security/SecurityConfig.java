package com.example.application.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurityConfigurerAdapter {

    public static final String LOGIN_URL = "/login";
    private static final String LOGIN_PROCESSING_URL = "/login";
    private static final String LOGIN_FAILURE_URL = "/login";

    public static final String LOGOUT_SUCCESS_URL = "/";
    public static final String ROLE_USER = "user";
    public static final String ROLE_ADMIN = "admin";
    // @Autowired
    // private UserInfoRepository userInfoRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        super.setLoginView(http, "/login", "/logout");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/public/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(username -> {
            System.out.println("Asking details for user: " + username);
            return new User(username, passwordEncoder().encode("foo"),
                    Arrays.asList(new SimpleGrantedAuthority(ROLE_ADMIN)));
            // UserInfo userInfo = userInfoRepository.findByUsername(username);
            // if (userInfo == null) {
            // throw new UsernameNotFoundException(
            // "No user present with username: " + username);
            // } else {
            // return new User(userInfo.getUsername(),
            // userInfo.getEncodedPassword(),
            // userInfo.getRoles().stream()
            // .map(role -> new SimpleGrantedAuthority(
            // "ROLE_" + role))
            // .collect(Collectors.toList()));
            // }
        });
    }

}
