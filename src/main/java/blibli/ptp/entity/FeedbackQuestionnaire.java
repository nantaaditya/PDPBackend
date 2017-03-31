package blibli.ptp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=FeedbackQuestionnaire.TABLE_NAME)
public class FeedbackQuestionnaire implements Serializable{
	public static final String TABLE_NAME = "PTP_FEEDBACK_QUESTIONNAIRE";
	public static final String ID  = "FEEDBACK_QUESTIONNAIRE_ID";
	public static final String QUESTIONNAIRE_GROUP = "QUESTIONNAIRE_GROUP";
	public static final String QUESTIONNAIRE = "QUESTIONNAIRE";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=ID)
	private long id;
	@Column(name=QUESTIONNAIRE_GROUP)
	private String questinnaireGroup;
	@Column(name=QUESTIONNAIRE)
	private String questionnaire;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestinnaireGroup() {
		return questinnaireGroup;
	}
	public void setQuestinnaireGroup(String questinnaireGroup) {
		this.questinnaireGroup = questinnaireGroup;
	}
	public String getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(String questionnaire) {
		this.questionnaire = questionnaire;
	}
		
}
