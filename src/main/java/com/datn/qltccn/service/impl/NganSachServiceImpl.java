package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.NganSachDAO;
import com.datn.qltccn.dto.NganSachDTO;
import com.datn.qltccn.dto.NganSachSearchDTO;
import com.datn.qltccn.model.Ngansach;
import com.datn.qltccn.repository.NgansachRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.NganSachService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.YearMonth;
import java.util.ArrayList;
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
        ns.setNgaytao(ngansach.getNgaytao());
        ns.setVonglap(ngansach.getVonglap());
        ns.setSotien(ngansach.getSotien());
        ngansachRepository.save(ns);
    }

    @Override
    public void search(NganSachSearchDTO dto) {
        nganSachDAO.searchNganSach(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public List<Integer> getListByMonth(int year) {
        Integer idUser =  SecurityUtils.getCurrentUserIdLogin();
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i<=12; i++){
            int total = 0;
            List<Ngansach> chiphis=   ngansachRepository.getListByMonth(i,year , idUser);
            if (!chiphis.isEmpty()){
                for (Ngansach cp: chiphis){
                    total = total + Integer.parseInt(cp.getSotien());
                }
            }
            data.add(total);
        }
        return data;
    }

    @Override
    public List<Ngansach> getAllNsByMonthAndYear(int month, int year) {
        return ngansachRepository.getListByMonth(month,year , SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public Integer getAllByIDLNS(Integer idLNS) {
        int total = 0;
        List<Ngansach> ngansaches = ngansachRepository.findAllByIdLoaiNganSach(idLNS);
        if (!CollectionUtils.isEmpty(ngansaches)){
            for (Ngansach ns: ngansaches){
                total+= Integer.parseInt(ns.getSotien());
            }
        }
        return total;
    }

    @Override
    public List<Integer> getAllShow(int month, int year) {
        List<Integer> data = new ArrayList<>();
        Integer idUser = SecurityUtils.getCurrentUserIdLogin();
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int i = 1; i <= daysInMonth; i++) {
            int total = 0;
            List<NganSachDTO> nganSachDTOS = nganSachDAO.getAllByMonthAndYearAndIdLoaiNS(i, month, year, idUser);
            if (!nganSachDTOS.isEmpty()) {
                for (NganSachDTO ns : nganSachDTOS) {
                    total+= Integer.parseInt(ns.getSotien());
                }
            }
            data.add(total);
        }
        return data;
    }
}
