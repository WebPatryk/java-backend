package com.example.demo.repository;

import com.example.demo.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    void deleteBasketById(Long id);

    @Override
    Optional<Basket> findById(Long aLong);

    Optional<Basket> getBasketById(Long id);
}
