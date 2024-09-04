package spring_car.controllers;

import io.swagger.v3.oas.annotations.Operation;

import spring_car.models.Car;
import spring_car.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Operation(summary = "Получить все автомобили", description = "Возвращает список всех автомобилей.")
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(cars);
    }

    @Operation(summary = "Создать новый автомобиль", description = "Создает новый автомобиль с указанными данными.")
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @Operation(summary = "Обновить автомобиль", description = "Обновляет данные существующего автомобиля.")
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Optional<Car> updatableCar = carService.updateCar(id, carDetails);
        return updatableCar.map(car -> ResponseEntity.status(HttpStatus.OK).body(car))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Удалить автомобиль", description = "Удаляет автомобиль по указанному идентификатору.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        boolean deletedCar = carService.deleteCar(id);
        return deletedCar ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Найти все автомобили по инженеру")
    @GetMapping("/search/{id}")
    public ResponseEntity<List<Car>> getCarsByEngineerId(@PathVariable Long id) {
               List<Car> foundCars = carService.getCarsByEngineerId(id);
//        if (foundCars.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
        return ResponseEntity.status(HttpStatus.OK).body(foundCars);
    }
}

















