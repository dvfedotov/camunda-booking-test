package ru.dvfedotov.process;

import org.camunda.bpm.spring.boot.starter.event.ExecutionEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CamundaEventListener {

    @EventListener
    public void onExecutionEvent(ExecutionEvent executionEvent) {
        if (executionEvent.getActivityInstanceId() != null
            && executionEvent.getProcessInstanceId() != null
            && executionEvent.getActivityInstanceId().equals(executionEvent.getProcessInstanceId())
            && "end".equals(executionEvent.getEventName())) {
            System.out.println("******* A process has finished: " + executionEvent.getProcessDefinitionId()
                + "*********"
                + executionEvent.getProcessBusinessKey());
        }
    }
}
