package blibli.ptp.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import blibli.ptp.base.TrainingTypeEnum;
import blibli.ptp.base.WorkflowStateEnum;

@Entity
@Table(name="PTP_TRAINING_PROPOSAL")
public class TrainingProposal implements Serializable{
	/**
	 * VARIABLE
	 */
	@Id	
	@Column(name="TRAINING_PROPOSAL_CODE")
	private String trainingCode;
	private String trainingTopic;
	@Enumerated(EnumType.STRING)
	private TrainingTypeEnum trainingType;
	private String trainingDescription;
	private Date startDate;
	private Date endDate;
	private String trainingVenue;
	private String vendor;
	private String vendorContactName;
	private String vendorPhone;
	private String vendorFax;
	private String vendorEmail;
	private double trainingCost;
	private double ticketCost;
	private double hotelCost;
	private long spbCode;
	@Enumerated(EnumType.STRING)
	private WorkflowStateEnum workflowState;
	@OneToOne
	@JoinColumn(name="PDP_ITEM_CODE")
	private PersonalDevelopmentPlanItem personalDevelopmentPlanItem;	
	private String note;	
	@ManyToOne
	@JoinColumn(name="USER_CODE")
	private User employee;
	@OneToMany(mappedBy="trainingProposal")
	private List<TrainingProposalHistory> listTrainingProposalHistory;
	@OneToMany(mappedBy="trainingProposal")
	private List<TrainingApproval> listTrainingApproval;
	@OneToMany(mappedBy="trainingProposal")
	private List<TrainingFeedback> listTrainingFeedbacks;
	
	public String getTrainingCode() {
		return trainingCode;
	}
	public String getTrainingTopic() {
		return trainingTopic;
	}
	public TrainingTypeEnum getTrainingType() {
		return trainingType;
	}
	public String getTrainingDescription() {
		return trainingDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public String getTrainingVenue() {
		return trainingVenue;
	}
	public String getVendor() {
		return vendor;
	}
	public String getVendorContactName() {
		return vendorContactName;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public String getVendorFax() {
		return vendorFax;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public double getTrainingCost() {
		return trainingCost;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public long getSpbCode() {
		return spbCode;
	}
	public WorkflowStateEnum getWorkflowState() {
		return workflowState;
	}	
	public String getNote() {
		return note;
	}
	public User getEmployee() {
		return employee;
	}
	public void setTrainingCode(String trainingCode) {
		this.trainingCode = trainingCode;
	}
	public void setTrainingTopic(String trainingTopic) {
		this.trainingTopic = trainingTopic;
	}
	public void setTrainingType(TrainingTypeEnum trainingType) {
		this.trainingType = trainingType;
	}
	public void setTrainingDescription(String trainingDescription) {
		this.trainingDescription = trainingDescription;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setTrainingVenue(String trainingVenue) {
		this.trainingVenue = trainingVenue;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setVendorContactName(String vendorContactName) {
		this.vendorContactName = vendorContactName;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public void setVendorFax(String vendorFax) {
		this.vendorFax = vendorFax;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public void setSpbCode(long spbCode) {
		this.spbCode = spbCode;
	}
	public void setWorkflowState(WorkflowStateEnum workflowState) {
		this.workflowState = workflowState;
	}		
	public void setNote(String note) {
		this.note = note;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public List<TrainingProposalHistory> getListTrainingProposalHistory() {
		return listTrainingProposalHistory;
	}
	public void setListTrainingProposalHistory(List<TrainingProposalHistory> listTrainingProposalHistory) {
		this.listTrainingProposalHistory = listTrainingProposalHistory;
	}
	public List<TrainingApproval> getListTrainingApproval() {
		return listTrainingApproval;
	}
	public void setListTrainingApproval(List<TrainingApproval> listTrainingApproval) {
		this.listTrainingApproval = listTrainingApproval;
	}
	public List<TrainingFeedback> getListTrainingFeedbacks() {
		return listTrainingFeedbacks;
	}
	public void setListTrainingFeedbacks(List<TrainingFeedback> listTrainingFeedbacks) {
		this.listTrainingFeedbacks = listTrainingFeedbacks;
	}
	public PersonalDevelopmentPlanItem getPersonalDevelopmentPlanItem() {
		return personalDevelopmentPlanItem;
	}
	public void setPersonalDevelopmentPlanItem(PersonalDevelopmentPlanItem personalDevelopmentPlanItem) {
		this.personalDevelopmentPlanItem = personalDevelopmentPlanItem;
	}
	public double getHotelCost() {
		return hotelCost;
	}
	public void setHotelCost(double hotelCost) {
		this.hotelCost = hotelCost;
	}	
}
