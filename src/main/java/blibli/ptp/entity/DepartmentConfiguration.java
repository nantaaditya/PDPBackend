package blibli.ptp.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name=DepartmentConfiguration.TABLE_NAME)
public class DepartmentConfiguration implements Serializable{
	public static final String TABLE_NAME = "PTP_DEPARTMENT_CONFIGURATION";
	public static final String YEAR  = "YEAR";
	public static final String QUOTA_COUNTER = "QUOTA_COUNTER";	
	public static final String DEPARTMENT_CODE = "DEPARTMENT_CODE";
		
	@Id
	@DateTimeFormat(pattern="yyyy")
	@Column(name=YEAR)
	private Date year;
	@ManyToOne
	@JoinColumn(name=DEPARTMENT_CODE)
	private Department department;
	@Column(name=QUOTA_COUNTER)
	private BigInteger quotaCounter;
	
	public BigInteger getQuotaCounter() {
		return quotaCounter;
	}
	public Date getYear() {
		return year;
	}
	public Department getDepartment() {
		return department;
	}	
	public void setQuotaCounter(BigInteger quotaCounter) {
		this.quotaCounter = quotaCounter;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}	
	
}