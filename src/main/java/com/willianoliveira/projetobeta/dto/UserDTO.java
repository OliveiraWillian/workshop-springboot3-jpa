package com.willianoliveira.projetobeta.dto;

import com.willianoliveira.projetobeta.entities.User;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public UserDTO() {
    }

    public UserDTO(User entity) {
       this.id = entity.getId();
       this.name = entity.getName();
       this.email = entity.getEmail();
       this.phone = entity.getPhone();
       this.password = entity.getPassword();



}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



