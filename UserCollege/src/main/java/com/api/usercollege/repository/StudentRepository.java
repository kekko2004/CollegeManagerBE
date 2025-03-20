package com.api.usercollege.repository;

import com.api.usercollege.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findbyEmail(String email);

    @Query("SELECT s FROM Student s WHERE YEAR(s.registrationYear) = :year")
    List<Student> findByRegistrationYear(@Param("year") int year);
}
