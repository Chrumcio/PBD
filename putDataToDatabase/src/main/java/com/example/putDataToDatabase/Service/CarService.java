package com.example.putDataToDatabase.Service;

import com.example.putDataToDatabase.Entity.Car;
import com.example.putDataToDatabase.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.findAll();
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public Car getCarById(Long id){
        return carRepository.getOne(id);
    }
}
