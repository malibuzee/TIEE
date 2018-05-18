package com.malibuzee.sisteval.model;

/**
 * Created by F129 on 08/04/2018.
 */

public class TagModelo {
    private String serial, nombreObj;
    private Integer IdRow;



    public TagModelo() {
    }

    public TagModelo(String serial, String nombreObj) {
        this.serial = serial;
        this.nombreObj = nombreObj;



    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNombreObj() {
        return nombreObj;
    }

    public void setNombreObj(String nombreObj) {
        this.nombreObj = nombreObj;
    }

    public Integer getIdRow() {return IdRow;}

    public void setIdRow(Integer idRow) {IdRow = idRow;}
}
