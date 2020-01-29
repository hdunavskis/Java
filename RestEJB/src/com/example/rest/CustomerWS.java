package com.example.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customers")
@Stateless
@LocalBean
public class CustomerWS {

    @EJB
    private CustomerDAO customersDao;

    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id) {
    	System.out.println("test");
        return customersDao.getCustomer(id);
    }
    @GET
    @Path("/")
    public List<Customer> getAllCustomers() {
    	
    	return customersDao.getAllCustomers();
    }
    
    @POST
    public void addCustomers(List<Customer> customers) {
        customersDao.addCustomers(customers);
    }
    
}
