package com.datn.qltccn.service.impl;

import com.datn.qltccn.model.Thongbao;
import com.datn.qltccn.repository.ThongbaoRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.ThongBaoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ThongBaoServiceImpl implements ThongBaoService {
    private final ThongbaoRepository thongbaoRepository;

    private final ModelMapper modelMapper;

    public ThongBaoServiceImpl(ThongbaoRepository thongbaoRepository, ModelMapper modelMapper) {
        this.thongbaoRepository = thongbaoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(Thongbao thongbao) {
        thongbao.setTrangthai(false);
        thongbao.setNgaytao(LocalDateTime.now());
        thongbao.setIdUser(SecurityUtils.getCurrentUserIdLogin());
        thongbaoRepository.save(thongbao);
    }

    @Override
    public Thongbao getById(Integer id) {
        return thongbaoRepository.getOne(id);
    }

    @Override
    public List<Thongbao> getAll() {
        return thongbaoRepository.findAllByIdUser(SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public void delete(Integer id) {
        thongbaoRepository.deleteById(id);
    }

    @Override
    public void edit(Thongbao thongbao) {
        Thongbao tb = thongbaoRepository.getOne(thongbao.getId());
        tb.setIdloaithongbao(thongbao.getIdloaithongbao());
        tb.setMota(thongbao.getMota());
        tb.setNgaytao(thongbao.getNgaytao());
        tb.setNoidung(thongbao.getNoidung());
        tb.setTrangthai(thongbao.isTrangthai());
        thongbaoRepository.save(tb);
    }

    @Override
    public void update() {
        List<Thongbao> thongbaos = getAll();
        for (Thongbao t: thongbaos){
            t.setTrangthai(true);
            thongbaoRepository.save(t);
        }
    }
}
