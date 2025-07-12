package com.api.booklet.repository;

import com.api.booklet.entity.Booklet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookletRepository extends JpaRepository<Booklet, Long> {
    List<Booklet> findByFreshman(String freshman);

    List<Booklet> findByAppeal(Long appeal);
}
