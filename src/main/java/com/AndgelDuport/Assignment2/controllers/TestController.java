package com.AndgelDuport.Assignment2.controllers;

import com.AndgelDuport.Assignment2.dao.model.Test;
import com.AndgelDuport.Assignment2.dao.model.TestSession;
import com.AndgelDuport.Assignment2.dao.repositories.TestRepository;
import com.AndgelDuport.Assignment2.dao.repositories.TestSessionRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
@PreAuthorize("hasAnyRole('ADMIN','PATIENT')")
public class TestController {
    private final TestRepository testRepository;
    private final TestSessionRepository testSessionRepository;

    public TestController(TestRepository testRepository, TestSessionRepository testSessionRepository) {
        this.testRepository = testRepository;
        this.testSessionRepository = testSessionRepository;
    }

    @GetMapping()
    public String getAllTestInfo(Model model){
        List<Test> tests;
        tests = testRepository.findAll();
        model.addAttribute("testList", tests );
        return "test";
    }

    @GetMapping("/session")
    public String getAllTestSessionInfo(Model model){
        List<TestSession> tests;
        tests = testSessionRepository.findAll();
        model.addAttribute("testSessionList", tests );
        return "testSession";
    }

}
