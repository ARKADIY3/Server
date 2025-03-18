package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.City;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.CityService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/cities")
    public ListResponse<City> getAllCities() {
        return cityService.findAll();
    }

    @GetMapping(value = "/cities/{id}")
    public DataResponse<City> getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @PostMapping(value = "/cities")
    public DataResponse<City> createCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping(value = "/cities")
    public DataResponse<City> updateCity(@RequestBody City city) {
        return cityService.update(city);
    }

    @DeleteMapping(value = "/cities/{id}")
    public BaseResponse deleteCity(@PathVariable Long id) {
        return cityService.delete(id);
    }
}