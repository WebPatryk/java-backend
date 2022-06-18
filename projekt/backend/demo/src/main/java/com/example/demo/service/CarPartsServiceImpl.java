package com.example.demo.service;

import com.example.demo.model.CarParts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CarPartsRepository;


import java.util.List;

@Service
public class CarPartsServiceImpl implements CarPartsService {

    @Autowired
    private CarPartsRepository carPartsRepository;

    @Override
    public CarParts saveCarParts(CarParts student) {
        return carPartsRepository.save(student);
    }

    @Override
    public List<CarParts> getAllCarParts() {
        return carPartsRepository.findAll();
    }
}
