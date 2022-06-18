package com.example.demo.controller;

import com.example.demo.model.CarParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarPartsService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class CarPartsController {
    @Autowired
    private CarPartsService carPartsService;

    @PostMapping("/add")
    public String add(@RequestBody CarParts carParts){
        carPartsService.saveCarParts(carParts);
        return "New Car product is added";
    }

    @GetMapping("/getAll")
    public List<CarParts> list(){
        return carPartsService.getAllCarParts();
    }
}
