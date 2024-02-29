package com.sample.restful.models.responses;

import com.sample.restful.entities.Payment;
import jakarta.persistence.Column;

import java.util.Date;

public class PaymentDTO {
    private Long id;

    private Long idsp;
    private Date time;
    private Long price;
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

    public PaymentDTO() {
    }

    public static PaymentDTO from(Payment payment)
    {
        PaymentDTO response = new PaymentDTO();
        response.setId(payment.getId());
        response.setIdsp(payment.getIdsp());
        response.setTime(payment.getTime());
        response.setPrice(payment.getPrice());
        response.setId_details(payment.getId_details());
        return response;
    }

}
