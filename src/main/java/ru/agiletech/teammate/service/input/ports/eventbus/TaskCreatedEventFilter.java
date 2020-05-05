package ru.agiletech.teammate.service.input.ports.eventbus;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import ru.agiletech.teammate.service.application.task.CommandProcessor;
import ru.agiletech.teammate.service.application.task.OpenTaskForTeammateCommand;

import javax.validation.Valid;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TaskCreatedEventFilter implements PipeFilter<Map<String, Object>> {

    private static final String TEAMMATE_ID = "teammateId";
    private static final String TASK_ID     = "taskId";

    private final CommandProcessor<OpenTaskForTeammateCommand> openTaskForTeammateCommandProcessor;

    @Override
    @StreamListener(Sink.INPUT)
    public void onEvent(@Valid Map<String, Object> serializedEvent) {
        String teammateId = (String) serializedEvent.get(TEAMMATE_ID);
        String taskId = (String) serializedEvent.get(TASK_ID);

        var command = new OpenTaskForTeammateCommand(taskId,
                teammateId);

        openTaskForTeammateCommandProcessor.process(command);
    }

}
