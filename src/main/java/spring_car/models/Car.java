package spring_car.models;

import lombok.Data;
import lombok.Builder;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // Определяет класс как сущность.
@Table(name = "cars") // Указывает, с какой таблицей базы данных связана сущность.
public class Car {

    @jakarta.persistence.Id
    @Id // Обозначает первичный ключ сущности.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация значения для первичного ключа.
    private Long id;

    private String brand;
    private String model;
    private int year;
    private String cityOfManufacture;
    private String engineerName;

}
















