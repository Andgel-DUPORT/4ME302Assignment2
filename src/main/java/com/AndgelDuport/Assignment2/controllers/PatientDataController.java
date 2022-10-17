package com.AndgelDuport.Assignment2.controllers;

import com.AndgelDuport.Assignment2.model.PatientData;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/data")
public class PatientDataController {

    @GetMapping("/patient/{id}")
    public String listPatientData(@PathVariable int id, Model model){
        List<PatientData> patientDataList = new LinkedList<>();
        try {
            Reader reader = Files.newBufferedReader(Path.of("src/main/resources/databases/data/data"+id+".csv"));
            // create csv reader
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                PatientData patientData = new PatientData(Integer.parseInt(record[0]), Integer.parseInt(record[1]), Integer.parseInt(record[2]));
                patientDataList.add(patientData);
            }
            csvReader.close();
            reader.close();
        }
        catch (IOException | CsvValidationException ex){
            ex.printStackTrace();
        }
        model.addAttribute("listData", patientDataList);
        return "patientData";
    }
}
