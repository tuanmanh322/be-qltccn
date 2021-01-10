package com.datn.qltccn.service.impl;

import com.datn.qltccn.controller.ThongBaoController;
import com.datn.qltccn.dao.LoaiThongBaoDAO;
import com.datn.qltccn.dto.LoaiThongBaoSearchDTO;
import com.datn.qltccn.model.Loaithongbao;
import com.datn.qltccn.model.Thongbao;
import com.datn.qltccn.model.ThongbaoUser;
import com.datn.qltccn.repository.LoaithongbaoRepository;
import com.datn.qltccn.repository.ThongbaoRepository;
import com.datn.qltccn.repository.ThongbaoUserRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.LoaiThongBaoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class LoaiThongBaoServiceImpl implements LoaiThongBaoService {
    private final LoaiThongBaoDAO loaiThongBaoDAO;

    private final ModelMapper modelMapper;

    private final LoaithongbaoRepository loaithongbaoRepository;

    private final ThongbaoRepository thongbaoRepository;

    private final ThongbaoUserRepository thongbaoUserRepository;

    public LoaiThongBaoServiceImpl(LoaiThongBaoDAO loaiThongBaoDAO, ModelMapper modelMapper, LoaithongbaoRepository loaithongbaoRepository, ThongbaoRepository thongbaoRepository, ThongbaoUserRepository thongbaoUserRepository) {
        this.loaiThongBaoDAO = loaiThongBaoDAO;
        this.modelMapper = modelMapper;
        this.loaithongbaoRepository = loaithongbaoRepository;
        this.thongbaoRepository = thongbaoRepository;
        this.thongbaoUserRepository = thongbaoUserRepository;
    }

    @Override
    public void search(LoaiThongBaoSearchDTO dto) {
        loaiThongBaoDAO.search(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public void add(Loaithongbao loaithongbao) {
        loaithongbaoRepository.save(loaithongbao);
    }

    @Override
    public Loaithongbao getById(Integer id) {
        return loaithongbaoRepository.getOne(id);
    }

    @Override
    public List<Loaithongbao> getAll() {
        return loaithongbaoRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        loaithongbaoRepository.deleteById(id);
        List<Thongbao> thongbaos = thongbaoRepository.findAllByIdloaithongbao(id);
        if (!CollectionUtils.isEmpty(thongbaos)){
            for (Thongbao tb: thongbaos){
                List<ThongbaoUser> thongbaoUsers = thongbaoUserRepository.findAllByIdThongbao(tb.getId());
                if (!CollectionUtils.isEmpty(thongbaoUsers)){
                    thongbaoUserRepository.deleteAll(thongbaoUsers);
                }
            }
            thongbaoRepository.deleteAll(thongbaos);
        }


    }

    @Override
    public void edit(Loaithongbao loaithongbao) {
        Loaithongbao ltb = loaithongbaoRepository.getOne(loaithongbao.getId());
        ltb.setTenloaithongbao(loaithongbao.getTenloaithongbao());
        loaithongbaoRepository.save(ltb);
    }
}
