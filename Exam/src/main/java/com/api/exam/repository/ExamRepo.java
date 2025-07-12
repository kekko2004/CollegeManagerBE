package com.api.exam.repository;

import com.api.exam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamRepo extends JpaRepository<Exam,Long> {
    List<Exam> findByFreshman(String freshman);
    List<Exam> findByAppeal(Long appeal);
}
