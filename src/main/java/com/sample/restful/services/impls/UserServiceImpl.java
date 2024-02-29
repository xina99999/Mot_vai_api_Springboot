package com.sample.restful.services.impls;

import com.sample.restful.entities.User;
import com.sample.restful.models.requests.SaveUserRequest;
import com.sample.restful.repositories.UserRespository;
import com.sample.restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;

    @Override
    public User findById(Long id) {
        if(id == null){
            return null;
        }
        return userRespository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRespository.findAll();
    }

    @Override
    public User save(SaveUserRequest request) {
        User user = findById(request.getID());
        if(user == null)
        {
            user = new User();
        }
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userRespository.save(user);
    }

    @Override
    public void delete(User user) {
         userRespository.delete(user);
    }

    @Override
    public User findByUserName(String UserName) {
      return userRespository.findByUserName(UserName);
    }




}
