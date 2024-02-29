package com.sample.restful.repositories;

import com.sample.restful.entities.User;
import com.sample.restful.models.responses.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    User  findByUserName(String UserName);

}

