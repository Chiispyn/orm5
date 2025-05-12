package com.seccion5.orm5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seccion5.orm5.model.Paciente;
import com.seccion5.orm5.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente findById(int id){
        return pacienteRepository.findById(id);
    }
}
