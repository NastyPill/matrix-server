package com.matrix.controllers;

import com.matrix.service.MatrixService;
import com.matrix.state.MatrixState;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatrixController {

    private final MatrixService service;

    public MatrixController(MatrixService service) {
        this.service = service;
    }

    @GetMapping("/connect/{ip}")
    public void getState(@PathVariable String ip) {
        service.invertState(ip);
    }

}
