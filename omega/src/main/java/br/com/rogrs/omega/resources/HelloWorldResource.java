package br.com.rogrs.omega.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("application/json")
public class HelloWorldResource {

	@GET
	@Path("/world")
	public String test() {
		return "Hello world!";
	}
	
	@GET
	public String hello() {
		return "Hello!";
	}
}