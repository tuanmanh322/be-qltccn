package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "thongbao_user")
public class ThongbaoUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_thongbao")
    private Integer idThongbao;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "ngaytaothongbao")
    private String ngaytaothongbao;

    @Column(name = "trangthai")
    private String trangthai;

    
}