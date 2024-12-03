package org.cap.bim.service;

import java.util.Optional;


import org.cap.bim.exception.UserNotFoundException;
import org.cap.bim.model.User;
import org.cap.bim.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		user.setPermrole(user.getPermrole());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserNotFoundException("UserId is not present!");
	}

	@Override
	public User updateFirstNameById(Integer userId,User user) {
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user1=optionalUser.get();
			user1.setFirstName(user.getFirstName());
			userRepository.save(user1);
			return user1;
		}
		throw new UserNotFoundException("User with ID "+ userId +" is not found");
	}

	@Override
	public User updateLastNameById(Integer userId,User user) {
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user1=optionalUser.get();
			user1.setLastName(user.getLastName());
			userRepository.save(user1);
			return user1;
		}
		throw new UserNotFoundException("User with ID "+ userId +" is not found");
	}

	@Override
	public User updatePhoneNumberById(Integer userId,User user) {
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isPresent()) {
			User user1=optionalUser.get();
			user1.setPhoneNumber(user.getPhoneNumber());
			userRepository.save(user1);
			return user1;
		}
		throw new UserNotFoundException("User with ID "+ userId +" is not found");
	}

	@Override
	public User userLogin(String userName, String password) {
		User user=userRepository.validateCredentials(userName, password);
		if(user==null) {
			throw new UserNotFoundException("Wrong credentials");
		}
		return user;
	}

	@Override
	public User updateUserdetails(Integer userId,User user) 
	{
		Optional<User> optionalUser=userRepository.findById(userId);
		if(optionalUser.isPresent()) 
		{
			User user1=optionalUser.get();
			user1.setFirstName(user.getFirstName());
			user1.setLastName(user.getLastName());
			user1.setPhoneNumber(user.getPhoneNumber());
			user1.setUserName(user.getUserName());
			userRepository.save(user1);
			return user1;

			
			
		}
		throw new UserNotFoundException("User with ID "+ userId +" is not found");

		
		
	}

}
