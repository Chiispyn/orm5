package com.seccion5.orm5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seccion5.orm5.model.Paciente;
import com.seccion5.orm5.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;


    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes(){
        List<Paciente> pacientes=pacienteService.findAll();
        if(pacientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(pacientes,HttpStatus.OK);
    };
    
    @PostMapping
    public ResponseEntity<Paciente> postPaciente(@RequestBody Paciente paciente) {
        Paciente buscado=pacienteService.findById(paciente.getId());
        if(buscado==null){
        return new ResponseEntity<>(pacienteService.save(paciente),HttpStatus.CREATED);}
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable int id) {
        Paciente buscado=pacienteService.findById(id);
        
         if(buscado!=null){
            return new ResponseEntity<>(buscado,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    
}
