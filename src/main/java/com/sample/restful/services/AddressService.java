package com.sample.restful.services;

import com.sample.restful.entities.Address;

import com.sample.restful.models.requests.SaveAddressRequest;


import java.util.List;

public interface AddressService {
    Address findById(Long id);
    List<Address> findAll();
    Address save(SaveAddressRequest request);
    void delete(Address address);

}
