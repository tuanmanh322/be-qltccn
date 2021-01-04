package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Vi;
import com.datn.qltccn.repository.ViRepository;
import com.datn.qltccn.service.ViService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ViServiceImpl implements ViService {
    private final ViRepository viRepository;

    public ViServiceImpl(ViRepository viRepository) {
        this.viRepository = viRepository;
    }

    @Override
    public void add(Vi vi) {
        vi.setModifiedDate(LocalDateTime.now());
        viRepository.save(vi);
    }

    @Override
    public Vi getById(Integer id) {
        return viRepository.getOne(id);
    }

    @Override
    public List<Vi> getAll() {
        return viRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        viRepository.deleteById(id);
    }

    @Override
    public void edit(Vi vi) {
        Vi  v = viRepository.getOne(vi.getId());
        v.setDescription(vi.getDescription());
        v.setIdLoaiVi(vi.getIdLoaiVi());
        v.setModifiedDate(LocalDateTime.now());
        v.setMoney(vi.getMoney());
        viRepository.save(v);
    }
}
