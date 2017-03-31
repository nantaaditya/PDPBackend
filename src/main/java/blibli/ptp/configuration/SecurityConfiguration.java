package blibli.ptp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import blibli.ptp.security.JwtAuthenticationEntryPoint;
import blibli.ptp.security.JwtAuthenticationProcessingFilter;
import blibli.ptp.security.JwtAuthenticationProvider;
import blibli.ptp.security.JwtAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  public JwtAuthenticationProcessingFilter authenticationProcessingFilter() throws Exception {
    JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter =
        new JwtAuthenticationProcessingFilter();
    jwtAuthenticationProcessingFilter.setAuthenticationManager(this.authenticationManager());
    jwtAuthenticationProcessingFilter.setAuthenticationSuccessHandler(
        new JwtAuthenticationSuccessHandler());
    return jwtAuthenticationProcessingFilter;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(this.jwtAuthenticationProvider);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
        .antMatchers(
        		"/api/login",
                "/api/signup",                
                "/swagger-ui*",
                "/webjars/springfox-swagger-ui/**",
                "/swagger-resources/**",
                "/configuration/**",
                "/v2/api-docs",
                "favicon.ico");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilterBefore(
        this.authenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    http.headers().cacheControl();
  }
}
