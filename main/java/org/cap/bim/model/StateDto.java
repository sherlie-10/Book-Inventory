package org.cap.bim.model;

public class StateDto
{
	
	
	private String stateCode;
	private String stateName;
	
	
	
	public StateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateDto(String stateCode, String stateName) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	

}
