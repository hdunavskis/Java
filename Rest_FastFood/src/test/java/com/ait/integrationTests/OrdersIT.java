package com.ait.integrationTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.Rest_FastFood.model.Order;
import com.ait.Rest_FastFood.model.User;
import com.ait.Rest_FastFood.rest.LoginWS;
import com.ait.Rest_FastFood.rest.OrdersWS;
import com.ait.Utilities.UtilitiesDAO;

@RunWith(Arquillian.class)
public class OrdersIT {
	@Deployment 
	public static Archive<?> createTestArchive() { 
	return ShrinkWrap.create(JavaArchive.class, "Test.jar") 
			.addClasses(UtilitiesDAO.class, AuthHelper.class)
			.addPackages(true, "com/ait/Rest_FastFood")
			.addAsManifestResource("META-INF/persistence.xml",
	  "persistence.xml") .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  
	  }
	
	@EJB
	private OrdersWS ordersws;
	@EJB
	private UtilitiesDAO utilities;
	@EJB
	private LoginWS login;
	private Order order;
	private User user;
	
	@Before
	public void init() {
		utilities.deleteOrders();
		
		user = (User)login.login(AuthHelper.makeBasicAuthHeader("customer", "password")).getEntity();
		order = new Order();
		order.setCustomerId(user.getUserID());
		order.setFoodName("Ceasar salad wrap");
		order.setAmount(1);
		order.setNoteToKitchenStaff("");
		order.setReady(false);
		order.setPaid(true);
		
		utilities.insertOrders(order);
	}
	@Test
	public void test_get_all_paid_orders() {
		
		Response response = ordersws.getAllPaidOrders();
		@SuppressWarnings("unchecked")
		List<Order> orders =(List<Order>) response.getEntity();
		
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(1, orders.size());
	}
	@Test
	public void test_get_all_customer_orders() {
		
		Response response = ordersws.getAllCustomerOrders(user.getUserID());
		@SuppressWarnings("unchecked")
		List<Order> orders =(List<Order>) response.getEntity();
		
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(1, orders.size());
	}
	@Test
	public void test_get_a_single_order_by_id() {
		
		Response response = ordersws.getMyOrder(order.getOrderId());
		
		Order singleOrder = (Order) response.getEntity();
		
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(order.getFoodName(), singleOrder.getFoodName());
	}
	@Test
	public void test_create_an_order() {
		
		Order newOrder = new Order();
		
		newOrder.setCustomerId(user.getUserID());
		newOrder.setFoodName("Ceasar salad wrap");
		newOrder.setAmount(1);
		newOrder.setNoteToKitchenStaff("");
		newOrder.setReady(false);
		newOrder.setPaid(true);
		
		Response response = ordersws.createAnOrder(newOrder);
		
		@SuppressWarnings("unchecked")
		List<Order> orders =(List<Order>) ordersws.getAllCustomerOrders(order.getCustomerId()).getEntity();
		
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
		assertEquals(2, orders.size());
	}
	@Test
	public void test_update_order() {
		
		order.setCustomerId(user.getUserID());
		order.setFoodName("Ceasar salad wrap");
		order.setAmount(5);
		order.setNoteToKitchenStaff("");
		order.setReady(false);
		order.setPaid(true);
		Response response = ordersws.updateOrder(order);
		
		Order singleOrder = (Order) ordersws.getMyOrder(order.getOrderId()).getEntity();
		
		assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());
		assertEquals(order.getAmount(), singleOrder.getAmount());
	}
	@Test
	public void test_update_order_not_found() {
		
		Response response = ordersws.updateOrder(new Order());
	
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());	
	}
	@Test
	public void test_delete_an_order() {
				
		Response response = ordersws.deleteOrder(order.getOrderId());
		@SuppressWarnings("unchecked")
		List<Order> orders = (List<Order>) ordersws.getAllCustomerOrders(user.getUserID()).getEntity();
		
		assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus());	
		assertEquals(0, orders.size());	
	}
}
