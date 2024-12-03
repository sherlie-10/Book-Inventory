package org.cap.bim.service;

import java.util.List;

import org.cap.bim.model.State;

public interface IStateService {
	
	public State createState(State state);
	public State updateStateById(String StateId,State state);
	public List<State> getAllStates();
	public State findStateById(String stateId);

}

