package blibli.ptp.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import blibli.ptp.exception.JwtInvalidAuthenticationTokenException;
import blibli.ptp.model.JwtAuthenticationToken;

public class JwtAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

  public JwtAuthenticationProcessingFilter() {
    super("/**");
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    String jwtToken = request.getHeader("Authorization");
    if (StringUtils.isEmpty(jwtToken)) {
      throw new JwtInvalidAuthenticationTokenException("Invalid JWT token");
    }
    JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(jwtToken);
    return getAuthenticationManager().authenticate(jwtAuthenticationToken);
  }

  @Override
  protected boolean requiresAuthentication(
      HttpServletRequest request, HttpServletResponse response) {
    return true;
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);
    chain.doFilter(request, response);
  }
}
