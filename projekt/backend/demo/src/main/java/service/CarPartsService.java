package service;

import com.example.demo.model.CarParts;
import exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.CarPartsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarPartsService {
    private final CarPartsRepository carPartsRepository;


    @Autowired
    public CarPartsService(CarPartsRepository carPartsRepository) {
        this.carPartsRepository = carPartsRepository;
    }


    public CarParts addCarParts(CarParts carParts){
        carParts.setCode(UUID.randomUUID().toString());
        return  carPartsRepository.save(carParts);
    }
    public List<CarParts> findAllCarParts(){
        return  carPartsRepository.findAll();
    }
    public CarParts updateCarParts(CarParts carParts){
        return  carPartsRepository.save(carParts);
    }
    public CarParts findAllCarPartsById(Long id){
        return carPartsRepository.findAllCarPartsById(id).orElseThrow(()-> new UserNotFoundException("Car parts by id " + id + "was not found"));
    }

    public void deleteCarParts(Long id){
            carPartsRepository.deleteCarPartsById(id);
    }
}
