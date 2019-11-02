package com.example.putDataToDatabase.Controller;

import com.example.putDataToDatabase.Entity.Car;
import com.example.putDataToDatabase.Repository.CarRepository;
import com.example.putDataToDatabase.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/findAll")
    public List<Car> findAll(){
        return carService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Car findById(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @PostMapping("/createCar")
    public void createCar(){
        Car car = new Car(2,"SDADSA");
        carService.saveCar(car);
    }
}
