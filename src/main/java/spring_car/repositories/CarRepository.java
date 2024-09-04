package spring_car.repositories;

import spring_car.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByEngineerId(Long engineerId); // Метод поиска.
}


// Нам потребовался метод, который позволит выполнять поиска по полю engineerName. Как это реализовать в сущности Car
//  с использованием JPA? Для этого нужно расширить интерфейс CarRepository, добавив метод поиска. Spring Data JPA
//  позволяет создавать пользовательские методы поиска, просто добавляя их в интерфейс репозитория с использованием
//  соглашений об именах.