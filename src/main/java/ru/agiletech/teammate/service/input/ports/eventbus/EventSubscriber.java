package ru.agiletech.teammate.service.input.ports.eventbus;

public interface EventSubscriber<T> {

    void onEvent(T serializedEvent);

}
