package com.example.demo.controller;

import com.example.demo.model.Basket;
import com.example.demo.model.CarParts;
import com.example.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CarPartsService;

import java.util.List;

@RestController
@RequestMapping("/basket")
@CrossOrigin
public class BasketController {
    @Autowired
    private BasketService basketService;



    @GetMapping("/getAll")
    public ResponseEntity<List<Basket>> getAllCarParts () {
        List<Basket> baskets = basketService.findAllCarParts();
        return new ResponseEntity<>(baskets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Basket> getCarPartById (@PathVariable("id") Long id) {
        Basket basket = basketService.findCarPartById(id);
        return new ResponseEntity<>(basket, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Basket> addCarPart(@RequestBody Basket basket) {
        Basket newProductToBasket = basketService.addToBasket(basket);
        return new ResponseEntity<>(newProductToBasket, HttpStatus.CREATED);
    }

/*    @PutMapping("/update/{id}")
    public ResponseEntity<CarParts> updateCarPart(@PathVariable("id") Long id,@RequestBody CarParts carParts) {
        CarParts updateCarPart = carPartsService.updateCarPart(id, carParts);
        return new ResponseEntity<>(updateCarPart, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCarPart(@PathVariable("id") Long id) {
        carPartsService.deleteCarPart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/


}
