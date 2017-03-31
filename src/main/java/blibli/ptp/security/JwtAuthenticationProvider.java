package blibli.ptp.security;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import blibli.ptp.entity.Accessibility;
import blibli.ptp.entity.Role;
import blibli.ptp.entity.User;
import blibli.ptp.exception.JwtInvalidAuthenticationTokenException;
import blibli.ptp.exception.UnauthorizedException;
import blibli.ptp.model.JwtAuthenticationToken;
import blibli.ptp.model.JwtUserDetails;
import blibli.ptp.service.SessionService;
import blibli.ptp.service.UserService;
import blibli.ptp.util.Credential;
import io.jsonwebtoken.Claims;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

  @Autowired
  private UserService userService;

  @Autowired
  private SessionService sessionService;
  
  private Logger log = Logger.getLogger(JwtAuthenticationProvider.class);

  @Override
  protected void additionalAuthenticationChecks(
      UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException {
  }

  @Override
  protected UserDetails retrieveUser(
      String username, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException {
    JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;    
    String jwtToken = jwtAuthenticationToken.getToken();
    Claims claims = this.userService.parseJwtToken(jwtToken);
    log.info("Subject "+claims.getSubject());    
    
    if (claims == null) {
      throw new JwtInvalidAuthenticationTokenException("Invalid JWT token");
    }
    
    if (StringUtils.isEmpty(claims.getSubject())) {
      throw new JwtInvalidAuthenticationTokenException("Invalid JWT token");
    }
        
    
    User user = new User();    
    try{
    	user = userService.findByUsername(claims.getSubject());
    	log.info(user.getListRole());
    }catch(Exception e){
    	System.out.println(e);
    }
    String role = converterListRole(user.getListRole());
    String accessibility = converterListAccessibility(user.getListAccessibility());
    Credential.setUsername(claims.getSubject());
    Credential.setSessionId(String.valueOf(claims.get("sessionId")));
    Credential.setRole(role);
    Credential.setAccessibility(accessibility);
    boolean isAuthorized = false;
    
    try {
      isAuthorized = this.sessionService.isAuthorized();
    } catch (Exception e) {
      throw new UnauthorizedException(e.getMessage());
    }
    
    if (!isAuthorized) {
      throw new UnauthorizedException("Unauthorized api access");
    }
    
    return new JwtUserDetails(claims.getSubject(), jwtToken);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return JwtAuthenticationToken.class.isAssignableFrom(authentication);
  }

  public String converterListRole(List<Role> list){
	  return list.stream()
			  .map(Role::getCode)
			  .collect(Collectors.joining(","));
  }
  
  public String converterListAccessibility(List<Accessibility> list){
	  return list.stream()
			  .map(Accessibility::getCode)
			  .collect(Collectors.joining(","));
  }
  
}