package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Circular;

@Repository
public interface CircularRepository extends CrudRepository<Circular, Integer> {

	Circular findByCircularId(Integer circularId);

}
