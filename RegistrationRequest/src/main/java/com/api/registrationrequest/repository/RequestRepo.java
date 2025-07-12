package com.api.registrationrequest.repository;

import com.api.registrationrequest.Entity.RequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<RequestDto, Long> {
}
