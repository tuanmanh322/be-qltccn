package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Chiphi;
import com.datn.qltccn.repository.ChiphiRepository;
import com.datn.qltccn.service.ChiPhiService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChiPhiServiceImpl implements ChiPhiService {
    private final ChiphiRepository chiphiRepository;

    private final ModelMapper modelMapper;

    public ChiPhiServiceImpl(ChiphiRepository chiphiRepository, ModelMapper modelMapper) {
        this.chiphiRepository = chiphiRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(Chiphi chiphi) {
        chiphiRepository.save(chiphi);
    }

    @Override
    public Chiphi getById(Integer id) {
        return chiphiRepository.getOne(id);
    }

    @Override
    public List<Chiphi> getAll() {
        return chiphiRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        chiphiRepository.deleteById(id);
    }

    @Override
    public void edit(Chiphi chiphi) {

    }
}
