package br.com.rogrs.omega.entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Stormtrooper extends AbstractPersistable<Long> {


	private static final long serialVersionUID = 1L;
	private String planetOfOrigin;
    private String species;
    private String type;

    public Stormtrooper() {
        // empty to allow for bean access
    }

    public Stormtrooper(String planetOfOrigin, String species, String type) {

        this.planetOfOrigin = planetOfOrigin;
        this.species = species;
        this.type = type;
    }


	public String getPlanetOfOrigin() {
		return planetOfOrigin;
	}

	public void setPlanetOfOrigin(String planetOfOrigin) {
		this.planetOfOrigin = planetOfOrigin;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
