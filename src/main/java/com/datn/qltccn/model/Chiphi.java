package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "chiphi")
@Data
@Entity
public class Chiphi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "loaingansach")
    private String loaingansach;

    @Column(name = "loaitien")
    private String loaitien;

    @Column(name = "mota")
    private String mota;

    @Column(name = "ngaytao")
    private String ngaytao;

    @Column(name = "sotien")
    private String sotien;

    
}