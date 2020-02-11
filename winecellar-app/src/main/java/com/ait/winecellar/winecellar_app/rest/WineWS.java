package com.ait.winecellar.winecellar_app.rest;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.EJB;
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

import com.ait.winecellar.winecellar_app.data.WineDAO;
import com.ait.winecellar.winecellar_app.model.Wine;


@Path("/wines")
@Stateless
@LocalBean
public class WineWS {

	@EJB
	private WineDAO wineDao;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllWines() {
		System.out.println("Get all wines++test");
		List<Wine> wines=wineDao.getAllWines();
		System.out.println("got wines");
		System.out.println(wines.size());
		return Response.status(200).entity(wines).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/{id}")
	public Response findWineById(@PathParam("id") int id) {
		try {
			return Response.status(200).entity(wineDao.getWineById(id)).build();
		} catch (Exception e) {
			
			return Response.status(400).build();
		}
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response saveWine(Wine wine) {
		try {
			wineDao.saveWine(wine);
			return Response.status(201).entity(wine).build();
			
		} catch (Exception e) {
			
			return Response.status(400).build();
		}
	}
	// id needed for update?
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/json")
	//@Path("/{id}")
	public Response updateWine(Wine wine/*@PathParam("id") int id*/) {
		try {
			wineDao.updateWine(wine);
			return Response.status(200).entity(wine).build();
		} catch (Exception e) {
			return Response.status(406).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteWine(@PathParam("id") int id) {
		try {
			wineDao.removeWine(id);
			return Response.status(200).build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
	}
	
	@GET
	@Path("search/{country}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Wine> getWineByCountry(@PathParam("country") String country) {
		try {
			return wineDao.getByCountry(country);
			//return Response.status(200).entity(wineDao.getByCountry(country)).build();
		} catch (Exception e) {
			return null;//Response.status(400).entity(e).build();
		}
	}
	
	
}
