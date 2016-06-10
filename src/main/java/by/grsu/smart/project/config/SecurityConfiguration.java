package by.grsu.smart.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email, password, isEnabled from User where email = ?")
                .authoritiesByUsernameQuery("select user_email, role from user_roles where user_email = ?")
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .httpBasic();
////        http.csrf()
////                .disable()
////                .authorizeRequests()
////                .antMatchers("/static/**").permitAll()
////                .and();
////        http.formLogin().permitAll().loginPage("/login");
////
////        http.logout().permitAll();
////        http.authorizeRequests()
////                .antMatchers("/main").hasAnyRole("USER", "ADMIN");
////                .and().formLogin().loginPage("/login");
////                .antMatchers("/").hasAnyRole("ADMIN", "USER")
////                .antMatchers("/saveProject**").hasRole("ADMIN")
////                .and().formLogin().loginPage("/login")
////                .usernameParameter("ssoId").passwordParameter("password")/*
////                .and().exceptionHandling().accessDeniedPage("/accessdenied")*/;
//    }

    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        return new ShaPasswordEncoder();
    }
}
