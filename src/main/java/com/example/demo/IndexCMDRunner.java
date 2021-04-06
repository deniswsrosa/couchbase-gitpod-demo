package com.example.demo;

import com.couchbase.client.core.error.IndexExistsException;
import com.example.demo.entities.Building;
import com.example.demo.service.BuildingService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class IndexCMDRunner implements CommandLineRunner {

    @Autowired
    private CouchbaseTemplate template;

    @Autowired
    private BuildingService buildingService;

    public static final String BUILDING_1 = "building::1";
    public static final String COMPANY_2 = "company::2";

    @Override
    public void run(String... args) throws Exception {

        try {
            //Create a Primary Index to make it easier for you to query Couchbase
            template.getCouchbaseClientFactory()
                    .getCluster().queryIndexes()
                    .createPrimaryIndex(template.getBucketName());
        } catch(IndexExistsException e) {
            System.out.println("Skipping index creation...");
        }

        val building = new Building(BUILDING_1, "couchbase",
                COMPANY_2, "a value", new ArrayList<>(), new ArrayList<>());
        buildingService.save(building);
    }
}
