package com.example.demo.entities;


import java.util.ArrayList;
import java.util.List;


public class Area {
    public Area(String id, String name, List<Area> areas) {
        this.id = id;
        this.name = name;
        this.areas = areas;
    }

    public Area() {}

    private String id;
    private String name;
    private List<Area> areas = new ArrayList<>();
}