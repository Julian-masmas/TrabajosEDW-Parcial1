package com.example.examen1_2.service.impl;

import com.example.examen1_2.dto.EmpleadoRequest;
import com.example.examen1_2.dto.EmpleadoResponse;
import com.example.examen1_2.entity.Empleado;
import com.example.examen1_2.repository.EmpleadoRepository;
import com.example.examen1_2.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public EmpleadoResponse crearEmpleado(EmpleadoRequest empleadoRequest) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setApellido(empleadoRequest.getApellido());
        empleado.setCorreo(empleadoRequest.getCorreo());
        empleado.setSalario(empleadoRequest.getSalario());

        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        return mapToResponse(empleadoGuardado);
    }

    @Override
    public List<EmpleadoResponse> listarEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private EmpleadoResponse mapToResponse(Empleado empleado) {
        return new EmpleadoResponse(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCorreo(),
                empleado.getSalario());
    }
}