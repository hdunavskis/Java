package com.ait.Rest_FastFood.rest;


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

import com.ait.Rest_FastFood.data.FoodDAO;
import com.ait.Rest_FastFood.model.Food;


@Path("/view")
@Stateless
@LocalBean
public class WebServices {
	
	@EJB
	private FoodDAO foodDAO;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnFullMenu() {
		try {
			List<Food> food = foodDAO.getAllFood();
			
			if(food.size() > 0) {
				return Response.status(200).entity(food).build();
			}
			return Response.status(Status.NOT_FOUND).build();
			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	

   
   
}
