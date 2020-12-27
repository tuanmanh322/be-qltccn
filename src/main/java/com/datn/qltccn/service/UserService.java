package com.datn.qltccn.service;

import com.datn.qltccn.dto.PasswordChange;
import com.datn.qltccn.dto.UserDTO;
import com.datn.qltccn.dto.UserSearchDTO;
import com.datn.qltccn.exception.ResultException;
import com.datn.qltccn.model.User;

import java.util.List;

public interface UserService {
    void userSearch(UserSearchDTO userSearchDTO);

    UserDTO getCurrentUserLogin();

    UserDTO getUserProfileEmp(Integer idUser);

    String getUserNameLogin();

    List<User> getALl();

    void changePassword(PasswordChange passwordChange)throws ResultException;

    void forgotPassword(String email)throws ResultException;

    void doLock(Integer idThe);
    void doUnLock(Integer idThe);

    UserDTO loadUserEdit(int idThe);

    void addNewUser(UserDTO userDTO);

    UserDTO getProfile();

    void addNewUserAdmin(UserDTO userDTO);

    UserDTO editProfile(UserDTO userDTO);

    void editAdmin(UserDTO userDTO);

    void lockUser(Integer id);

    void unLockUser(Integer id);

    void deleteUser(Integer id);
}
