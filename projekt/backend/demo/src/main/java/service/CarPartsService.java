package service;

import com.example.demo.model.CarParts;
import exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarPartsRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;


@Service
public class CarPartsService {
    private  final CarPartsRepository carPartsRepository;


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
    public void findAllCarPartsById(Long id){
        carPartsRepository.findAllCarPartsById(id).orElseThrow(()-> new UserNotFoundException("Car parts by id " + id + "was not found"));
    }

    public void deleteCarParts(Long id){
            carPartsRepository.deleteCarPartsById(id);
    }
}
