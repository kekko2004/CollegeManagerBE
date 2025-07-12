package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Subscription;
import com.api.middlecollegemanager.service.func.SubscriptionFunction;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionService extends Path {
    private final SubscriptionFunction subscriptionFunction;

    public SubscriptionService(SubscriptionFunction subscriptionFunction) {
        this.subscriptionFunction = subscriptionFunction;
    }
    @SuppressWarnings("unchecked")
    public List<Subscription> courseSubs(Long course){
        Subscription[] subs = restTemplate.getForObject(
                getRequest() + "/courseID/" + course,
                Subscription[].class
                );
        if(subs!=null){
            for(Subscription s: subs){
                s.setCourse(course);
            }
            return subscriptionFunction.bindingSubscription(Arrays.asList(subs));
        }else{
            return Collections.emptyList();
        }
    }

    public List<Subscription> subsOfStudent(String freshman){
        Subscription[] subs = restTemplate.getForObject(
                getRequest() + "/freshman/" + freshman,
                Subscription[].class
        );
        return subscriptionFunction.bindingSubscription(Arrays.asList(subs));
    }
}
