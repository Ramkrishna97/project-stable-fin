package com.example.finstability.controller;

import com.example.finstability.model.FinancialParameters;
import com.example.finstability.model.RetirementResult;
import com.example.finstability.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    // GET mapping to show the initial form
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("parameters", new FinancialParameters());
        return "index"; // Points to templates/index.html
    }

    // POST mapping to process calculations from the form submission
    @PostMapping("/calculate")
    public String calculateFinances(@ModelAttribute FinancialParameters parameters, Model model) {

        // Step 1: Calculate Savings Before Retirement (Phase I)
        long finalSaving = financeService.calculateSaving(parameters);
        System.out.println("Calculated Saving: " + finalSaving);

        // Step 2: Simulate Retirement (Phase II & III)
        RetirementResult result = financeService.simulateRetirement(parameters, finalSaving);

        model.addAttribute("parameters", parameters);
        model.addAttribute("result", result);
        return "index"; // Reuse the same template to display results
    }
}
