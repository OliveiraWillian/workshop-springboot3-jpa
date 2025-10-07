package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.exceptions.DatabaseException;
import com.willianoliveira.projetobeta.exceptions.ResourceNotFoundException;
import com.willianoliveira.projetobeta.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {

            Optional<User> userOptional = userRepository.findById(id);
            User userSelect = userOptional.orElseThrow(() -> new ResourceNotFoundException(id));
            return userSelect;

    }

    public User save(User user) {
        return userRepository.save(user);
    }


    public void delete(Long id) {

            if(!userRepository.findById(id).isPresent()) {
                throw new ResourceNotFoundException(id);
            }
            try {
                userRepository.deleteById(id);
            }catch (DataIntegrityViolationException e) {
                throw new DatabaseException(e.getMessage());
            }



    }


    public User update(User userBody, Long id) {
        try {
            User userSql = userRepository.getReferenceById(id);
            User userAtualizado = updatefuncao(userSql, userBody);
            return userRepository.save(userAtualizado);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private User updatefuncao(User userSql, User userBody) {
        userSql.setName(userBody.getName());
        userSql.setEmail(userBody.getEmail());
        userSql.setPhone(userBody.getPhone());

        return userSql;
    }

}
