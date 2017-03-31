package blibli.ptp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PTP_TRAINING_FEEDBACK")
public class TrainingFeedback implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long trainingFeedbackCode;
	@ManyToOne
	@JoinColumn(name="TRAINING_PROPOSAL_CODE")
	private TrainingProposal trainingProposal;
	private String feedbackType;
	private String fileLocationPath;
	/**
	 * METHOD
	 * 
	 */
	public long getTrainingFeedbackCode() {
		return trainingFeedbackCode;
	}
	public TrainingProposal getTrainingProposal() {
		return trainingProposal;
	}
	public String getFeedbackType() {
		return feedbackType;
	}
	public String getFileLocationPath() {
		return fileLocationPath;
	}
	public void setTrainingFeedbackCode(long trainingFeedbackCode) {
		this.trainingFeedbackCode = trainingFeedbackCode;
	}
	public void setTrainingProposal(TrainingProposal trainingProposal) {
		this.trainingProposal = trainingProposal;
	}
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	public void setFileLocationPath(String file) {
		this.fileLocationPath = file;
	}	
}
