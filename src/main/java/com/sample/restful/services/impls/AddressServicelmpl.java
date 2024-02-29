package com.sample.restful.services.impls;

import com.sample.restful.entities.Address;
import com.sample.restful.models.requests.SaveAddressRequest;
import com.sample.restful.models.requests.SaveProductRequest;
import com.sample.restful.repositories.AddressRepository;
import com.sample.restful.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;

@Service
public class AddressServicelmpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address findById(Long id) {
        if(id==null) {return null;}
        return addressRepository.findById(id).orElse(null);
    }



    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }


    @Override
    public Address save(SaveAddressRequest request) {
        Address address = findById(request.getiD());
        if(address == null){
            address = new Address();
        }
        address.setiDUser(request.getiDUser());
        address.setAddress(request.getAddress());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        address.setPostcode(request.getPostcode());
        address.setActive(request.getActive());
        return null;
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
