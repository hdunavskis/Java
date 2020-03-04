package com.ait.Rest_FastFood.rest;


import java.util.Base64;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ait.Rest_FastFood.controller.PasswordChecker;
import com.ait.Rest_FastFood.data.FoodDAO;
import com.ait.Rest_FastFood.data.OrderDAO;
import com.ait.Rest_FastFood.data.UserDAO;
import com.ait.Rest_FastFood.model.Customer;
import com.ait.Rest_FastFood.model.Food;
import com.ait.Rest_FastFood.model.Order;
import com.ait.Rest_FastFood.model.User;


@Path("/food")
@Stateless
@LocalBean
public class WebServices {
	
	private PasswordChecker passwordChecker;
	private Customer customer;
	
	@EJB
	private FoodDAO foodDAO;
	
	@EJB
	private OrderDAO orderDAO;
	@EJB
	private UserDAO userDAO;
	
	
	@GET
	@Path("/login")
	public Response login(@HeaderParam("authorization") String auth) {

		if (isAuthenticationValid(auth)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.BAD_REQUEST).build();

	}
	 
	
	
	private boolean isAuthenticationValid(String authentication) {
		String[] auth = authentication.split("\\s+");
		String userNameAndPasswordEncrypted = auth[1];
		byte[] bytes = null;
		String password = null;
		String userName = null;
		try {
			
			bytes = Base64.getDecoder().decode(userNameAndPasswordEncrypted);
			password = new String(bytes);
			
			userName = password.substring(0, password.indexOf(":"));
			password = password.substring(userName.length()+1, password.length());
			
			
			customer = userDAO.getCustomer(userName);
			
			passwordChecker = PasswordChecker.createPasswordChecker();
			
			return passwordChecker.checkIfPasswordsMatch(password, customer.getSalt(), customer.getPassword());
			
			
		} catch (Exception e) {
			return false;
		}
	
	}



	@GET
	@Path("/orders")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrders() {
		List<Order> orders = orderDAO.getAllOrders();
		
		if(orders.size() > 0) {
			return Response.status(Status.OK).entity(orders).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/orders/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMyOrder(@PathParam("id") int id) {
		
		try {
			return Response.status(Status.OK).entity(orderDAO.getSingleOrder(id)).build();
			
		} catch (Exception e) {
			//e.printStackTrace();
			
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnFullMenu() {

		List<Food> food = foodDAO.getAllFood();

		if (!food.isEmpty()) {
			return Response.status(Status.OK).entity(food).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@POST
	@Path("/orders")
	public Response createAnOrder(Order order) {
		
		try {
			orderDAO.placeAnOrder(order);
			
			return Response.status(Status.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@PUT
	public Response updateOrder(Order order) {
		
		try {
			orderDAO.update(order);
			
			return Response.status(Status.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
