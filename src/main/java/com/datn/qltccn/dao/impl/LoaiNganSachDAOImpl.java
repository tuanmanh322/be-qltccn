package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.LoaiNganSachDAO;
import com.datn.qltccn.dto.LoaiNganSachDTO;
import com.datn.qltccn.dto.LoaiNganSachSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LoaiNganSachDAOImpl extends AbstractDAO implements LoaiNganSachDAO {
    @Override
    public void search(LoaiNganSachSearchDTO dto) {
        StringBuilder sb = new StringBuilder();
        Map<String,Object> pa = new HashMap<>();

        sb.append(" select distinct lns.id ,");
        sb.append(" lns.tenloaingansach ");
        sb.append(" from loaingansach as lns");
        sb.append(" where 1 = 1");
        if (StringUtils.isNotEmpty(dto.getTenloai())){
            sb.append(" and lns.tenloaingansach like :p_tel");
            pa.put("p_tel", "%" + dto.getTenloai().trim() + "%");
        }
//        if (!dto.getOrders().isEmpty()){
//            sb.append(" order by ");
//            dto.getOrders().forEach(or -> {
//                String property = StringUtils.trimToEmpty(or.getProperty());
//                switch (property){
//                    case "new"
//                }
//            });
//        }
        sb.append(" order by lns.tenloaingansach ");
        searchAndCountTotal(dto, sb.toString(), pa, LoaiNganSachDTO.class);

    }
}