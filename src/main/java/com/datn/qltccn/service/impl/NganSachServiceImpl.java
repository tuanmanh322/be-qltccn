package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.NganSachDAO;
import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.model.Ngansach;
import com.datn.qltccn.repository.NgansachRepository;
import com.datn.qltccn.security.SecurityUtils;
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

    private final NganSachDAO nganSachDAO;

    public NganSachServiceImpl(NgansachRepository ngansachRepository, ModelMapper modelMapper, NganSachDAO nganSachDAO) {
        this.ngansachRepository = ngansachRepository;
        this.modelMapper = modelMapper;
        this.nganSachDAO = nganSachDAO;
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
        Ngansach ns = ngansachRepository.getOne(ngansach.getId());
        ns.setIdLoaiNganSach(ngansach.getIdLoaiNganSach());
        ns.setLoaitien(ngansach.getLoaitien());
        ns.setNgaybatdau(ngansach.getNgaybatdau());
        ns.setVonglap(ngansach.getVonglap());
        ngansachRepository.save(ns);
    }

    @Override
    public void search(NganSachSearchDTO dto) {
        nganSachDAO.searchNganSach(dto, SecurityUtils.getCurrentUserIdLogin());
    }
}
