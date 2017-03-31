package blibli.ptp.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private String token;

	public JwtAuthenticationToken(String token) {
		super(null, null);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
	    return "JwtAuthenticationToken{" + "token='" + token + '\'' + '}';
	}
}
