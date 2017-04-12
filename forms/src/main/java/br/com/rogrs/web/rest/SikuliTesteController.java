package br.com.rogrs.web.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogrs.model.Task;
import br.com.rogrs.repository.TaskRepository;

@RestController
public class SikuliTesteController {

    public static final String BASE_URL = "/sikuli";

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(SikuliTesteController.BASE_URL)
    public ResponseEntity<Task> executar() {


        Task task = new Task("Teste_"+LocalDate.now());
        taskRepository.saveAndFlush(task);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

}
