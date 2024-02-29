//package com.sample.restful.repositories;
//
//
//import com.sample.restful.entities.Payment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface PaymentRepository extends JpaRepository<Payment,Long> {
//    @Query(" select id_hd , sl*price as tong_tien from payment  " +
//            "join Details_table as dt on dt.id_hd = payment.id " +
//            "join product as p on dt.id_sp = p.id "
//           )
//    List<Object[]> calculateTotalAmount();
//
//}
//
