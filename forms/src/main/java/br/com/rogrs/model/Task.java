package br.com.rogrs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="TASK")
public class Task extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String description;
    private StatusTask status;

    public Task() {

    }

    public Task(String description) {
        this.description = description;
       this.status = StatusTask.CREATE;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

}
