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
        // Basic check to ensure critical data is present before computation
        if (parameters.getCurrentBalance() < 0 || parameters.getYearsUntilRetirement() <= 0) {
            model.addAttribute("error", "Please enter valid positive values for balance and years.");
            return "index"; // Return the form with an error message
        }

        // ... existing logic remains the same
        long finalSaving = financeService.calculateSaving(parameters);
        RetirementResult result = financeService.simulateRetirement(parameters, finalSaving);

        model.addAttribute("parameters", parameters);
        model.addAttribute("result", result);
        return "index";
    }

}
