package com.indeco.trainingandroid.io.remote.entities;

import com.google.gson.annotations.SerializedName;

public class MyModel {

    private String nr;

    @SerializedName("id_dosar")
    private String fileId;

    @SerializedName("tip_ajutor")
    private String helpType;

    @SerializedName("titular")
    private String titular;

    @SerializedName("detalii")
    private String details;

    @SerializedName("data_start")
    private String startDate;

    @SerializedName("data_stop")
    private String stopDate;

    @SerializedName("rezolutie")
    private String resoltion;

    @SerializedName("nume_autor")
    private String author;

}
