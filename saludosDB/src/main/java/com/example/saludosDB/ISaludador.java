package com.example.saludosDB;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ISaludador extends CrudRepository<Saludador, Integer>{

    Optional<Saludador> findAllById(int valor);
    
}
