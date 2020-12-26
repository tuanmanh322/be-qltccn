package com.datn.qltccn.controller;

import com.datn.qltccn.model.Thongbao;
import com.datn.qltccn.service.ThongBaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thong-bao")
public class ThongBaoController {
    private final ThongBaoService thongBaoService;

    public ThongBaoController(ThongBaoService thongBaoService) {
        this.thongBaoService = thongBaoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Thongbao>> getAll(){

        return new ResponseEntity<>(thongBaoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Thongbao> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(thongBaoService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Thongbao color){
        thongBaoService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Thongbao color){
        thongBaoService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        thongBaoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
