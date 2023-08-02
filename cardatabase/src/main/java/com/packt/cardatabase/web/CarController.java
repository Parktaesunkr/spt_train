package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository repository;
	
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		// 자동차를 검색하고 반환
		return repository.findAll();
	}

}
