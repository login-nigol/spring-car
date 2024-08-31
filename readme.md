# Spring book: Система управления списком автомобилей и инженеров.

## Описание: 
Это простое Spring Boot приложение для управления списком автомобилей и инженеров, ответственных за их 
обслуживание. Приложение включает базовые CRUD (Create, Read, Update, Delete) операции для автомобилей и инженеров. 
Каждый автомобиль может быть связан с одним или несколькими инженерами.

## Основные компоненты:

### Сущности:

Car: Класс для представления автомобиля. Поля включают id, model, brand, и связь с инженерами.
Engineer: Класс для представления инженера. Поля включают id, name, и список автомобилей, за которые он отвечает.

### Репозитории:

CarRepository: Интерфейс для работы с таблицей cars в базе данных.
EngineerRepository: Интерфейс для работы с таблицей engineers в базе данных.

### Сервисы:

CarService: Сервис для обработки логики, связанной с автомобилями (создание, обновление, удаление и получение автомобилей).
EngineerService: Сервис для работы с инженерами.

### Контроллеры:

CarController: REST-контроллер для управления запросами, связанными с автомобилями (CRUD операции).
EngineerController: REST-контроллер для управления запросами, связанными с инженерами.

### Файлы конфигурации:

application.properties: Настройки подключения к базе данных (например, MySQL).

**Основная структура проекта:**

```
spring-car
├── src
│   ├── main
│   │   ├── java
│   │   │   └── spring_car
│   │   │       ├── configuration
│   │   │       │   └── SwaggerConfig.java
│   │   │       ├── controllers
│   │   │       │   ├── CarController.java
│   │   │       │   └── EngineerController.java
│   │   │       ├── models
│   │   │       │   ├── Car.java
│   │   │       │   └── Engineer.java
│   │   │       ├── repositories
│   │   │       │   ├── CarRepository.java
│   │   │       │   └── EngineerRepository.java
│   │   │       └── services
│   │   │           ├── CarService.java
│   │   │           └── EngineerService.java
│   ├── resources
│   │   └── application.properties
└── pom.xml
```