package com.spaceprogram.rest;

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

import com.spaceprogram.data.MissionDAO;
import com.spaceprogram.model.Mission;

@Path("/missions")
@Stateless
@LocalBean
public class MissionWS {
	
	@EJB
	private MissionDAO missionDAO;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrders() {
		List<Mission> missions = missionDAO.getAllMissions();
		
		if(!missions.isEmpty()) {
			return Response.status(Status.OK).entity(missions).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMyOrder(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(missionDAO.getMissionById(id)).build();
	}
	@GET
	@Path("/searchshuttle/{shuttle}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMyOrder(@PathParam("shuttle") String shuttle) {

		List<Mission> missions = missionDAO.getMissionForAShuttle(shuttle);
		if (missions.isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(missions).build();
	}
}
