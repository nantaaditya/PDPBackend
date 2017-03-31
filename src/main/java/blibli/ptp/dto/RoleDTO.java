package blibli.ptp.dto;

import io.swagger.annotations.ApiModelProperty;

public class RoleDTO {
	@ApiModelProperty(allowableValues="ROLE_EMPLOYEE, ROLE_REVIEWER, ROLE_ADMIN")
	private String role;
	private String description;
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
