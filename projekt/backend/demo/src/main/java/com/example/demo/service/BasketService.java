package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Basket;
import com.example.demo.model.CarParts;
import com.example.demo.repository.BasketRepository;
import com.example.demo.repository.CarPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Basket addToBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public List<Basket> findAllCarParts() {
        return basketRepository.findAll();
    }

    public Basket updateCarPart(Long id, Basket basket) {
        Basket basketUpdate = basketRepository.getBasketById(id).orElseThrow(() -> new UserNotFoundException("Car part by id " + id + " was not found"));

        basketUpdate.setName(basket.getName());
        basketUpdate.setDescription(basket.getDescription());
        basketUpdate.setPrice(basket.getPrice());
        basketUpdate.setImageUrl(basket.getImageUrl());

        return basketRepository.save(basketUpdate);

    }

    public Basket findCarPartById(Long id) {
        return basketRepository.getBasketById(id)
                .orElseThrow(() -> new UserNotFoundException("Car part by id " + id + " was not found"));
    }

    public void deleteCarPart(Long id){
        basketRepository.deleteBasketById(id);
    }

}
