package carsharing.dao;

import carsharing.entity.Car;
import java.util.List;

public interface CarDao {
    List<Car> getAllCars();

    void createCar(String car);
}

