package ru.dvfedotov.process;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskBookHotel implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(TaskBookHotel.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("******* TaskBookHotel *********** " + delegateExecution.getProcessBusinessKey());

        String processDefinitionId = delegateExecution.getProcessDefinitionId();
        log.info("******* processDefinitionId =  " + processDefinitionId);

        String activityInstanceId = delegateExecution.getActivityInstanceId();
        log.info("******* activityInstanceId =  " + activityInstanceId);

        String currentActivityId = delegateExecution.getCurrentActivityId();
        log.info("******* currentActivityId  =  " + currentActivityId);

        String currentActivityName = delegateExecution.getCurrentActivityName();
        log.info("******* currentActivityName  =  " + currentActivityName);

        String processInstanceId = delegateExecution.getProcessInstanceId();
        log.info("******* processInstanceId   =  " + processInstanceId);


        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
//        ProcessDefinition processDefinition = processEngine.getRepositoryService().createProcessDefinitionQuery()
//            .versionTag("v5")
//            .latestVersion()
//            .singleResult();


        ProcessDefinition processDefinition = processEngine.getRepositoryService().getProcessDefinition(processDefinitionId);
        String versionTag = processDefinition.getVersionTag();
        log.info("******* versionTag =  " + versionTag);

        int version = processDefinition.getVersion();
        log.info("******* version =  " + version);

    }
}
