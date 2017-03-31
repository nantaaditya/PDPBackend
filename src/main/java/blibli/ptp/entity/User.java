package blibli.ptp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(
    name = User.TABLE_NAME,
    uniqueConstraints = {@UniqueConstraint(columnNames = {User.COLUMN_USERNAME})}
)
public class User implements Serializable {

  public static final String TABLE_NAME = "PTP_USER";
  public static final String COLUMN_ID 	= "USER_ID";
  public static final String COLUMN_MARK_FOR_DELETE = "MARK_FOR_DELETE";
  public static final String COLUMN_USERNAME	= "USERNAME";
  public static final String COLUMN_PASSWORD	= "PASSWORD";
  public static final String COLUMN_NAME		= "NAME";
  public static final String COLUMN_EMAIL		= "EMAIL";
  public static final String COLUMN_POSITION	= "POSITION";
  public static final String COLUMN_ACTIVE		= "STATUS";
  public static final String COLUMN_ROLE		= "ROLE";
  public static final String COLUMN_ACCESSIBILITY	= "ACCESSIBILITY";
  public static final String COLUMN_DIRECT_SUPERIOR	= "DIRECT_SUPERIOR";
  public static final String COLUMN_COMPANY_CODE	= "COMPANY_CODE";
  public static final String COLUMN_DEPARTMENT_CODE	= "DEPARTMENT_CODE";

  @Id
  @Column(name = User.COLUMN_ID)
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")  
  private String id;
  @Column(name = User.COLUMN_USERNAME, nullable = false)
  private String username;
  @Column(name = User.COLUMN_PASSWORD, nullable = false)
  private String password;
  @Column(name = User.COLUMN_NAME, nullable = false)
  private String name;
  @Column(name = User.COLUMN_EMAIL, nullable = false)
  private String email;
  @Column(name = User.COLUMN_POSITION, nullable = false)
  private String position;
  @Column(name = User.COLUMN_ACTIVE, nullable = false)
  private boolean active;
  @Column(name = User.COLUMN_MARK_FOR_DELETE)
  private boolean markForDelete = false;
  @ManyToOne(optional=true)
  @JoinColumn(name=COLUMN_DIRECT_SUPERIOR, nullable=true)
  private User directSuperior;
  @OneToMany(mappedBy="directSuperior")
  private List<User> subordinateEmployee;
  @ManyToOne
  @JoinColumn(name=COLUMN_COMPANY_CODE)
  private Company company;										
  @ManyToOne
  @JoinColumn(name=COLUMN_DEPARTMENT_CODE)	
  private Department department;								
  @OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
  private List<PersonalDevelopmentPlan> listPDP;
  @OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
  private List<TrainingProposal> listTrainingProposal;
  @OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
  private List<TrainingApprovalHistory> listTrainingApprovalHistories;
  @ManyToMany
  @JoinTable(name="PTP_USER_ROLE", 
  	joinColumns={@JoinColumn(name="USER_ID")},
  	inverseJoinColumns={@JoinColumn(name="ROLE_CODE")}
  )
  @Column(name = COLUMN_ROLE)
  private List<Role> listRole;
  
  @ManyToMany
  @JoinTable(name="PTP_USER_ACCESSIBILITY",
  	joinColumns={@JoinColumn(name="USER_ID")},
  	inverseJoinColumns={@JoinColumn(name="ACCESSIBILITY_CODE")}
  )
  @Column(name = User.COLUMN_ACCESSIBILITY)
  private List<Accessibility> listAccessibility;  
  
  @JoinTable(name="PTP_USER_DEPARTMENTCONFIG", 
	joinColumns={@JoinColumn(name="USER_CODE")},
	inverseJoinColumns={@JoinColumn(name="DEPARTMENTCONFIG_CODE")}
  )
  @ElementCollection(targetClass=DepartmentConfiguration.class)
  private List<DepartmentConfiguration> listDepartmentConfiguration;	//

  public User() {
  }

  public User(String id, boolean markForDelete, String username, String password, String name) {
    this.id = id;
    this.markForDelete = markForDelete;
    this.username = username;
    this.password = password;
    this.name = name;
  }

  public User(
      String id,
      boolean markForDelete,
      String username,
      String password,
      String name,
      String email) {
    this(id, markForDelete, username, password, name);
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isMarkForDelete() {
    return markForDelete;
  }

  public void setMarkForDelete(boolean markForDelete) {
    this.markForDelete = markForDelete;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
	return position;
  }
  
  public void setPosition(String position) {
	this.position = position;
  }

  public boolean isActive() {
	return active;
  }

  public void setActive(boolean active) {
	this.active = active;
  }

  public List<Role> getListRole() {
	return listRole;
  }

  public void setListRole(List<Role> listRole) {
	this.listRole = listRole;
  }

  public List<Accessibility> getListAccessibility() {
	return listAccessibility;
  }

  public void setListAccessibility(List<Accessibility> listAccessibility) {
	this.listAccessibility = listAccessibility;
  }

  public User getDirectSuperior() {
	return directSuperior;
  }

  public void setDirectSuperior(User directSuperior) {
	this.directSuperior = directSuperior;
  }

  public Company getCompany() {
	return company;
  }

  public void setCompany(Company company) {
	this.company = company;
  }

  public Department getDepartment() {
	return department;
  }

  public void setDepartment(Department department) {
	this.department = department;
  }

  public List<PersonalDevelopmentPlan> getListPDP() {
	return listPDP;
  }

  public void setListPDP(List<PersonalDevelopmentPlan> listPDP) {
	this.listPDP = listPDP;
  }

  public List<TrainingProposal> getListTrainingProposal() {
	return listTrainingProposal;
  }

  public void setListTrainingProposal(List<TrainingProposal> listTrainingProposal) {
	this.listTrainingProposal = listTrainingProposal;
  }

  public List<TrainingApprovalHistory> getListTrainingApprovalHistories() {
	return listTrainingApprovalHistories;
  }

  public void setListTrainingApprovalHistories(List<TrainingApprovalHistory> listTrainingApprovalHistories) {
	this.listTrainingApprovalHistories = listTrainingApprovalHistories;
  }

  public List<DepartmentConfiguration> getListDepartmentConfiguration() {
	return listDepartmentConfiguration;
  }

  public void setListDepartmentConfiguration(List<DepartmentConfiguration> listDepartmentConfiguration) {
	this.listDepartmentConfiguration = listDepartmentConfiguration;
  }

  public List<User> getSubordinateEmployee() {
	return subordinateEmployee;
}

public void setSubordinateEmployee(List<User> subordinateEmployee) {
	this.subordinateEmployee = subordinateEmployee;
}

@Override
  public String toString() {
    return "User{"
        + "id='"
        + id
        + '\''
        + ", markForDelete="
        + markForDelete
        + ", username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", name='"
        + name
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
