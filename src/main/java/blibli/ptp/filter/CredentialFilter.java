package blibli.ptp.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import blibli.ptp.util.Credential;


public class CredentialFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,FilterChain filterChain)
		throws ServletException, IOException {
			if (StringUtils.isEmpty(Credential.getSessionId())) {
				String sessionId = UUID.randomUUID().toString();
				Credential.setSessionId(sessionId);
			}
		    Credential.setHostname(httpServletRequest.getRemoteHost());
		    Credential.setRequestId(httpServletRequest.getParameter("requestId"));
		    filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
