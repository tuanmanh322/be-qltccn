package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.ChiPhiDAO;
import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.model.Chiphi;
import com.datn.qltccn.repository.ChiphiRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.ChiPhiService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChiPhiServiceImpl implements ChiPhiService {
    private final ChiphiRepository chiphiRepository;

    private final ModelMapper modelMapper;

    private final ChiPhiDAO chiPhiDAO;

    public ChiPhiServiceImpl(ChiphiRepository chiphiRepository, ModelMapper modelMapper, ChiPhiDAO chiPhiDAO) {
        this.chiphiRepository = chiphiRepository;
        this.modelMapper = modelMapper;
        this.chiPhiDAO = chiPhiDAO;
    }

    @Override
    public void add(Chiphi chiphi) {
        chiphi.setNgaytao(new Date().toString());
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
        Chiphi cp = chiphiRepository.getOne(chiphi.getId());
        cp.setLoaitien(chiphi.getLoaitien());
        cp.setNgaytao(new Date().toString());
        cp.setMota(chiphi.getMota());
        cp.setSotien(chiphi.getSotien());
        cp.setIdLoaiNganSach(chiphi.getIdLoaiNganSach());
        chiphiRepository.save(cp);
    }

    @Override
    public void search(ChiPhiSearchDTO dto) {
        chiPhiDAO.searchChiPhi(dto, SecurityUtils.getCurrentUserIdLogin());
    }
}
