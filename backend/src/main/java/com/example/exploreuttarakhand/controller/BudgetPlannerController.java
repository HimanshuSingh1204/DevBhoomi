package com.example.exploreuttarakhand.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/budget")
public class BudgetPlannerController {

    @PostMapping("/plan")
    public Map<String, Object> planBudget(@RequestBody Map<String, Double> request) {
        double budget = request.get("budget");
        int days = request.get("days").intValue();
        // Simple logic
        Map<String, Object> response = new HashMap<>();
        response.put("suggestedPlaces", "Nainital, Mussoorie");
        response.put("costBreakdown", "Accommodation: 5000, Food: 3000, Travel: 2000");
        response.put("totalEstimatedCost", 10000.0);
        return response;
    }
}