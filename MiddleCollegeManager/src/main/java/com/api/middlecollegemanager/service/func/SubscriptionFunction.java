package com.api.middlecollegemanager.service.func;

import com.api.middlecollegemanager.model.advanced.Course;
import com.api.middlecollegemanager.model.advanced.Subscription;
import com.api.middlecollegemanager.model.base.user.Student;
import com.api.middlecollegemanager.service.CourseService;
import com.api.middlecollegemanager.service.StudentService;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionFunction extends Path {

    public Subscription fillSubscription(Subscription subscription){

        Student student = restTemplate.getForObject(
                getStudent() + "/freshman/"+ subscription.getStudent(),
                Student.class);
        subscription.setCourse(subscription.getCourse());
        subscription.setStudent_name(student.getName());
        subscription.setStudent_surname(student.getSurname());
        return subscription;
    }

    public List<Subscription> bindingSubscription(List<Subscription> subscriptions){
        for(Subscription s: subscriptions){
            this.fillSubscription(s);
        }
        return subscriptions;
    }
}
