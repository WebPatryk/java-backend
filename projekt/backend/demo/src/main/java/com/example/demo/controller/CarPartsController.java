package com.example.demo.controller;

import com.example.demo.model.CarParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarPartsService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class CarPartsController {
    @Autowired
    private CarPartsService carPartsService;



    @GetMapping("/getAll")
    public ResponseEntity<List<CarParts>> getAllCarParts () {
        List<CarParts> carParts = carPartsService.findAllCarParts();
        return new ResponseEntity<>(carParts, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CarParts> getCarPartById (@PathVariable("id") Long id) {
        CarParts employee = carPartsService.findCarPartById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CarParts> addCarPart(@RequestBody CarParts carParts) {
        CarParts newCarPart = carPartsService.addCarPart(carParts);
        return new ResponseEntity<>(newCarPart, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CarParts> updateCarPart(@PathVariable("id") Long id,@RequestBody CarParts carParts) {
        CarParts updateCarPart = carPartsService.updateCarPart(id, carParts);
        return new ResponseEntity<>(updateCarPart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarPart(@PathVariable("id") Long id) {
        carPartsService.deleteCarPart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
