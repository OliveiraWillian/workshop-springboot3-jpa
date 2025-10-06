package com.willianoliveira.projetobeta.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Erro ao tentar buscar o id " + id);
    }
}
