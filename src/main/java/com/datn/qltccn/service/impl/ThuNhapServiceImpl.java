package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Thunhap;
import com.datn.qltccn.repository.ThunhapRepository;
import com.datn.qltccn.service.ThuNhapService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThuNhapServiceImpl implements ThuNhapService {
    private final ThunhapRepository thunhapRepository;

    private final ModelMapper modelMapper;

    public ThuNhapServiceImpl(ThunhapRepository thunhapRepository, ModelMapper modelMapper) {
        this.thunhapRepository = thunhapRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(Thunhap thunhap) {
        thunhapRepository.save(thunhap);
    }

    @Override
    public Thunhap getById(Integer id) {
        return null;
    }

    @Override
    public List<Thunhap> getAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        thunhapRepository.deleteById(id);
    }

    @Override
    public void edit(Thunhap thunhap) {

    }
}
