package org.cap.bim.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@Column(name="StateCode" ,length = 2,nullable = false)
	private String stateCode;
	
	@Column(name="StateName",length = 50)
	private String stateName;
	
	@OneToMany(mappedBy = "state")
	@JsonManagedReference
	private List<Publisher> publishers=new ArrayList<>();
	
	

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(String stateCode, String stateName, List<Publisher> publishers) {
		super();
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.publishers = publishers;
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

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}
	
	
	
	
}