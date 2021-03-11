package com.Alish.midka.event.Handler;

import com.Alish.midka.event.UserEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        System.out.println("-------------------------------");
        System.out.println("User with id: " + userEvent.getUserId() + " made a purchase ");
        System.out.println("THX");
    }
}
