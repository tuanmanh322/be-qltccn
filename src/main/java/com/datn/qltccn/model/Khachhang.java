package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "khachhang")
@Entity
public class Khachhang implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "ngaysinh")
    private String ngaysinh;

    @Column(name = "nghenghiep")
    private String nghenghiep;

    @Column(name = "tenkhachhang")
    private String tenkhachhang;

    
}