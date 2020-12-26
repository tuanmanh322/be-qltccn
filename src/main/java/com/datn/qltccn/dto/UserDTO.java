package com.datn.qltccn.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer id;

    private String username;

    private String userImage;

    private Date createdDate;

    private Date modifiedDate;

    private String roleName;

    private String pass;

    private Integer idRole;

    private String diachi;

    private String email;

    private String ngaysinh;

    private String nghenghiep;

    private String tenkhachhang;
}
