package com.packt.cardatabase;


import java.util.Arrays;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner{ // 작업 전 데이터를 미리 삽입(기본 데이터 삽입)
	
	private static final Logger logger =
			LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;

	
	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner("John", "Johnson");
		Owner owner2 = new Owner("Mary", "Robinson");
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
//		repository.save(new Car("FORD", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
//		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
//		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));
		
		Car car1 = new Car("FORD", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2);
		
		repository.saveAll(Arrays.asList(car1,car2,car3));
		
		for(Car car : repository.findAll()) {
			logger.info(car.getBrand()+" "+car.getModel());
		}
		
	
	}
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application started");
	}


}
