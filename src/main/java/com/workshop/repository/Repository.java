package com.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.workshop.entity.User;

public interface Repository extends CrudRepository<User, Long> {

	

}
