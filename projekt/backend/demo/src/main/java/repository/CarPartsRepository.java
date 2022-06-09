package repository;

import com.example.demo.model.CarParts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarPartsRepository extends JpaRepository<CarParts, Long> {

    void deleteCarPartsById(Long id);

    Optional<CarParts> findById(Long aLong);

   Optional<CarParts> findAllCarPartsById(Long id);

}
