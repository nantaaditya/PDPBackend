package blibli.ptp.util;

import java.util.List;

import org.slf4j.MDC;

public final class Credential {

	public static final String CREDENTIAL_USERNAME		= "USERNAME";
	public static final String CREDENTIAL_SESSION_ID	= "SESSION_ID";
	public static final String CREDENTIAL_HOSTNAME		= "HOSTNAME";
	public static final String CREDENTIAL_REQUEST_ID	= "REQUEST_ID";
	public static final String CREDENTIAL_ROLE			= "ROLE";
	public static final String CREDENTIAL_ACCESSBILITY	= "ACCESSBILITY";

	private Credential() {}

	public static String getUsername() {
		return MDC.get(Credential.CREDENTIAL_USERNAME);
	}

	public static void setUsername(String username) {
		MDC.put(Credential.CREDENTIAL_USERNAME, username);
	}

	public static String getSessionId() {
		return MDC.get(Credential.CREDENTIAL_SESSION_ID);
	}

	public static void setSessionId(String sessionId) {
		MDC.put(Credential.CREDENTIAL_SESSION_ID, sessionId);
	}

	public static String getHostname() {
		return MDC.get(Credential.CREDENTIAL_HOSTNAME);
	}

	public static void setHostname(String hostname) {
		MDC.put(Credential.CREDENTIAL_HOSTNAME, hostname);
	}

	public static String getRequestId() {
		return MDC.get(Credential.CREDENTIAL_REQUEST_ID);
	}

	public static void setRequestId(String requestId) {
		MDC.put(Credential.CREDENTIAL_REQUEST_ID, requestId);
	}
	
	public static void setRole(String listRole){
		MDC.put(Credential.CREDENTIAL_ROLE, listRole);
	}
	
	public static String getRole(){
		return MDC.get(Credential.CREDENTIAL_ROLE);
	}
	
	public static void setAccessibility(String listAccessibility){
		MDC.put(Credential.CREDENTIAL_ACCESSBILITY, listAccessibility);
	}
	
	public static String getAccessibility(){
		return MDC.get(Credential.CREDENTIAL_ACCESSBILITY);
	}
}

