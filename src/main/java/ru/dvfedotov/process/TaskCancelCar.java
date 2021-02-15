package ru.dvfedotov.process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskCancelCar implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(TaskCancelCar.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("******* TaskCancelCar *********** "+ delegateExecution.getProcessBusinessKey());
    }
}
