package com.datn.qltccn.dao;

import com.datn.qltccn.dto.UserSearchDTO;

import java.io.Serializable;

public interface UserDAO extends Serializable,BaseDAO {

    void searchUser(UserSearchDTO userSearchDTO);

}
