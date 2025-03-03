package com.UserBehaviorPredictor.controller;

import com.UserBehaviorPredictor.service.PredictService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/predict")
public class PredictController {
    private final PredictService predictService;

    public PredictController(PredictService predictService) {
        this.predictService = predictService;
    }

    @PostMapping("/user")
    public String predictUser(@RequestBody Map<String, Object> userData) {
        return predictService.predictUserBehavior(userData);
    }
}
