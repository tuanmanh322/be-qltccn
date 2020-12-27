package com.datn.qltccn.controller;

import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.model.Chiphi;
import com.datn.qltccn.service.ChiPhiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chi-phi")
public class ChiPhiController {
    private final ChiPhiService chiPhiService;

    public ChiPhiController(ChiPhiService chiPhiService) {
        this.chiPhiService = chiPhiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chiphi>> getAll(){

        return new ResponseEntity<>(chiPhiService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/month/{mon}")
    public ResponseEntity<List<Integer>> getAllByMonth(@PathVariable("mon") int month){
        return new ResponseEntity<>(chiPhiService.getListByMonth(month), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Chiphi> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(chiPhiService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Chiphi color){
        chiPhiService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Chiphi color){
        chiPhiService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        chiPhiService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<ChiPhiSearchDTO> search(@RequestBody ChiPhiSearchDTO dto){
        chiPhiService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
