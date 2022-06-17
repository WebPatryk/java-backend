package repository;

import com.example.demo.model.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CarPartsRepository extends JpaRepository<CarParts, Long> {

    void deleteCarPartsById(Long id);


   Optional<CarParts> findAllCarPartsById(Long id);

}
