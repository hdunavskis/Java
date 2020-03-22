package com.ait.integrationTests;

import static org.junit.Assert.*;

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

import com.ait.Rest_FastFood.model.User;
import com.ait.Rest_FastFood.rest.LoginWS;
import com.ait.Rest_FastFood.util.StartupBean;
import com.ait.Utilities.UtilitiesDAO;

@RunWith(Arquillian.class)
public class StartupIT {

	@Deployment 
	public static Archive<?> createTestArchive() { 
	return ShrinkWrap.create(JavaArchive.class, "Test.jar") 
			.addClasses(UtilitiesDAO.class, AuthHelper.class)
			.addPackages(true, "com/ait/Rest_FastFood")
			.addAsManifestResource("META-INF/persistence.xml",
	  "persistence.xml") .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  
	  }
	
	@EJB
	private StartupBean sBean;
	@EJB
	private UtilitiesDAO utilities;
	@EJB
	private LoginWS login;
	
	private User user;
	@Before
	public void init() {
		utilities.deleteOrders();
		utilities.deleteUsers();
		
	
	}
	@Test
	public void test_create_user() {
		sBean.createAdminUser();
		user = (User)login.login(AuthHelper.makeBasicAuthHeader("customer", "password")).getEntity();
		
		assertEquals("customer", user.getUserName());
	
	}

}
