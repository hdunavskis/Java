package com.ait.Rest_FastFood.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class PaymentTest {

	@Given("^A customer has placed an order$")
	public void a_customer_has_placed_an_order() throws Throwable {
	    
	}

	@When("^the customer clicks on the \"([^\"]*)\" pay$")
	public void the_customer_clicks_on_the_pay(String arg1) throws Throwable {
	  
	}

	@Then("^the customer should see a (\\d+) to pay$")
	public void the_customer_should_see_a_to_pay(int arg1) throws Throwable {
	    
	}

	@Then("^make a payment by clicking the \"([^\"]*)\" payment$")
	public void make_a_payment_by_clicking_the_payment(String arg1) throws Throwable {
	   
	}

}
