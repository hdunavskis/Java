package com.ait.lab4b;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/wines")
public class WineResource {

	WineDAO dao = new WineDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Wine> findAll() {
		System.out.println("findAll");
		return dao.findAll();
	}
	
	@Path("/{wineID}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Wine findOneWine(@PathParam("wineID") int wineID) {
		
		return dao.findById(wineID);
		
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public Wine create(Wine wine) {
		
		return dao.create(wine);
	}

	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public Wine update(Wine wine) {
		
		
		return dao.update(wine);
	}
	
	@DELETE
	@Path("{id}")
	//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public Response delete(@PathParam("id") int wineID) {
		try {
			
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for " + wineID).build();
	}





}
