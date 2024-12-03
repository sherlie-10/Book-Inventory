package org.cap.bim.repository;

import org.cap.bim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer>
{

	@Query("SELECT u FROM User u WHERE u.userName= ?1 AND u.password= ?2")
	User validateCredentials(String userName,String password);
}
