package com.indeco.trainingandroid.test;

import java.io.Serializable;

public class Entity implements Serializable {

    private String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
