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

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User userUpdate, Long id) {
        User userSql = userRepository.getReferenceById(id);
        User userAtualizado = updatefuncao(userSql,userUpdate);
        return userAtualizado;

    }

    private User updatefuncao(User userSql, User userUpdate) {
        userSql.setName(userUpdate.getName());
        userSql.setEmail(userUpdate.getEmail());
        userSql.setPhone(userUpdate.getPhone());
        return userSql;
    }

}
