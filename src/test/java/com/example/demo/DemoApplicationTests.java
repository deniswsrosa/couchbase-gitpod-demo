package com.example.demo;

import com.example.demo.repositories.BuildingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	protected BuildingRepository businessUnityRepository;

	@BeforeEach
	public void deleteAll(){
		businessUnityRepository.deleteAll();
	}

}
