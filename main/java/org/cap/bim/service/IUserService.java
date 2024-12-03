package org.cap.bim.service;

import org.cap.bim.model.User;

public interface IUserService {
	public User addUser(User user);
	public User getUserById(Integer userId);
	public User updateFirstNameById(Integer userId, User user);
	public User updateLastNameById(Integer userId,User user);
	public User updatePhoneNumberById(Integer userId,User user);
	public User userLogin(String userName,String password);
	
	public User updateUserdetails(Integer userId,User user);
	
	
}