package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }



    public User update(User userBody, Long id) {
        User userSql = userRepository.getReferenceById(id);
        User userAtualizado = updatefuncao(userSql,userBody);
        return userAtualizado;

    }

    private User updatefuncao(User userSql, User userBody) {
        userSql.setName(userBody.getName());
        userSql.setEmail(userBody.getEmail());
        userSql.setPhone(userBody.getPhone());
        userRepository.save(userSql);
        return userSql;
    }

}
