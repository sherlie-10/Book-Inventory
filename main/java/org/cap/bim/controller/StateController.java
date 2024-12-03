package org.cap.bim.controller;

import java.util.List;

import org.cap.bim.model.State;
import org.cap.bim.model.StateDto;
import org.cap.bim.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class StateController 
{
	
	@Autowired
	private IStateService stateService;
	
	@PostMapping("/state/post")
	public ResponseEntity<State> createState(@RequestBody StateDto stateDto)
	
	{
		State state=new State();
		state.setStateCode(stateDto.getStateCode());
		state.setStateName(stateDto.getStateName());
		
		State state1=stateService.createState(state);
		if (state1!=null)
		{
			return new ResponseEntity("State created Successfully", HttpStatus.CREATED);

		}
		return new ResponseEntity("State Object creation Error!",
				HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/states")
	public ResponseEntity<List<State>> getAllStates(){
		List<State> State= stateService.getAllStates();
		if(State.isEmpty())
			return new ResponseEntity("Sorry! Customer DB is empty!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<State>>(State, HttpStatus.OK);
	}
	
	
	@GetMapping("/state/{stateId}")
	public ResponseEntity<State> findStateById(@PathVariable("stateId")String stateId){
		State state=stateService.findStateById(stateId);
		
		if(state==null) {
			return new ResponseEntity("Sorry! State is not present:" + stateId+" Not Found!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<State>(state, HttpStatus.OK);

	}
	
	@PutMapping("/state/update/name/{stateId}")
	public ResponseEntity<State> updateStateByID(@PathVariable("stateId")String stateId,@RequestBody StateDto stateDto)
	{
		State state=new State();
		state.setStateName(stateDto.getStateName());
		State state1=stateService.updateStateById(stateId,state);
		
		if(state1==null) {
			return new ResponseEntity("Sorry! State is not present:" + stateId+" Not Found!",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<State>(state1, HttpStatus.OK);

	}	

}