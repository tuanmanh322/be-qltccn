package com.datn.qltccn.controller;

import com.datn.qltccn.dto.ThuNhapSearchDTO;
import com.datn.qltccn.model.Thunhap;
import com.datn.qltccn.service.ThuNhapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thu-nhap")
public class ThuNhapController {
    private final ThuNhapService thuNhapService;

    public ThuNhapController(ThuNhapService thuNhapService) {
        this.thuNhapService = thuNhapService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Thunhap>> getAll(){

        return new ResponseEntity<>(thuNhapService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Thunhap> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(thuNhapService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Thunhap color){
        thuNhapService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Thunhap color){
        thuNhapService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        thuNhapService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<ThuNhapSearchDTO> search(@RequestBody ThuNhapSearchDTO dto){
        thuNhapService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
