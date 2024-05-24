package com.backend2.backend2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend2.backend2.model.Moto;
import com.backend2.backend2.repository.MotoRepository;

@RestController
@RequestMapping("/api/motos")
public class MotoController {

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping
    public List<Moto> getAllMotos() {
        return motoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable("id") Long id) {
        return motoRepository.findById(id)
                .map(moto -> ResponseEntity.ok().body(moto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Moto createMoto(@RequestBody Moto moto) {
        return motoRepository.save(moto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moto> updateMoto(@PathVariable("id") Long id, @RequestBody Moto motoDetails) {
        return motoRepository.findById(id)
                .map(moto -> {
                    moto.setMarca(motoDetails.getMarca());
                    moto.setModelo(motoDetails.getModelo());
                    moto.setAño(motoDetails.getAño());
                    moto.setPrecio(motoDetails.getPrecio());
                    Moto updatedMoto = motoRepository.save(moto);
                    return ResponseEntity.ok().body(updatedMoto);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoto(@PathVariable("id") Long id) {
        return motoRepository.findById(id)
                .map(moto -> {
                    motoRepository.delete(moto);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
