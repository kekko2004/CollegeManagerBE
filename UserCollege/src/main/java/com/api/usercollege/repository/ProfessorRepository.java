package com.api.usercollege.repository;

import com.api.usercollege.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {
    @Query("SELECT p FROM Professor p WHERE p.role = :role")
    List<Professor> findByRole(@Param("role") String role);


}
