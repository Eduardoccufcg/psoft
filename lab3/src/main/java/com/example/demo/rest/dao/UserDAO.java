package com.example.demo.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.rest.model.User;

@Repository
public interface UserDAO extends JpaRepository<User,String>{
	
	@Query(value="SELECT u FROM User u WHERE u.login = :plogin")
	User findByLogin(@Param("plogin") String login);
		

}
