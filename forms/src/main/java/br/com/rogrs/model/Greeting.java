package br.com.rogrs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="GREETING")
public class Greeting extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	private final String content;

	public Greeting(String content) {

		this.content = content;
	}

	public String getContent() {
		return content;
	}
}