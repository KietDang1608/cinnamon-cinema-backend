package com.example.cinnamon_cinema_backend.controllers;

import com.example.cinnamon_cinema_backend.services.MockDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mock-data")
public class MockDataController {
    private final MockDataService mockDataService;

    @GetMapping("/mock")
    public ResponseEntity<?> mockData() {
        mockDataService.mockData();
        return ResponseEntity.ok("Mock data created successfully");
    }
    @GetMapping("/clear")
    public ResponseEntity<?> clearData() {
        mockDataService.clearData();
        return ResponseEntity.ok("Mock data cleared successfully");
    }
}
