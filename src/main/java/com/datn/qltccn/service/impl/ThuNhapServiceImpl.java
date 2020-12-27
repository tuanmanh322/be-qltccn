package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.ThuNhapDAO;
import com.datn.qltccn.dto.ThuNhapSearchDTO;
import com.datn.qltccn.model.Thunhap;
import com.datn.qltccn.repository.ThunhapRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.ThuNhapService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ThuNhapServiceImpl implements ThuNhapService {
    private final ThunhapRepository thunhapRepository;

    private final ModelMapper modelMapper;

    private final ThuNhapDAO thuNhapDAO;

    public ThuNhapServiceImpl(ThunhapRepository thunhapRepository, ModelMapper modelMapper, ThuNhapDAO thuNhapDAO) {
        this.thunhapRepository = thunhapRepository;
        this.modelMapper = modelMapper;
        this.thuNhapDAO = thuNhapDAO;
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
        Thunhap tn =  thunhapRepository.getOne(thunhap.getId());
        tn.setKihan(thunhap.getKihan());
        tn.setLoaitien(thunhap.getLoaitien());
        tn.setMota(thunhap.getMota());
        tn.setNgaytao(LocalDateTime.now());
        tn.setSotien(thunhap.getSotien());
        thunhapRepository.save(tn);
    }

    @Override
    public void search(ThuNhapSearchDTO dto) {
        thuNhapDAO.searchThuNhap(dto, SecurityUtils.getCurrentUserIdLogin());
    }
}
