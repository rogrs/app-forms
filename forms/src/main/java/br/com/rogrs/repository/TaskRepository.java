package br.com.rogrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogrs.model.StatusTask;
import br.com.rogrs.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    public List<Task> findByStatus(StatusTask status);

    
}
