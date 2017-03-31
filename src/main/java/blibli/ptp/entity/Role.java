package blibli.ptp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name=Role.TABLE_NAME)
public class Role implements Serializable{
	public static final String TABLE_NAME = "PTP_ROLE";
	public static final String ROLE_CODE  = "ROLE_CODE";
	public static final String ROLE_DESCRIPTION = "ROLE_DESCRIPTION"; 
	
	@Id
	@Column(name=ROLE_CODE)
	@ApiModelProperty(allowableValues="ROLE_EMPLOYEE, ROLE_REVIEWER, ROLE_ADMIN")
	private String code;
	@Column(name=ROLE_DESCRIPTION)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
