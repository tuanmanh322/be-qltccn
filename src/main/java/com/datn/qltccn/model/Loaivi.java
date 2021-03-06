package com.datn.qltccn.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "loaivi")
@Entity
@Data
public class Loaivi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "ten_vi")
    private String tenVi;

    
}