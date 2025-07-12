package com.api.course.repository;

import com.api.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByEndBefore(Date end);
    /*List<Course> findByEndAfter(Date end);
    List<Course> findByStartBefore(Date start);*/

    List<Course> findByStartAfter(Date start);

    List<Course> findBySubscriptionOpenTrue();
    List<Course> findBySubscriptionOpenFalse();


    List<Course> findBySubscriptionStartDayAfter(Date subscriptionStartDay);

    List<Course> findByStartBeforeAndEndAfter(Date start, Date end);

    List<Course> findBySubscriptionEndDayBefore(Date subscriptionEndDay);

    List<Course> findByDepartment(Long department);
    List<Course> findBySubject(String subject);
    List<Course> findByProf(String prof);
}
