package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserApplication;

@Repository
public interface UserApplicationRepository extends CrudRepository<UserApplication, Integer> {

	UserApplication findByUserName(String email);

	UserApplication findByUserAppId(Integer userId);

}
