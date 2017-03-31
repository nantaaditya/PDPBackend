package blibli.ptp.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name=GlobalConfiguration.TABLE_NAME)
public class GlobalConfiguration implements Serializable{
	public static final String TABLE_NAME 		= "PTP_GLOBAL_CONFIGURATION";
	public static final String YEAR				= "YEAR";
	public static final String TRAINING_BUDGET	= "TRAINING_BUDGET";
	public static final String QUOTA_COUNTER	= "QUOTA_COUNTER";
	
	@Id	
	@DateTimeFormat(pattern="yyyy")
	@Column(name=YEAR)
	private Date year;
	@Column(name=TRAINING_BUDGET)
	private double trainingBudget;
	@Column(name=QUOTA_COUNTER)
	private BigInteger quotaCounter;
	
	public Date getYear() {
		return year;
	}
	public double getTrainingBudget() {
		return trainingBudget;
	}
	public BigInteger getQuotaCounter() {
		return quotaCounter;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public void setTrainingBudget(double trainingBudget) {
		this.trainingBudget = trainingBudget;
	}
	public void setQuotaCounter(BigInteger quotaCounter) {
		this.quotaCounter = quotaCounter;
	}		
}