package com.AndgelDuport.Assignment2.dao.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class PatientData {
    @CsvBindByName
    private Integer X;

    @CsvBindByName
    private Integer Y;

    @CsvBindByName
    private Integer time;

    public PatientData(Integer x, Integer y, Integer time) {
        X = x;
        Y = y;
        this.time = time;
    }
}
