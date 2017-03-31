package blibli.ptp.dto;

import java.io.Serializable;
import java.util.List;

public class RegisterRequest implements Serializable {

  private String username;
  private String password;
  private String name;
  private String email;
  private String position;
  private String company;
  private String department;
  private boolean active;
  private List<String> listRole;
  private List<String> listAccessibility;
  private String directSuperior;

  public RegisterRequest() {
  }

  public RegisterRequest(String username, String password) {
    this.username = username;
    this.password = password;
    this.active	  = true;	
  }

  public RegisterRequest(String username, String password, String name) {
    this(username, password);
    this.name = name;
  }

  public RegisterRequest(String username, String password, String name, String email) {
    this(username, password, name);
    this.email = email;
  }
  
  public RegisterRequest(String username, String password, String name, String email, String position){
	  this(username, password, name, email);
	  this.position = position;
  }
  
  public RegisterRequest(String username, String password, String name, String email, String position, List<String> role, List<String> accessibility){
	  this(username, password, name, email, position);
	  this.listRole = role;
	  this.listAccessibility = accessibility;
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

  public List<String> getListRole() {
	return listRole;
  }

  public void setListRole(List<String> listRole) {
	this.listRole = listRole;
  }

  public List<String> getListAccessibility() {
	return listAccessibility;
  }

  public void setListAccessibility(List<String> listAccessibility) {
	this.listAccessibility = listAccessibility;
  }

  public String getCompany() {
	return company;
  }

  public void setCompany(String company) {
	this.company = company;
  }

  public String getDepartment() {
	return department;
  }

  public void setDepartment(String department) {
	this.department = department;
  }

  public String getDirectSuperior() {
	return directSuperior;
  }

  public void setDirectSuperior(String directSuperior) {
	this.directSuperior = directSuperior;
  }

  @Override
  public String toString() {
    return "RegisterRequest{"
        + "username='"
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
        + ", position='"
        + position
        + '\''
        + ", active='"
        + active
        + '\''
        + ", role='"
        + listRole.get(0)
        + '\''
        + ", accessibility='"
        + listAccessibility.get(0)
        + '\''
        + '}';
  }
}
