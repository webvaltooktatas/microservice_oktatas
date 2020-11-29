package hu.webvalto.bevallaslekerdezes.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.mvcMatcher("/**")
                .authorizeRequests().anyRequest().access("hasAuthority('SCOPE_read')")
                .and()
                .oauth2ResourceServer().jwt();
    }
}
