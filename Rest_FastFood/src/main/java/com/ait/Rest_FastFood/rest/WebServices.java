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
import com.ait.Rest_FastFood.data.OrderDAO;
import com.ait.Rest_FastFood.data.UserDAO;
import com.ait.Rest_FastFood.model.Food;


@Path("/food")
@Stateless
@LocalBean
public class WebServices {
	
	@EJB
	private FoodDAO foodDAO;
	@EJB
	private OrderDAO orderDAO;
	@EJB
	private UserDAO userDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnFullMenu() {

		List<Food> food = foodDAO.getAllFood();

		if (!food.isEmpty()) {
			return Response.status(Status.OK).entity(food).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
