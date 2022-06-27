package com.example.demo.service;

import com.example.demo.model.CarParts;
import com.example.demo.repository.CarPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;


@Service
@Transactional
public class DiscountService {


    private final CarPartsRepository carPartsRepository;

    @Autowired
    public DiscountService(CarPartsRepository carPartsRepository) {
        this.carPartsRepository = carPartsRepository;
    }

    public CarParts getRandomElement(List<CarParts> carParts)
    {
        Random rand = new Random();
        return carParts.get(rand.nextInt(carParts.size()));
    }

    public CarParts findAllDiscount() {
       List<CarParts> carParts = carPartsRepository.findAll();
       Random rand = new Random();
       return carParts.get(rand.nextInt(carParts.size()));


    }
}
