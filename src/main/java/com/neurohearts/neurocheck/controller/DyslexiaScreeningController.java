package com.neurohearts.neurocheck.controller;

import com.neurohearts.neurocheck.model.ConsentEntity;
import com.neurohearts.neurocheck.model.DyslexiaScreeningData;
import com.neurohearts.neurocheck.model.PatternRecognitionResult;
import com.neurohearts.neurocheck.model.WordMatchResult;
import com.neurohearts.neurocheck.services.DyslexiaScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/neurohearts/neurocheck/dyslexia")
@CrossOrigin(origins = "http://localhost:3000") // for frontend integration
public class DyslexiaScreeningController {

    @Autowired
    private DyslexiaScreeningService service;

    @PostMapping("/consent")
    public ResponseEntity<Map<String, Object>> saveConsent(@RequestBody ConsentEntity data) {
        String screeningId = service.saveConsent(data);
        return ResponseEntity.ok(Map.of("screeningId", screeningId));
    }

    @PostMapping("/saveCheckList")
    public ResponseEntity<?> saveChecklist(@RequestBody DyslexiaScreeningData data) {
        System.out.println("Received request....");
        service.saveScreening(data);
        return ResponseEntity.ok(Map.of("status", "Checklist saved"));
    }

    @PostMapping("/saveWordMatch")
    public ResponseEntity<?> saveWordMatch(@RequestBody WordMatchResult data) {
        service.saveWordMatch(data);
        return ResponseEntity.ok(Map.of("status", "Word Match saved"));
    }

    @PostMapping("/savePattern")
    public ResponseEntity<?> savePattern(@RequestBody PatternRecognitionResult result) {
        service.savePatternRecognition(result);
        return ResponseEntity.ok(Map.of("status", "Pattern saved"));
    }

    @GetMapping("/results/{screeningId}")
    public ResponseEntity<?> getFullResults(@PathVariable String screeningId) {
        Map<String, Object> results = service.getResultsByScreeningId(screeningId);
        return ResponseEntity.ok(results);
    }
}
