package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.CarParts;
import com.example.demo.repository.CarPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CarPartsService {

    private final CarPartsRepository carPartsRepository;

   @Autowired
   public CarPartsService(CarPartsRepository carPartsRepository) {
       this.carPartsRepository = carPartsRepository;
   }

    public CarParts addCarPart(CarParts carParts) {
        return carPartsRepository.save(carParts);
    }

    public List<CarParts> findAllCarParts() {
        return carPartsRepository.findAll();
    }

    public CarParts updateCarPart(Long id, CarParts carParts) {
        CarParts carPartUpdate = carPartsRepository.getCarPartById(id).orElseThrow(() -> new UserNotFoundException("Car part by id " + id + " was not found"));

        carPartUpdate.setName(carParts.getName());
        carPartUpdate.setDescription(carParts.getDescription());
        carPartUpdate.setPrice(carParts.getPrice());
        carPartUpdate.setImageUrl(carParts.getImageUrl());

        return carPartsRepository.save(carPartUpdate);

    }

    public CarParts findCarPartById(Long id) {
        return carPartsRepository.getCarPartById(id)
                .orElseThrow(() -> new UserNotFoundException("Car part by id " + id + " was not found"));
    }

    public void deleteCarPart(Long id){
        carPartsRepository.deleteEmployeeById(id);
    }

}
