package ru.agiletech.teammate.service.input.ports.eventbus;

public interface PipeFilter<T> {

    void onEvent(T serializedEvent);

}
