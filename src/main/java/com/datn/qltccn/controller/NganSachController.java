package com.datn.qltccn.controller;

import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.dto.ThuNhapSearchDTO;
import com.datn.qltccn.model.Ngansach;
import com.datn.qltccn.service.NganSachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ngan-sach")
public class NganSachController {
    private final NganSachService nganSachService;

    public NganSachController(NganSachService nganSachService) {
        this.nganSachService = nganSachService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ngansach>> getAll(){

        return new ResponseEntity<>(nganSachService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/year/{ye}")
    public ResponseEntity<List<Integer>> getAllByMonth(@PathVariable("ye") int year){
        return new ResponseEntity<>(nganSachService.getListByMonth(year), HttpStatus.OK);
    }

    @GetMapping("/check-full/{month}/{year}")
    public ResponseEntity<List<Ngansach>> getAllByMonthAndYear(@PathVariable("month") int month, @PathVariable("year") int year){
        return new ResponseEntity<>(nganSachService.getAllNsByMonthAndYear(month,year), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Ngansach> getById(@PathVariable("id")Integer id){
        return new ResponseEntity<>(nganSachService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNew(@RequestBody Ngansach color){
        nganSachService.add(color);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> edit(@RequestBody Ngansach color){
        nganSachService.edit(color);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable("id")Integer id){
        nganSachService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<NganSachSearchDTO> search(@RequestBody NganSachSearchDTO dto){
        nganSachService.search(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/lns/{lns}")
    public ResponseEntity<Integer> getAllByLNS(@PathVariable("lns") int idLNS){
        return new ResponseEntity<>(nganSachService.getAllByIDLNS(idLNS), HttpStatus.OK);
    }
}
