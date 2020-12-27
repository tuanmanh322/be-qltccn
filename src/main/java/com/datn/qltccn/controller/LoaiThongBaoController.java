package com.datn.qltccn.controller;

import com.datn.qltccn.dto.LoaiThongBaoSearchDTO;
import com.datn.qltccn.model.Loaithongbao;
import com.datn.qltccn.service.LoaiThongBaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loai-thong-bao")
public class LoaiThongBaoController {
    private final LoaiThongBaoService loaiThongBaoService;

    public LoaiThongBaoController(LoaiThongBaoService loaiThongBaoService) {
        this.loaiThongBaoService = loaiThongBaoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Loaithongbao>> getAll(){

        return new ResponseEntity<>(loaiThongBaoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Loaithongbao> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(loaiThongBaoService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Loaithongbao color){
        loaiThongBaoService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Loaithongbao color){
        loaiThongBaoService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        loaiThongBaoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<LoaiThongBaoSearchDTO> search(@RequestBody LoaiThongBaoSearchDTO dto){
        loaiThongBaoService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
