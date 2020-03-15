package com.ait.racing;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/horses")
@Stateless
@LocalBean
public class RaceWS {
	@EJB
	private RaceDAO raceDAO;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<RaceHorse> horses = raceDAO.getAllHorses();
		
		if(horses.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity("No results found").build();
		}
		return Response.status(Status.OK).entity(horses).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
				
		return Response.status(Status.OK).entity(raceDAO.getById(id)).build();

	}
	@GET
	@Path("/search/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("name") String name) {
		
		return Response.status(Status.OK).entity(raceDAO.getByName(name)).build();
		
	}
}
