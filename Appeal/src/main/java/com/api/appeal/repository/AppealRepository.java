package com.api.appeal.repository;

import com.api.appeal.entity.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppealRepository extends JpaRepository<Appeal, Long> {

    List<Appeal> findByDateAfter(Date date);

    List<Appeal> findByDateBefore(Date date);

    List<Appeal> findByCourse(Long course);
}
