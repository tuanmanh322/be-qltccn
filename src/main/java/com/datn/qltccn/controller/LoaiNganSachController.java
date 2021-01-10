package com.datn.qltccn.controller;

import com.datn.qltccn.dto.LoaiNganSachSearchDTO;
import com.datn.qltccn.model.Loaingansach;
import com.datn.qltccn.service.LoaiNganSachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loai-ngan-sach")
public class LoaiNganSachController {
    private final LoaiNganSachService loaiNganSachService;

    public LoaiNganSachController(LoaiNganSachService loaiNganSachService) {
        this.loaiNganSachService = loaiNganSachService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loaingansach>> getAll(){

        return new ResponseEntity<>(loaiNganSachService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all-by")
    public ResponseEntity<List<Loaingansach>> getAllByUser(){
        return new ResponseEntity<>(loaiNganSachService.listByUser(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Loaingansach> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(loaiNganSachService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Loaingansach color){
        loaiNganSachService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Loaingansach color){
        loaiNganSachService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        loaiNganSachService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<LoaiNganSachSearchDTO> search(@RequestBody LoaiNganSachSearchDTO dto){
        loaiNganSachService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
