package blibli.ptp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name=Company.TABLE_NAME)
public class Company implements Serializable{
	public static final String TABLE_NAME	= "PTP_COMPANY";
	public static final String COMPANY_CODE	= "COMPANY_CODE";
	public static final String COMPNAY_NAME	= "COMPANY_NAME";
	
	@Id
	@Column(name=COMPANY_CODE)
	private String companyCode;
	@Column(name=COMPNAY_NAME)
	private String companyName;
	@OneToMany(mappedBy="company")
	private List<User> listEmployee;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public List<User> getListEmployee() {
		return listEmployee;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setListEmployee(List<User> listEmployee) {
		this.listEmployee = listEmployee;
	}
			
}