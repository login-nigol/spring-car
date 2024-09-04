package spring_car.repositories;

import spring_car.models.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EngineerRepository extends JpaRepository<Engineer, Long> {
}
