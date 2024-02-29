package com.sample.restful.repositories;

import com.sample.restful.entities.Details_payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public  interface  DetailsRepository extends JpaRepository<Details_payment, Long>
{


}

