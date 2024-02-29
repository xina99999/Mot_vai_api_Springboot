package com.sample.restful.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name =  "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Id_sp")
    private Long idsp;

    @Column(name = "Time")
    private Date time;

    @Column(name = "Total_Price")
    private Long price;

    @Column(name = "Id_details")
    private Long id_details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdsp() {
        return idsp;
    }

    public void setIdsp(Long idsp) {
        this.idsp = idsp;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId_details() {
        return id_details;
    }

    public void setId_details(Long id_details) {
        this.id_details = id_details;
    }

    public Payment() {
    }
}
