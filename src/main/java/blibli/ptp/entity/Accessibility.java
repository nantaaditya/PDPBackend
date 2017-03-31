package blibli.ptp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Accessibility.TABLE_NAME)
public class Accessibility {
	public static final String TABLE_NAME 		= "PTP_ACCESSIBILITY";
	public static final String ACCESSIBILITY 	= "ACCESSIBILITY_CODE";
	public static final String DESCRIPTION		= "ACCESSIBILITY_DESCRIPTION";
	
	@Id
	@Column(name=ACCESSIBILITY)
	private String code;
	@Column(name=DESCRIPTION)
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
