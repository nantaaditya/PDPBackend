package blibli.ptp.dto;

import io.swagger.annotations.ApiModelProperty;

public class AccessibilityDTO {
	@ApiModelProperty(allowableValues="ACCSSBLTY_CNF_GLOBAL, ACCSSBLTY_CNF_FB_QUESTIONNAIRE, ACCSSBLTY_CNF_DEPARTMENT, ACCSSBLTY_CNF_EMPLOYEE, ACCSSBLTY_PRPSL_WORKFLOW, ACCSSBLTY_PRPSL_APPROVAL, ACCSSBLTY_PRPSL_TRAINING, ACCSSBLTY_PDP")
	private String accessibility;
	private String description;
	
	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
