package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.LoaiThongBaoDAO;
import com.datn.qltccn.dto.LoaiNganSachDTO;
import com.datn.qltccn.dto.LoaiThongBaoDTO;
import com.datn.qltccn.dto.LoaiThongBaoSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LoaiThongBaoDAOImpl extends AbstractDAO implements LoaiThongBaoDAO {
    @Override
    public void search(LoaiThongBaoSearchDTO dto, Integer idUser) {
        StringBuilder sb = new StringBuilder();
        Map<String,Object> pa = new HashMap<>();

        sb.append(" select distinct lns.id ,");
        sb.append(" lns.tenloaithongbao ");
        sb.append(" from loaithongbao as lns left join user as u on u.id = lns.id_user ");
        sb.append(" where 1 = 1");
        sb.append(" and u.id =:p_ida ");
        pa.put("p_ida",idUser);
        if (StringUtils.isNotEmpty(dto.getTenloai())){
            sb.append(" and lns.tenloaithongbao like :p_tel");
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
        sb.append(" order by lns.tenloaithongbao ");
        searchAndCountTotal(dto, sb.toString(), pa, LoaiThongBaoDTO.class);

    }
}
