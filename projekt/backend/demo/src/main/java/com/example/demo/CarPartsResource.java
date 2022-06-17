package com.example.demo;

import com.example.demo.model.CarParts;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import service.CarPartsService;


import java.util.List;

@RestController
@RequestMapping("/carPart")
public class CarPartsResource {
    private final CarPartsService carPartsService;

    public CarPartsResource(CarPartsService carPartsService) {
        this.carPartsService = carPartsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<CarParts>> getCarPart () {
        List<CarParts> employees = carPartsService.findAllCarParts();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CarParts> getCarPartById (@PathVariable("id") Long id) {
        CarParts carPart = carPartsService.findAllCarPartsById(id);
        return new ResponseEntity<>(carPart, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CarParts> addCarPart(@RequestBody CarParts carParts) {
        CarParts carPart = carPartsService.addCarParts(carParts);
        return new ResponseEntity<>(carPart, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CarParts> updateCarPart(@RequestBody CarParts carParts) {
        CarParts updateCarPart = carPartsService.updateCarParts(carParts);
        return new ResponseEntity<>(updateCarPart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarPart(@PathVariable("id") Long id) {
        carPartsService.deleteCarParts(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
