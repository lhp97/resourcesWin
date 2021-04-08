package com.example.resourceswin.model;

import com.google.gson.annotations.SerializedName;

public class tblrecursos {

    @SerializedName("id")
    private String id;
    @SerializedName("memoria_ram")
    private String memoria_ram;
    @SerializedName("cpu")
    private String cpu;
    @SerializedName("disco")
    private String disco;
    @SerializedName("data_tmp")
    private String data_tmp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemoria_ram() {
        return memoria_ram;
    }

    public void setMemoria_ram(String memoria_ram) {
        this.memoria_ram = memoria_ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getData_tmp() {
        return data_tmp;
    }

    public void setData_tmp(String data_tmp) {
        this.data_tmp = data_tmp;
    }

    public tblrecursos() {

    }

    public tblrecursos(String id, String memoria_ram, String cpu, String disco, String data_tmp) {
        this.id = id;
        this.memoria_ram = memoria_ram;
        this.cpu = cpu;
        this.disco = disco;
        this.data_tmp = data_tmp;
    }
}
