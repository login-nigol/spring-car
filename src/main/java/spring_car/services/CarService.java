package spring_car.services;

import spring_car.models.Car;
import spring_car.repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired // автоматическое внедрение зависимостей
    private CarRepository carRepository;

       public List<Car> getAllCars(){
        return carRepository.findAll();
    }

     public Car createCar(Car car){
           return carRepository.save(car);
     }

     public Optional<Car> updateCar(Long id, Car carDetails){
           if (carRepository.existsById(id)) {
               carDetails.setId(id);
               return Optional.of(carRepository.save(carDetails));
           }
           return Optional.empty();
     }

     public boolean deleteCar(Long id){
           if (carRepository.existsById(id)) {
               carRepository.deleteById(id);
               return true;
           }
           return false;
     }
}




















