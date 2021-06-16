package com.matrix.controllers;

import com.matrix.service.MatrixService;
import com.matrix.state.MatrixState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MatrixController {

    private final MatrixService service;

    public MatrixController(MatrixService service) {
        this.service = service;
    }

    @GetMapping("/state")
    public ResponseEntity<MatrixState> getState() {
        service.invertState();
        return ResponseEntity.ok(service.getState());
    }

}
