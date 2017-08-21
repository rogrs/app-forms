package br.com.rogrs.omega.resources;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rogrs.omega.entity.Stormtrooper;
import br.com.rogrs.omega.repository.StormtrooperRepository;

@Path("/troopers")
@Produces("application/json")
public class StormtrooperResource {

	@Autowired
	private StormtrooperRepository stormtrooperRepository;

	@Path("/{id}")
	@GET
	public Stormtrooper getTrooper(@PathParam("id") Long id) throws NotFoundException {

		Stormtrooper stormtrooper = stormtrooperRepository.findOne(id);
		if (stormtrooper == null) {
			throw new NotFoundException();
		}
		return stormtrooper;
	}

	@POST
	public Stormtrooper createTrooper(Stormtrooper trooper) {
		return stormtrooperRepository.save(trooper);
	}

	@Path("/{id}")
	@POST
	public Stormtrooper updateTrooper(Stormtrooper updatedTrooper)
			throws NotFoundException {
		Stormtrooper stormtrooper = stormtrooperRepository.findOne(updatedTrooper.getId());
		stormtrooper.setPlanetOfOrigin(updatedTrooper.getPlanetOfOrigin());
		stormtrooper.setSpecies(updatedTrooper.getSpecies());
		stormtrooper.setType(updatedTrooper.getType());
	
		return stormtrooperRepository.save(stormtrooper);
	}

	@Path("/{id}")
	@DELETE
	public void deleteTrooper(@PathParam("id") Long id) {
		stormtrooperRepository.delete(id);
	}

	@GET
	public Collection<Stormtrooper> listTroopers() {
		return stormtrooperRepository.findAll();
	}
}
