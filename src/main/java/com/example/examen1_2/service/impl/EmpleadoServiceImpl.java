package com.example.examen1_2.service.impl;

import com.example.examen1_2.dto.EmpleadoRequest;
import com.example.examen1_2.dto.EmpleadoResponse;
import com.example.examen1_2.entity.Empleado;
import com.example.examen1_2.repository.EmpleadoRepository;
import com.example.examen1_2.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public EmpleadoResponse crearEmpleado(EmpleadoRequest request) {

        // 🔴 MAPEO CORRECTO DTO → ENTITY
        Empleado empleado = new Empleado();
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setCorreo(request.getCorreo());
        empleado.setSalario(request.getSalario());

        // guardar en BD
        Empleado guardado = empleadoRepository.save(empleado);

        // ENTITY → RESPONSE
        return new EmpleadoResponse(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getApellido(),
                guardado.getCorreo(),
                guardado.getSalario()
        );
    }

    @Override
    public List<EmpleadoResponse> listarEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(e -> new EmpleadoResponse(
                        e.getId(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getCorreo(),
                        e.getSalario()
                ))
                .collect(Collectors.toList());
    }
}