package blibli.ptp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import blibli.ptp.entity.TrainingProposal;

@Entity
@Table(name=PersonalDevelopmentPlanItem.TABLE_NAME)
public class PersonalDevelopmentPlanItem implements Serializable{
	public static final String TABLE_NAME 		= "PTP_PERSONAL_DEVELOPMENT_PLAN_ITEM";
	public static final String PDP_ITEM_CODE	= "PDP_ITEM_CODE";
	public static final String DEVELOPMENT_PLAN	= "DEVELOPMENT_PLAN";
	public static final String PURPOSE			= "PURPOSE";
	public static final String PLANNING_STEP	= "PLANNING_STEP";
	public static final String SELECTED			= "SELECTED";
	public static final String PDP_CODE			= "PDP_CODE";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=PDP_ITEM_CODE)
	private long pdpItemCode;
	@Column(name=DEVELOPMENT_PLAN)	
	private String developmentPlan;
	@Column(name=PURPOSE)
	private String purpose;
	@Column(name=PLANNING_STEP)
	private String planningStep;
	@Column(name=SELECTED)
	private boolean selected;
	@ManyToOne
	@JoinColumn(name=PDP_CODE)
	private PersonalDevelopmentPlan personalDevelopmentPlan;
	@OneToOne(mappedBy="personalDevelopmentPlanItem")
	private TrainingProposal trainingProposal;
	
	public long getPdpItemCode() {
		return pdpItemCode;
	}
	public String getDevelopmentPlan() {
		return developmentPlan;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getPlanningStep() {
		return planningStep;
	}
	public boolean getSelected() {
		return selected;
	}
	public PersonalDevelopmentPlan getPersonalDevelopmentPlan() {
		return personalDevelopmentPlan;
	}
	public void setPdpItemCode(long pdpItemCode) {
		this.pdpItemCode = pdpItemCode;
	}
	public void setDevelopmentPlan(String developmentPlan) {
		this.developmentPlan = developmentPlan;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public void setPlanningStep(String planningStep) {
		this.planningStep = planningStep;
	}
	public void setSelected(boolean active) {
		this.selected = active;
	}
	public void setPersonalDevelopmentPlan(PersonalDevelopmentPlan personalDevelopmentPlan) {
		this.personalDevelopmentPlan = personalDevelopmentPlan;
	}
	
}