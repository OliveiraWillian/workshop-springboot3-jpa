package com.willianoliveira.projetobeta.services;

import com.willianoliveira.projetobeta.dto.UserDTO;
import com.willianoliveira.projetobeta.dto.UserDTO;
import com.willianoliveira.projetobeta.dto.UserDTO;
import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.entities.User;
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
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> findAll() {
        List<User> entity = userRepository.findAll();
        List<UserDTO> listDTO = entity.stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
        return listDTO;
    }

    public UserDTO findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new ResourceNotFoundException(id));
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }



    public void delete(Long id) {

        if (!userRepository.findById(id).isPresent()) {
            throw new ResourceNotFoundException(id);
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserDTO save(UserDTO dto) {
        User entity = new User(dto);
        User saved = userRepository.save(entity);
        return new UserDTO(saved);
    }


    public UserDTO update(UserDTO userBody, Long id) {
        try {
            User entity = userRepository.getReferenceById(id);
            updatefuncao(entity, userBody);
            User saved = userRepository.save(entity);
            return new UserDTO(saved);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updatefuncao(User entity, UserDTO userBody) {
        entity.setName(userBody.getName());
        entity.setEmail(userBody.getEmail());
        entity.setPhone(userBody.getPhone());
    }
}
