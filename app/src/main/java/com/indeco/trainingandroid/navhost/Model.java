package com.indeco.trainingandroid.navhost;

import java.io.Serializable;

public class Model implements Serializable {
    private String name;

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
