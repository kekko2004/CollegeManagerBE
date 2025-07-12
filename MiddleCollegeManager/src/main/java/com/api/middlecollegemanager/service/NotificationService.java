package com.api.middlecollegemanager.service;

import com.api.middlecollegemanager.model.advanced.Notification;
import com.api.middlecollegemanager.service.func.NotificationFunction;
import com.api.middlecollegemanager.service.path.Path;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class NotificationService extends Path {
    private final NotificationFunction notificationFunction;

    public NotificationService(NotificationFunction notificationFunction) {
        this.notificationFunction = notificationFunction;
    }
    public List<Notification> getAll(){
        Notification[] notifications = restTemplate.getForObject(getRequest(), Notification[].class);
        if(notifications != null){
            return notificationFunction.bindingNotification(Arrays.asList(notifications));
        }else{
            return Collections.emptyList();
        }


    }
}
