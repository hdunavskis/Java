package com.ait.wine;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
	
}
