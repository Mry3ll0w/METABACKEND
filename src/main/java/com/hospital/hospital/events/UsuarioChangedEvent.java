package com.hospital.hospital.events;

import org.springframework.context.ApplicationEvent;

public class UsuarioChangedEvent extends ApplicationEvent {
    public UsuarioChangedEvent(Object source) {
        super(source);
    }
}
