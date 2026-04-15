package com.example.examen1_2.service;

import com.example.examen1_2.dto.EmpleadoRequest;
import com.example.examen1_2.dto.EmpleadoResponse;

import java.util.List;

public interface EmpleadoService {

    EmpleadoResponse crearEmpleado(EmpleadoRequest empleadoRequest);

    List<EmpleadoResponse> listarEmpleados();
}