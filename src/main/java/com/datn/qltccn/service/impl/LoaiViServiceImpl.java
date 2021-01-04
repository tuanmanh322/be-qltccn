package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.LoaiViDAO;
import com.datn.qltccn.dto.LoaiViSearchDTO;
import com.datn.qltccn.model.Loaivi;
import com.datn.qltccn.repository.LoaiviRepository;
import com.datn.qltccn.repository.ViRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.LoaiViService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoaiViServiceImpl implements LoaiViService {
    private final LoaiViDAO loaiViDAO;

    private final LoaiviRepository loaiviRepository;

    private final ModelMapper modelMapper;

    private final ViRepository viRepository;

    public LoaiViServiceImpl(LoaiViDAO loaiViDAO, LoaiviRepository loaiviRepository, ModelMapper modelMapper, ViRepository viRepository) {
        this.loaiViDAO = loaiViDAO;
        this.loaiviRepository = loaiviRepository;
        this.modelMapper = modelMapper;
        this.viRepository = viRepository;
    }

    @Override
    public void add(Loaivi loaivi) {
        loaiviRepository.save(loaivi);
    }

    @Override
    public Loaivi getById(Integer id) {
        return loaiviRepository.getOne(id);
    }

    @Override
    public List<Loaivi> getAll() {
        return loaiviRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        loaiviRepository.deleteById(id);
    }

    @Override
    public void edit(Loaivi loaivi) {
        Loaivi lv =loaiviRepository.getOne(loaivi.getId());
        lv.setTenVi(loaivi.getTenVi());
        loaiviRepository.save(lv);
    }

    @Override
    public void search(LoaiViSearchDTO dto) {
        int id = SecurityUtils.getCurrentUserIdLogin();
        loaiViDAO.searchLV(dto, id);
    }
}
