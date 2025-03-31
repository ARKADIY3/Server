package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.City;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Города", description = "Управление городами")
@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Operation(summary = "Получить все города", description = "Возвращает список всех городов")
    @GetMapping(value = "/cities")
    public ListResponse<City> getAllCities() {
        return cityService.findAll();
    }

    @Operation(summary = "Получить город по ID", description = "Возвращает информацию о городе по его уникальному идентификатору")
    @GetMapping(value = "/cities/{id}")
    public DataResponse<City> getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @Operation(summary = "Создать новый город", description = "Позволяет создать новый город")
    @PostMapping(value = "/cities")
    public DataResponse<City> createCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @Operation(summary = "Обновить существующий город", description = "Позволяет обновить информацию о городе")
    @PutMapping(value = "/cities")
    public DataResponse<City> updateCity(@RequestBody City city) {
        return cityService.update(city);
    }

    @Operation(summary = "Удалить город", description = "Удаляет город по его уникальному идентификатору")
    @DeleteMapping(value = "/cities/{id}")
    public BaseResponse deleteCity(@PathVariable Long id) {
        return cityService.delete(id);
    }
}