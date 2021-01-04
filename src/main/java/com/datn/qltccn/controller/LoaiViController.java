package com.datn.qltccn.controller;

import com.datn.qltccn.dto.LoaiViSearchDTO;
import com.datn.qltccn.model.Loaivi;
import com.datn.qltccn.service.LoaiViService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loai-vi")
public class LoaiViController {
    private final LoaiViService loaiViService;

    public LoaiViController(LoaiViService loaiViService) {
        this.loaiViService = loaiViService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loaivi>> getAll(){

        return new ResponseEntity<>(loaiViService.getAll(), HttpStatus.OK);
    }

//    @GetMapping("/year/{mon}")
//    public ResponseEntity<List<Integer>> getAllByMonth(@PathVariable("mon") int month){
//        return new ResponseEntity<>(loaiViService.getListByMonth(month), HttpStatus.OK);
//    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Loaivi> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(loaiViService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Loaivi color){
        loaiViService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Loaivi color){
        loaiViService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        loaiViService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<LoaiViSearchDTO> search(@RequestBody LoaiViSearchDTO dto){
        loaiViService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
