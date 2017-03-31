package blibli.ptp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name=PersonalDevelopmentPlan.TABLE_NAME)
public class PersonalDevelopmentPlan implements Serializable{
	public static final String TABLE_NAME 		= "PTP_PERSONAL_DEVELOPMENT_PLAN";
	public static final String PDP_CODE			= "PDP_CODE";
	public static final String YEAR			 	= "YEAR";
	public static final String CREATED			= "CREATED";
	public static final String USER_CODE		= "USER_CODE";		
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=PDP_CODE)
	private long pdpCode;
	@DateTimeFormat(pattern="yyyy")
	@Column(name=YEAR)
	private Date year;
	@Column(name=CREATED)
	private Date created;	
	@ManyToOne
	@JoinColumn(name=USER_CODE)
	private User employee;
	@OneToMany(mappedBy="personalDevelopmentPlan")
	private List<PersonalDevelopmentPlanItem> personalDevelopmentPlanItems;
	
	public long getPdpCode() {
		return pdpCode;
	}
	public void setPdpCode(long pdpCode) {
		this.pdpCode = pdpCode;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public List<PersonalDevelopmentPlanItem> getPersonalDevelopmentPlanItems() {
		return personalDevelopmentPlanItems;
	}
	public void setPersonalDevelopmentPlanItems(List<PersonalDevelopmentPlanItem> personalDevelopmentPlanItems) {
		this.personalDevelopmentPlanItems = personalDevelopmentPlanItems;
	}
	
	
}
