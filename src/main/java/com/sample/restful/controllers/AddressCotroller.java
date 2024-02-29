package com.sample.restful.controllers;

import com.sample.restful.entities.Address;
import com.sample.restful.models.requests.SaveAddressRequest;
import com.sample.restful.models.responses.AddressDTO;
import com.sample.restful.services.AddressService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/Address")
public class AddressCotroller {
    @Autowired
    private AddressService addressService;
    @PostMapping("/save")
    ResponseEntity<AddressDTO> save(@RequestBody SaveAddressRequest request)
    {
        Address saveaddress = addressService.save(request);
        return  new ResponseEntity<>(AddressDTO.from(saveaddress), HttpStatus.OK);

    }

    @PostMapping("/list")
    ResponseEntity<List<AddressDTO>> findAll()
    {
       List<AddressDTO> addresse = addressService.findAll().stream().map(AddressDTO::from).toList();
       return new ResponseEntity<>(addresse,HttpStatus.OK);
    }

    @PostMapping("/Delete")
    ResponseEntity<AddressDTO> Delete(@RequestParam("id") Long id)
    {
        Address address = addressService.findById(id);
        if (address != null)
        {
            addressService.delete(address);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @PostMapping("/detail/{id}")
    ResponseEntity<AddressDTO> findById(@RequestParam("id") Long id)
    {
        Address address = addressService.findById(id);
        if(address == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else  {
            return new ResponseEntity<>(AddressDTO.from(address),HttpStatus.OK);
        }

    }






}

