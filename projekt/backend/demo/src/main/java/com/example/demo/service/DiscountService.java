package com.example.demo.service;

import com.example.demo.model.CarParts;
import com.example.demo.repository.CarPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@Transactional
public class DiscountService {


    private final CarPartsRepository carPartsRepository;

    @Autowired
    public DiscountService(CarPartsRepository carPartsRepository) {
        this.carPartsRepository = carPartsRepository;
    }
    





    public static <T> List<T> nextRandomN(List<T> list, int n) {
        return Stream
                .generate(() -> list.remove((int) (list.size() * Math.random())))
                .limit(Math.min(list.size(), n))
                .collect(Collectors.toList());
    }

    public List<CarParts> findAllDiscount() {
/*       List<CarParts> carParts = carPartsRepository.findAll();
       Random rand = new Random();
       return carParts.get(rand.nextInt(carParts.size()));*/
        List<CarParts> carParts = carPartsRepository.findAll();
        return nextRandomN(carParts, 3);

    }


}
