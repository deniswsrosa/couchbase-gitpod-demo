package com.example.demo;

import com.example.demo.entities.Building;
import com.example.demo.service.BuildingService;
import lombok.val;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;

public class BuildingServiceIntegrationTest extends DemoApplicationTests {

    public static final String BUILDING_1 = "building::1";
    public static final String COMPANY_2 = "company::2";

    @Autowired
    private BuildingService buildingService;

    @Test
    public void testSave() {
        val building = new Building(BUILDING_1, "couchbase",
                COMPANY_2, "a value", new ArrayList<>(), new ArrayList<>());
        buildingService.save(building);

        Building newBuilding = buildingService.findById(BUILDING_1).get();
        assertThat(newBuilding, equalTo(building));
    }
}
