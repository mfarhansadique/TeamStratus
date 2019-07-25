package stratus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.Authenticator;

@Configuration
@EnableWebSecurity


public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private GYWUserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        System.out.println("configuring aithorisation with UDS= " + userDetailsService.toString());

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users/**").hasRole("A")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("A")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}


