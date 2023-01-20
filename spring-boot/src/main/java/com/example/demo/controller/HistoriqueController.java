package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Historique;
import com.example.demo.repository.HitsoriqueRepository;
import com.example.demo.response.Succes;
import com.example.demo.response.Error;

@RestController
@CrossOrigin("*")
public class HistoriqueController {
    
    @Autowired
    HitsoriqueRepository historiqueRepository;

    @GetMapping("encheres/{id}/details")
    public ResponseEntity getDetails(@PathVariable(value = "id") Long id){

        List<Historique> liste = (List<Historique>) historiqueRepository.findByIdenchere(id);
        
        ResponseEntity responseentity = null;

        Succes succes = new Succes();
        succes.setData(liste);

        responseentity = new ResponseEntity(succes, HttpStatus.CREATED);

        return responseentity;
    }

    @PostMapping("enchere/rencherir")
    public ResponseEntity Rencherir(@RequestBody Historique historique){

        ResponseEntity responseentity = null;

        try {

            historiqueRepository.save(historique);

            Succes succes = new Succes();
            HashMap data = new HashMap();
            data.put("message", "Success");
            succes.setData(data);
            responseentity = new ResponseEntity(succes, HttpStatus.CREATED);
            return responseentity;
        }
        catch(Exception ex){
            Error error = new Error();

            HashMap errordata = new HashMap();
            errordata.put("code", "404");
            errordata.put("message", "Failed");

            error.setError(errordata);
            responseentity = new ResponseEntity(error, HttpStatus.CREATED);
            return responseentity;
        }
    }
}
