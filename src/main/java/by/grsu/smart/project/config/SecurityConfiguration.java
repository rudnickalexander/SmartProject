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
                .usersByUsernameQuery("select email, password, isDeleted from user where email = ?");
//                .authoritiesByUsernameQuery("select email, role from user_roles where email = ?")
//                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .and();
        http.formLogin().permitAll();
        http.logout().permitAll();
        http.authorizeRequests()
                .antMatchers("/").permitAll();
//                .antMatchers("/").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/saveProject**").hasRole("ADMIN")
//                .and().formLogin().loginPage("/login")
//                .usernameParameter("ssoId").passwordParameter("password")/*
//                .and().exceptionHandling().accessDeniedPage("/accessdenied")*/;
    }

//    @Bean
//    public ShaPasswordEncoder passwordEncoder() {
//        return new ShaPasswordEncoder();
//    }
}
