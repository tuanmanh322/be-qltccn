package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Ngansach;
import com.datn.qltccn.repository.NgansachRepository;
import com.datn.qltccn.service.NganSachService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NganSachServiceImpl implements NganSachService {
    private final NgansachRepository ngansachRepository;

    private final ModelMapper modelMapper;

    public NganSachServiceImpl(NgansachRepository ngansachRepository, ModelMapper modelMapper) {
        this.ngansachRepository = ngansachRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(Ngansach ngansach) {
        ngansachRepository.save(ngansach);
    }

    @Override
    public Ngansach getById(Integer id) {
        return ngansachRepository.getOne(id);
    }

    @Override
    public List<Ngansach> getAll() {
        return ngansachRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        ngansachRepository.deleteById(id);
    }

    @Override
    public void edit(Ngansach ngansach) {

    }
}
