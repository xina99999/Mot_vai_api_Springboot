package com.sample.restful.models.responses;

public class Detail_PaymentDTO {
    private Long idHd;
    private Double tongTien;

    public Detail_PaymentDTO(Long idHd, Double tongTien) {
        this.idHd = idHd;
        this.tongTien = tongTien;
    }

    public Long getIdHd() {
        return idHd;
    }

    public void setIdHd(Long idHd) {
        this.idHd = idHd;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
}
