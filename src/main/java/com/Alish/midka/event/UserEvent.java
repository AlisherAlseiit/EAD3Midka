package com.Alish.midka.event;

import com.Alish.midka.model.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {
    private Long userId;

    public UserEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
