package com.quiz.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.dto.UserDTO;
import com.quiz.app.dto.UserInfoDTO;
import com.quiz.app.entity.User;


@Repository
public interface UserInfoRepo extends JpaRepository<User, Integer> {

	@Query("select U FROM User U WHERE U.email = :email")
    public User getUserByEmail(String email);

	@Query("select U FROM User U WHERE U.email = :email AND U.password= :password")
	public User getUserExist(String email, String password);

	@Query("select U.password FROM User U WHERE U.email = :email")
	public String getUserPassword(String email);
	
	
}
