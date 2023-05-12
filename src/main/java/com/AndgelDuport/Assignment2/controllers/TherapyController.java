package com.AndgelDuport.Assignment2.controllers;

import com.AndgelDuport.Assignment2.dao.model.Therapy;
import com.AndgelDuport.Assignment2.dao.model.TherapyList;
import com.AndgelDuport.Assignment2.dao.repositories.TherapyListRepository;
import com.AndgelDuport.Assignment2.dao.repositories.TherapyRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'PHYSICIAN', 'RESEARCHER', 'JUNIOR_RESEARCHER')")
@RequestMapping("/therapy")
public class TherapyController {
    private final TherapyRepository therapyRepository;
    private final TherapyListRepository therapyListRepository;


    public TherapyController(TherapyRepository therapyRepository, TherapyListRepository therapyListRepository) {
        this.therapyRepository = therapyRepository;
        this.therapyListRepository = therapyListRepository;
    }

    @GetMapping
    public String getAllTherapies(Model model){
        List<Therapy> therapies;
        therapies = therapyRepository.findAll();
        model.addAttribute("therapies", therapies );
        return "therapies";
    }

    @GetMapping("/list")
    public String getAllTherapiesList(Model model){
        List<TherapyList> therapies;
        therapies = therapyListRepository.findAll();
        model.addAttribute("therapies", therapies );
        return "therapyList";
    }
}
