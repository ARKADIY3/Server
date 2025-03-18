package com.practicheskaya.server8.service;

import com.practicheskaya.server8.entity.City;
import com.practicheskaya.server8.repository.CityRepo;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public ListResponse<City> findAll() {
        List<City> cities = cityRepo.findAll();
        return ListResponse.success(cities);
    }

    public DataResponse<City> findById(Long id) {
        Optional<City> city = cityRepo.findById(id);

        if (city.isEmpty()) {
            return DataResponse.errorData("Город с ID " + id + " не найден");
        }

        return DataResponse.success(city.get());
    }

    public DataResponse<City> save(City city) {
        try {
            City savedCity = cityRepo.save(city);
            return DataResponse.success("Город успешно создан", savedCity);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при создании города: " + e.getMessage());
        }
    }

    public DataResponse<City> update(City city) {
        if (city.getId() == null || !cityRepo.existsById(city.getId())) {
            return DataResponse.errorData("Город не найден для обновления");
        }

        try {
            City updatedCity = cityRepo.save(city);
            return DataResponse.success("Город успешно обновлен", updatedCity);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при обновлении города: " + e.getMessage());
        }
    }

    public BaseResponse delete(Long id) {
        if (!cityRepo.existsById(id)) {
            return new BaseResponse(false, "Город с ID " + id + " не найден");
        }

        try {
            cityRepo.deleteById(id);
            return new BaseResponse(true, "Город успешно удален");
        } catch (Exception e) {
            return new BaseResponse(false, "Ошибка при удалении города: " + e.getMessage());
        }
    }
}