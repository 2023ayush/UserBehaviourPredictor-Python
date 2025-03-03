package com.UserBehaviorPredictor.service;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class PredictService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String PYTHON_API_URL = "http://localhost:5001/predict";

    public String predictUserBehavior(Map<String, Object> userData) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(userData, headers);

        ResponseEntity<String> response = restTemplate.exchange(PYTHON_API_URL, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}

