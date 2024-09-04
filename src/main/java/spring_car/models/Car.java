package spring_car.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // Определяет класс как сущность.
@Table(name = "cars") // Указывает, с какой таблицей базы данных связана сущность.
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация значения для первичного ключа.
    private Long id;

    private String brand;
    private String model;
    private int year;
    private String cityOfManufacture;

    @ManyToOne
    @JoinColumn(
            name = "engineer_id"
    )
    private Engineer engineer;

}
















