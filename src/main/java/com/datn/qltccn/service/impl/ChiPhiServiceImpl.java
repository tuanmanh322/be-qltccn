package com.datn.qltccn.service.impl;

import com.datn.qltccn.dao.ChiPhiDAO;
import com.datn.qltccn.dto.ChiPhiDTO;
import com.datn.qltccn.dto.ChiPhiSearchDTO;
import com.datn.qltccn.model.Chiphi;
import com.datn.qltccn.repository.ChiphiRepository;
import com.datn.qltccn.security.SecurityUtils;
import com.datn.qltccn.service.ChiPhiService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
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
        chiphi.setModifiedDate(new Date());
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
        cp.setNgaytao(chiphi.getNgaytao());
        cp.setMota(chiphi.getMota());
        cp.setSotien(chiphi.getSotien());
        cp.setIdLoaiNganSach(chiphi.getIdLoaiNganSach());
        chiphiRepository.save(cp);
    }

    @Override
    public void search(ChiPhiSearchDTO dto) {
        chiPhiDAO.searchChiPhi(dto, SecurityUtils.getCurrentUserIdLogin());
    }

    @Override
    public List<Integer> getListByMonth(int year) {
        List<Integer> data = new ArrayList<>();
        Integer idUser =  SecurityUtils.getCurrentUserIdLogin();
        for (int i = 1; i<=12; i++){
            int total = 0;
          List<Chiphi> chiphis=   chiphiRepository.getListByMonth(i, year ,idUser);
          if (!chiphis.isEmpty()){
                for (Chiphi cp: chiphis){
                    total = total + Integer.parseInt(cp.getSotien());
                }
              data.add(total);
          }else{
              data.add(total);
          }
        }
        return data;
    }

    @Override
    public List<Integer> getListByIDlns(int month, int year) {
        List<Integer> data = new ArrayList<>();
        Integer idUser =  SecurityUtils.getCurrentUserIdLogin();
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        for (int i = 1; i<=daysInMonth; i++){
            int total = 0;
            List<ChiPhiDTO> chiphis=   chiPhiDAO.getAllByMonthAndYearAndIdLoaiNS(i,month, year ,idUser);
            if (!chiphis.isEmpty()){
                for (ChiPhiDTO cp: chiphis){
                    total = total + Integer.parseInt(cp.getSotien());
                }
            }
            data.add(total);
        }
        return data;
    }

    @Override
    public boolean listByMonthAndDay() {
        Date d =new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(d);
        int month = cl.get(Calendar.MONTH);
        int day = cl.get(Calendar.DATE);
        int year =cl.get(Calendar.YEAR);
        List<ChiPhiDTO> chiPhiDTOS = chiPhiDAO.getAllByMonthAndDaysIDuser(day,month + 1,year, SecurityUtils.getCurrentUserIdLogin());
        return !chiPhiDTOS.isEmpty();
    }
}
