package com.datn.qltccn.controller;

import com.datn.qltccn.dto.ViDTO;
import com.datn.qltccn.model.Vi;
import com.datn.qltccn.service.ViService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi")
public class ViController {
    private final ViService viService;

    public ViController(ViService viService) {
        this.viService = viService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vi>> getAll(){

        return new ResponseEntity<>(viService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Vi> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(viService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Vi color){
        viService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Vi color){
        viService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        viService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-user-login")
    public ResponseEntity<ViDTO> getByUser(){
        return null;
    }
}
