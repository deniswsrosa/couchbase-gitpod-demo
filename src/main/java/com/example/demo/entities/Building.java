package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.index.CompositeQueryIndex;
import org.springframework.data.couchbase.core.index.QueryIndexed;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
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

}
