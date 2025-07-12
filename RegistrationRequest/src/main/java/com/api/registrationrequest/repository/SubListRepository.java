package com.api.registrationrequest.repository;

import com.api.registrationrequest.Entity.SubList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubListRepository extends JpaRepository<SubList, Long> {

    List<SubList> findByCourse(Long id);
    List<SubList> findByStudent(String student);

}
