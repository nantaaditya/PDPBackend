package blibli.ptp.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import blibli.ptp.base.WorkflowStateEnum;

@Entity
@Table(name="PTP_TRAINING_PROPOSAL_HISTORY")
public class TrainingProposalHistory implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private long trainingProposalHistoryCode;
	@Id
	@ManyToOne
	@JoinColumn(name="TRAINING_PROPOSAL_CODE")
	private TrainingProposal trainingProposal;
	@Enumerated(EnumType.STRING)
	private WorkflowStateEnum workflowState;
	private String  description;
	
	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}
	public WorkflowStateEnum getWorkflowState() {
		return workflowState;
	}
	public String getDescription() {
		return description;
	}
	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}
	public void setWorkflowState(WorkflowStateEnum workflowState) {
		this.workflowState = workflowState;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public long getTrainingProposalHistoryCode() {
//	return trainingProposalHistoryCode;
//}
//	public void setTrainingProposalHistoryCode(long trainingProposalHistoryCode) {
//		this.trainingProposalHistoryCode = trainingProposalHistoryCode;
//	}
}
