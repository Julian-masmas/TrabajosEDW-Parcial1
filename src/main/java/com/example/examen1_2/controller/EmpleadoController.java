package com.example.examen1_2.controller;

import com.example.examen1_2.dto.EmpleadoRequest;
import com.example.examen1_2.dto.EmpleadoResponse;
import com.example.examen1_2.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponse> crearEmpleado(@RequestBody EmpleadoRequest empleadoRequest) {
        EmpleadoResponse empleadoResponse = empleadoService.crearEmpleado(empleadoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoResponse);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }
}