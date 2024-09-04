package spring_car.services;

import spring_car.models.Car;
import spring_car.repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarService {

    @Autowired // Автоматическое внедрение зависимостей
    private CarRepository carRepository;

       public List<Car> getAllCars(){
        return carRepository.findAll();
    }

     public Car createCar(Car car){
           return carRepository.save(car);
     }

     public Optional<Car> updateCar(Long id, Car carDetails){
           if (carRepository.existsById(id)) { // Проверка существования автомобиля.
               carDetails.setId(id);           // Обновление данных автомобиля.
               return Optional.of(carRepository.save(carDetails)); // Сохранение автомобиля.
           }
           return Optional.empty(); // Возврат пустого значения, если автомобиль не найден.
     }

     public boolean deleteCar(Long id){
           if (carRepository.existsById(id)) { // Проверка существования автомобиля.
               carRepository.deleteById(id);   // Удаление автомобиля.
               return true;
           }
           return false;
     }

     public List<Car> getCarsByEngineerId(Long engineerId){
           List<Car> cars = carRepository.findByEngineerId(engineerId);
           return cars == null ? new ArrayList<>() : cars;
     }
}

// Метод updateCar принимает два параметра:
//  идентификатор автомобиля (id) и объект с новыми данными автомобиля (carDetails).

// Optional<Car> — это контейнер, который может содержать объект Car или быть пустым
//  (если автомобиль с указанным id не найден).

// Метод existsById(id) проверяет, существует ли автомобиль с указанным идентификатором id в базе данных.
//  Если автомобиль найден, программа продолжает выполнение блока if. Если автомобиль не существует, выполнение
//  переходит к return Optional.empty().

// Метод carDetails.setId(id): Если автомобиль с указанным id существует, метод устанавливает значение id для
//  объекта carDetails. Это важно, чтобы при сохранении объекта в базе данных он заменил существующую запись,
//  а не создал новую. Установка id гарантирует, что JPA выполнит обновление записи, а не вставку новой.

// После того как идентификатор был установлен, метод сохраняет объект carDetails в базе данных с помощью
//  carRepository.save(carDetails). Этот метод вернет обновленный объект Car, который затем упаковывается в Optional
//  с помощью Optional.of(...). Таким образом, если обновление прошло успешно, метод возвращает объект, содержащий
//  обновленную сущность Car.










