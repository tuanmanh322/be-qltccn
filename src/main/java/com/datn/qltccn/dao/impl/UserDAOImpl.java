package com.datn.qltccn.dao.impl;

import com.datn.qltccn.dao.UserDAO;
import com.datn.qltccn.dto.UserDTO;
import com.datn.qltccn.dto.UserSearchDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    private final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);


    @Override
    public void searchUser(UserSearchDTO userSearchDTO) {
        log.info("start DAO to searchUser with :{}", userSearchDTO);
        final StringBuilder sb = new StringBuilder();
        Map<String, Object> param = new HashMap<>();
        sb.append(" select distinct u.id as id,");
        sb.append(" r.id as idRole,");
        sb.append(" u.username as username,");
        sb.append(" u.pass as pass,");
        sb.append(" r.name_role as roleName,");
        sb.append(" kh.tenkhachhang as tenkhachhang,");
        sb.append(" kh.ngaysinh as ngaysinh,");
        sb.append(" kh.nghenghiep as nghenghiep,");
        sb.append(" kh.diachi as diachi,");
        sb.append(" kh.email as email");
        sb.append(" from qttccn.user as u");
        sb.append(" left join qttccn.khachhang as kh on kh.id_user = u.id ");
        sb.append(" left join qttccn.role as r on u.id_role = r.id ");
        sb.append(" where 1 = 1");
        if (StringUtils.isNotBlank(userSearchDTO.getUsername())) {
            sb.append(" and u.username like :p_userName");
            param.put("p_userName", "%" + userSearchDTO.getUsername().trim() + "%");
        }
        if (StringUtils.isNotBlank(userSearchDTO.getTenkhachhang())){
            sb.append(" and kh.tenkhachhang like :p_tt");
            param.put("p_tt","%" + userSearchDTO.getTenkhachhang().trim() + "%");
        }
        sb.append(" order by u.username");
        searchAndCountTotal(userSearchDTO, sb.toString(), param, UserDTO.class);
    }
}
