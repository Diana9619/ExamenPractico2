package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Persona;

public interface IPersona extends JpaRepository<Persona, Long> {

}
