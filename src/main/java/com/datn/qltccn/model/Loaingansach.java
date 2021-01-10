package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "loaingansach")
public class Loaingansach implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "loaingansach")
    private String loaingansach;

    @Column(name = "tenloaingansach")
    private String tenloaingansach;

    @Column(name = "id_user")
    private int idUser;

    @Column(name = "han_muc")
    private int hanMuc;
}