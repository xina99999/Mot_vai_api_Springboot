package com.sample.restful.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Details_table")
public class Details_payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Id_sp")
    private  Long id_sp;

    @Column(name = "Id_hd")
    private  Long id_hd;

    @Column(name = "SL")
    private Long SL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_sp() {
        return id_sp;
    }

    public void setId_sp(Long id_sp) {
        this.id_sp = id_sp;
    }

    public Long getId_hd() {
        return id_hd;
    }

    public void setId_hd(Long id_hd) {
        this.id_hd = id_hd;
    }

    public Long getSL() {
        return SL;
    }

    public void setSL(Long SL) {
        this.SL = SL;
    }

    public Details_payment() {
    }
}
