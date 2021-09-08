package com.examenPractico.Inerfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenPractico.model.Clientes;

public interface IClientes extends JpaRepository<Clientes, Long>{

}
