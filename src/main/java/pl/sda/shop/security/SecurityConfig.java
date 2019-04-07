package pl.sda.shop.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers(
                        "/h2-console/**",
                        "/",
                        "/templates/**",
                        "/static/**",
                        "/webjars/**").permitAll()
                .antMatchers("/customers/**","/customer/**")
                .hasRole("CUSTOMER")
                .antMatchers("/products/**","/product/**")
                .hasRole("PRODUCT")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/")
                .and()
                .headers().frameOptions().disable().and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("product").password("{noop}password").roles("PRODUCT")
                .and()
                .withUser("customer").password("{noop}password").roles("CUSTOMER")
                .and()
                .withUser("admin").password("{noop}password").roles("ADMIN", "CUSTOMER", "PRODUCT");
    }
}
