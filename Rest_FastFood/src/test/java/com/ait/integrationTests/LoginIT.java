package com.ait.integrationTests;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ait.Rest_FastFood.rest.LoginWS;

@RunWith(Arquillian.class)
public class LoginIT {
	@Deployment 
	public static Archive<?> createTestArchive() { 
	return ShrinkWrap.create(JavaArchive.class, "Test.jar") 
			.addClass(AuthHelper.class)
			.addPackages(true, "com/ait/Rest_FastFood")
			.addAsManifestResource("META-INF/persistence.xml",
	  "persistence.xml") .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  
	  }
	
	@EJB
	private LoginWS loginws;
	
	@Test
	public void test_login_success() {
		Response response = loginws.login(AuthHelper.makeBasicAuthHeader("customer", "password"));
		
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	@Test
	public void test_login_fail() {
		Response response = loginws.login(AuthHelper.makeBasicAuthHeader("customer", "password2"));
		
		assertEquals(Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
	}
}
