package com.example.finstability.controller;

import com.example.finplanner.model.PlanRequest;
import com.example.finplanner.model.PlanResponse;
import com.example.finstability.service.FinancialPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Serves the planner UI directly at localhost:8080/ - one page, one form,
 * one submit button. GET shows the form with default values. POST runs
 * both calculations and re-renders the same page with results filled in.
 */
@Controller
public class HomeController {

    @Autowired
    private final FinancialPlanningService financialPlanningService;

    public HomeController(FinancialPlanningService financialPlanningService) {
        this.financialPlanningService = financialPlanningService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("planRequest")) {
            model.addAttribute("planRequest", new PlanRequest());
        }
        return "index";
    }

    @PostMapping("/")
    public String calculate(@ModelAttribute PlanRequest planRequest, Model model) {
        PlanResponse response = new PlanResponse();
        financialPlanningService.calculateBeforeRetirement(planRequest, response);
        financialPlanningService.calculateAtRetirement(planRequest, response);

        model.addAttribute("planRequest", planRequest);
        model.addAttribute("response", response);
        return "index";
    }
}