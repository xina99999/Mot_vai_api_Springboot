package com.sample.restful.models.responses;

import com.sample.restful.entities.Address;

public class AddressDTO {
    private Long iD;
    private int  iDUser;
    private String address;
    private String city;
    private String country;
    private String postcode;
    private String active;

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public int getiDUser() {
        return iDUser;
    }

    public void setiDUser(int iDUser) {
        this.iDUser = iDUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public AddressDTO() {
    }
    public static AddressDTO from(Address address)
    {
        AddressDTO response = new AddressDTO();
        response.setiDUser(address.getiDUser());
        response.setAddress(address.getAddress());
        response.setCity(address.getCity());
        response.setCountry(address.getCountry());
        response.setPostcode(address.getPostcode());
        response.setActive(address.getActive());
        return response;
    }
}
