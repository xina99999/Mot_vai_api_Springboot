//package com.sample.restful.controllers;
//
//import com.sample.restful.models.responses.Detail_PaymentDTO;
//import com.sample.restful.models.responses.PaymentDTO;
//import com.sample.restful.services.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("v1/Pay")
//public class PayController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @GetMapping("/calculateTotalAmount")
//    ResponseEntity<List<Detail_PaymentDTO>> Tinhtoan()
//    {
//        try {
//            List<Detail_PaymentDTO> result = paymentService.calculateTotalAmount();
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//
//}
