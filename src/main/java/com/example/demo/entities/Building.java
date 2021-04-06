package com.example.demo.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

@Document
@CompositeQueryIndex(fields = {"id", "name desc", "companyId", "type"})
public class Building {

    //Optional in this case, we will automatically promote an attribute called "id" to be key of the document
    @Id
    @GeneratedValue
    private String id;
    private String name;
    //you can create indexes
    @QueryIndexed
    private String companyId;
    //Use this annotation if you want your doc's attribute to be different than your class
    @Field("some_value")
    private String someValue;
    private List<Area> areas = new ArrayList<>();
    private List<String> phoneNumbers = new ArrayList<>();

    public Building(){}
    public Building(String id, String name, String companyId, String someValue, List<Area> areas, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
        this.someValue = someValue;
        this.areas = areas;
        this.phoneNumbers = phoneNumbers;
    }
}
