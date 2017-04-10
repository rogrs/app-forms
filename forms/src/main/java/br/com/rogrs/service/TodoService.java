package br.com.rogrs.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rogrs.exception.TodoNotFoundException;
import br.com.rogrs.model.Todo;
import br.com.rogrs.model.TodoDTO;
import br.com.rogrs.repository.TodoRepository;


@Service
public class TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoService.class);

    private TodoRepository repository;

    @Autowired
    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Todo add(TodoDTO added) {
        LOGGER.debug("Adding a new to-do entry with information: {}", added);

        Todo model = Todo.getBuilder(added.getTitle())
                .description(added.getDescription())
                .build();

        return repository.save(model);
    }

    @Transactional(rollbackFor = {TodoNotFoundException.class})
    public Todo deleteById(Long id) throws TodoNotFoundException {
        LOGGER.debug("Deleting a to-do entry with id: {}", id);

        Todo deleted = findById(id);
        LOGGER.debug("Deleting to-do entry: {}", deleted);

        repository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll() {
        LOGGER.debug("Finding all to-do entries");
        return (List<Todo>) repository.findAll();
    }

    @Transactional(readOnly = true, rollbackFor = {TodoNotFoundException.class})
    public Todo findById(Long id) throws TodoNotFoundException {
        LOGGER.debug("Finding a to-do entry with id: {}", id);

        Todo found = repository.findOne(id);
        LOGGER.debug("Found to-do entry: {}", found);

        if (found == null) {
            throw new TodoNotFoundException("No to-entry found with id: " + id);
        }

        return found;
    }

    @Transactional(rollbackFor = {TodoNotFoundException.class})
    public Todo update(TodoDTO updated) throws TodoNotFoundException {
        LOGGER.debug("Updating contact with information: {}", updated);

        Todo model = findById(updated.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(updated.getDescription(), updated.getTitle());

        return model;
    }
}
