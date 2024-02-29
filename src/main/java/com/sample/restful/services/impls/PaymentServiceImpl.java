//package com.sample.restful.services.impls;
//
//import com.sample.restful.entities.Payment;
//import com.sample.restful.models.requests.PayRequest;
//import com.sample.restful.models.responses.Detail_PaymentDTO;
//import com.sample.restful.repositories.PaymentRepository;
//import com.sample.restful.services.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PaymentServiceImpl implements PaymentService {
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//
//    @Override
//    public Payment findById(Long id) {
//       if(id == null)
//       {
//           return  null;
//       }
//       return paymentRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void delete(Payment payment) {
//        paymentRepository.delete(payment);
//    }
//
//    @Override
//    public List<Detail_PaymentDTO> calculateTotalAmount() {
//        List<Object[]> results = paymentRepository.calculateTotalAmount();
//        List<Detail_PaymentDTO> paymentDTOList = new ArrayList<>();
//
//        for (Object[] result : results) {
//            Long idHd = (Long) result[0];
//            Double tongTien = (Double) result[1];
//            paymentDTOList.add(new Detail_PaymentDTO(idHd, tongTien));
//        }
//
//        return paymentDTOList;
//    }
//
//    @Override
//    public List<Payment> findAll() {
//        return paymentRepository.findAll();
//    }
//
//    @Override
//    public Payment save(PayRequest request) {
//        Payment payment = findById(request.getId());
//        if (payment == null)
//        {
//            payment = new Payment();
//        }
//        payment.setIdsp(request.getIdsp());
//        payment.setId_details(request.getId_details());
//        payment.setPrice(request.getPrice());
//        payment.setTime(request.getTime());
//
//        return payment;
//    }
//}
