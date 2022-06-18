package com.example.demo.service;

import com.example.demo.model.CarParts;

import java.util.List;

public interface CarPartsService {
    public CarParts saveCarParts(CarParts student);
    public List<CarParts> getAllCarParts();
}
