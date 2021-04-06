package com.example.demo.service;


import com.example.demo.entities.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingService {

    Building save(Building building);

    Optional<Building> findById(String buildingId);

    List<Building> findByCompanyId(String companyId);

    Building findByCompanyAndAreaId(String companyId, String areaId);

    List<Building> findByCompanyIdAndNameLike(String companyId, String name, int page);

    List<Building> findByPhoneNumber(String telephoneNumber);

    Long countBuildings(String companyId);

}
