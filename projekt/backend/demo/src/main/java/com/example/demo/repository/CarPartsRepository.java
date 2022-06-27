package com.example.demo.repository;

import com.example.demo.model.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CarPartsRepository extends JpaRepository<CarParts, Long> {

    void deleteEmployeeById(Long id);

    @Override
    Optional<CarParts> findById(Long aLong);

    Optional<CarParts> getCarPartById(Long id);
}
