package com.ait.integrationTests;


import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.Rest_FastFood.controller.PasswordChecker;
import com.ait.Rest_FastFood.data.FoodDAO;
import com.ait.Rest_FastFood.data.OrderDAO;
import com.ait.Rest_FastFood.model.Food;
import com.ait.Rest_FastFood.model.User;
import com.ait.Rest_FastFood.rest.JaxRsActivator;
import com.ait.Rest_FastFood.rest.WebServices;
import com.ait.Rest_FastFood.util.UtilsDAO;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class IntegrationITest {

	@Deployment 
	public static Archive<?> createTestArchive() { 
	return ShrinkWrap.create(JavaArchive.class, "Test.jar") 
			.addClasses(JaxRsActivator.class, UtilsDAO.class, 
					 WebServices.class, PasswordChecker.class) 
			.addPackage(User.class.getPackage())
			.addPackage(FoodDAO.class.getPackage())
			.addAsManifestResource("META-INF/persistence.xml",
	  "persistence.xml") .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  
	  }
	
	@EJB
	private WebServices webServices;
	@EJB private UtilsDAO utilsDAO;
	
	private Food food;
	
	@Before
	public void init() {
		food = new Food("Ceasar salad wrap", 8.90, "decription5", "food5.png");
		
	}
	
	@Test
	public void get_full_menu() {
		utilsDAO.deleteTables();
		utilsDAO.postFood(food);
		assertEquals(200, webServices.returnFullMenu().getStatus());
	}	 
	
	@Test
	public void return_empty_menu() {
		utilsDAO.deleteTables();
		assertEquals(404, webServices.returnFullMenu().getStatus());
	}	 
}
