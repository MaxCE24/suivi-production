package net.atos.suiviproduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.atos.suiviproduction.model.Validation;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

}
