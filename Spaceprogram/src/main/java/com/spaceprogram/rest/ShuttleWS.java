package com.spaceprogram.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.spaceprogram.data.ShuttleDAO;
import com.spaceprogram.model.Shuttle;


@Path("/shuttles")
@Stateless
@LocalBean
public class ShuttleWS {

	@EJB
	private ShuttleDAO shuttleDAO;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrders() {
		List<Shuttle> missions = shuttleDAO.getAllShuttles();
		
		if(!missions.isEmpty()) {
			return Response.status(Status.OK).entity(missions).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	
}
