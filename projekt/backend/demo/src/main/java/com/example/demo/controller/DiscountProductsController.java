package com.example.demo.controller;

import com.example.demo.model.CarParts;
import com.example.demo.service.CarPartsService;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/discounts")
@CrossOrigin
public class DiscountProductsController {
    @Autowired
    private DiscountService discountService;



    @GetMapping("/getAll")
    public ResponseEntity<List<CarParts>> getAllDiscounts () {
        List<CarParts> discountProduct = discountService.findAllDiscount();
        return new ResponseEntity(discountProduct, HttpStatus.OK);
    }

}
