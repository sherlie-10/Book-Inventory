package org.cap.bim.service;
import java.util.List;
import java.util.Optional;
import org.cap.bim.exception.StateNotFoundException;
import org.cap.bim.model.State;
import org.cap.bim.repository.IStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements IStateService  {
	
	@Autowired
	private IStateRepository stateRepository;
	
	@Override
	public State createState(State state) 
	{	
	  return stateRepository.save(state);	
	}

	@Override
	public List<State> getAllStates() 
	{
		List<State> states=stateRepository.findAll();
		if(states.isEmpty())
		{
			throw new StateNotFoundException("No State Data Available");
		}
		else
			return states;
	}

	@Override
	public State findStateById(String stateId) 
	{
	      Optional<State> state = stateRepository.findById(stateId);
	    if(state.isPresent())
	    {
	    	return state.get();
	    }
		throw new StateNotFoundException("No State is Found with this StateId");
    
	}

	@Override
	public State updateStateById(String stateId,State state)
	{
		Optional<State> state1= stateRepository.findById(stateId);
	    if(state1.isPresent())
	    {
	    	state1.get().setStateName(state.getStateName());
	    	stateRepository.save(state1.get());

	    		return state1.get();
	    	    	
	    }
		throw new StateNotFoundException("No State is Found For Update name");
		
	}







}