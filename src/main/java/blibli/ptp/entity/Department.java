package blibli.ptp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name=Department.TABLE_NAME)
public class Department implements Serializable {
	public static final String TABLE_NAME = "PTP_DEPARTMENT";
	public static final String DEPARTMENT_CODE  = "DEPARTMENT_CODE";
	public static final String DEPARTMENT_NAME = "DEPRTMENT_NAME";
	
	@Id	
	@Column(name=DEPARTMENT_CODE)
	private String departmentCode;
	@Column(name=DEPARTMENT_NAME)
	private String departmentName;
	@OneToMany(mappedBy="department")	
	private List<DepartmentConfiguration> listDepartmentConfig;
	@OneToMany(mappedBy="department")
	private List<User> listEmployee;
		
	public String getDepartmentCode() {
		return departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public List<DepartmentConfiguration> getListDepartmentConfig() {
		return listDepartmentConfig;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setListDepartmentConfig(List<DepartmentConfiguration> listDepartmentConfig) {
		this.listDepartmentConfig = listDepartmentConfig;
	}
		
}