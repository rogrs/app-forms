package br.com.rogrs.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.rogrs.model.StatusTask;
import br.com.rogrs.model.Task;
import br.com.rogrs.repository.TaskRepository;
import br.com.rogrs.sikuli.DefineObjects;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private DefineObjects defineObjects;

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() {

        List<Task> tasks = taskRepository.findByStatus(StatusTask.CREATE);
        if (tasks != null) {
            
            tasks.forEach(this::processar);
         
        }
    }

    private void processar(final Task task) {
        try {
            log.info("The time is now {}", dateFormat.format(new Date()));
           
            defineObjects.open();
            task.setStatus(StatusTask.PROCESS);
        } catch (Exception e) {
            log.error("Erro ao executar task "+task.getDescription(), e);
            task.setStatus(StatusTask.ERROR);
            e.printStackTrace();
        }finally{
            taskRepository.saveAndFlush(task);
        }
    }
}