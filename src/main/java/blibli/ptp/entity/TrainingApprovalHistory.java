package blibli.ptp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import blibli.ptp.base.ApprovalStateEnum;
import blibli.ptp.base.WorkflowStateEnum;

@Entity
@Table(name="PTP_TRAINING_APPROVAL_HISTORY")
public class TrainingApprovalHistory implements Serializable{

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long approvalHistoryCode;
	@Id
	@ManyToOne
	@JoinColumn(name="TRAINING_PROPOSAL_CODE")
	private TrainingProposal trainingProposal;
	@ManyToOne
	@JoinColumn(name="INITIATOR")
	private User employee;
	private Date date;
	@Enumerated(EnumType.STRING)
	private WorkflowStateEnum workflowState;
	@Enumerated(EnumType.STRING)
	private ApprovalStateEnum approvalState;
	private String description;
	
//	public long getApprovalHistoryCode() {
//		return approvalHistoryCode;
//	}
	public User getEmployee() {
		return employee;
	}
	public Date getDate() {
		return date;
	}
	public WorkflowStateEnum getWorkflowState() {
		return workflowState;
	}
	public ApprovalStateEnum getApprovalState() {
		return approvalState;
	}
	public String getDescription() {
		return description;
	}
//	public void setApprovalHistoryCode(long approvalHistoryCode) {
//		this.approvalHistoryCode = approvalHistoryCode;
//	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setWorkflowState(WorkflowStateEnum workflowState) {
		this.workflowState = workflowState;
	}
	public void setApprovalState(ApprovalStateEnum approvalState) {
		this.approvalState = approvalState;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
