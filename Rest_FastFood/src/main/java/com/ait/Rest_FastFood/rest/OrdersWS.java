package com.ait.Rest_FastFood.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.ait.Rest_FastFood.data.OrderDAO;
import com.ait.Rest_FastFood.model.Order;

@Path("/orders")
@Stateless
@LocalBean
public class OrdersWS {
		
	@EJB
	private OrderDAO orderDAO;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPaidOrders() {
		List<Order> orders = orderDAO.getAllOrders();
		
		return Response.status(Status.OK).entity(orders).build();
	}
	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomerOrders(@PathParam("id") int customerId) {
		List<Order> orders = orderDAO.getAllCustomerOrders(customerId);
		
		return Response.status(Status.OK).entity(orders).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMyOrder(@PathParam("id") int id) {
		return Response.status(Status.OK).entity(orderDAO.getSingleOrder(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAnOrder(Order order) {
		
		orderDAO.placeAnOrder(order);

		return Response.status(Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(Order order) {
		
		Order updateOrder = orderDAO.getSingleOrder(order.getOrderId());
		
		if(updateOrder == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		orderDAO.update(order);

		return Response.status(Status.NO_CONTENT).build();
	}
	
	@DELETE
	@Path("/{orderId}")
	public Response deleteOrder(@PathParam("orderId") int orderId) {
		
		orderDAO.removeOrder(orderId);
		
		return Response.status(Status.NO_CONTENT).build();
	}
}
