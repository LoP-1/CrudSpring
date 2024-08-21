package com.quantify.drugstore.repository;

import com.quantify.drugstore.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person,Long> {
}
