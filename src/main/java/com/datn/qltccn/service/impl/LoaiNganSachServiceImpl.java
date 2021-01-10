package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.LoaiNganSachDAO;
import com.datn.qltccn.dto.LoaiNganSachSearchDTO;
import com.datn.qltccn.model.Chiphi;
import com.datn.qltccn.model.Loaingansach;
import com.datn.qltccn.model.Ngansach;
import com.datn.qltccn.repository.ChiphiRepository;
import com.datn.qltccn.repository.LoaingansachRepository;
import com.datn.qltccn.repository.NgansachRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.LoaiNganSachService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class LoaiNganSachServiceImpl implements LoaiNganSachService {
    private final LoaiNganSachDAO loaiNganSachDAO;

    private final ModelMapper modelMapper;

    private final LoaingansachRepository loaingansachRepository;

    private final ChiphiRepository chiphiRepository;

    private final NgansachRepository ngansachRepository;


    public LoaiNganSachServiceImpl(LoaiNganSachDAO loaiNganSachDAO, ModelMapper modelMapper, LoaingansachRepository loaingansachRepository, ChiphiRepository chiphiRepository, NgansachRepository ngansachRepository) {
        this.loaiNganSachDAO = loaiNganSachDAO;
        this.modelMapper = modelMapper;
        this.loaingansachRepository = loaingansachRepository;
        this.chiphiRepository = chiphiRepository;
        this.ngansachRepository = ngansachRepository;
    }

    @Override
    public void search(LoaiNganSachSearchDTO dto) {
        loaiNganSachDAO.search(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public List<Loaingansach> listByUser() {
        return loaingansachRepository.findAllByIdUser(SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public void add(Loaingansach loaingansach) {
        loaingansachRepository.save(loaingansach);
    }

    @Override
    public Loaingansach getById(Integer id) {
        return loaingansachRepository.getOne(id);
    }

    @Override
    public List<Loaingansach> getAll() {
        return loaingansachRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        loaingansachRepository.deleteById(id);
        List<Ngansach> ngansaches = ngansachRepository.findAllByIdLoaiNganSach(id);
        if (!CollectionUtils.isEmpty(ngansaches)){
            ngansachRepository.deleteAll(ngansaches);
        }

        List<Chiphi> chiphis = chiphiRepository.findAllByIdLoaiNganSach(id);
        if (!CollectionUtils.isEmpty(chiphis)){
            chiphiRepository.deleteAll(chiphis);
        }
    }

    @Override
    public void edit(Loaingansach loaingansach) {
        Loaingansach lns = loaingansachRepository.getOne(loaingansach.getId());
        lns.setTenloaingansach(loaingansach.getTenloaingansach());
        loaingansachRepository.save(lns);
    }
}
