/**
 * 
 */
package com.flipkart.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import com.flipkart.bean.Customer;
//import com.flipkart.bean.CustomerXml;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path(value= "/customer")
public class CustomerControler {
	
	
	
	@GET
	@Path(value="/listCustomer")
	@Produces(MediaType.APPLICATION_JSON)
		public Customer listCustomer(){
		 
		   Customer customer=new Customer();
		   customer.setCustomerId(101);
           customer.setCustomerName("Hitesh/Burhan");
           customer.setCustomerAddress("delhi");
		     
		
		return customer;
		
	}
	 @GET
	    @Path("/getCustomerXML")
	    @Produces(MediaType.APPLICATION_XML)
	    public Response getCustomerXml() {
		 //logger.info("Xml");
	        Customer customer = new Customer();
	        customer.setCustomerId(23);
	        customer.setCustomerName("Shubham");
	        customer.setCustomerAddress("India");
	        System.out.println(customer);
	        return Response.status(200).entity(customer).build();
	    }
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCustomer(Customer customer) {
        System.out.println("hit post service");
        
        System.out.println("value of title from UI " +customer.getCustomerName());
        System.out.println("value of singer form UI" +customer.getCustomerId());
		
        
        String result = "Track saved : " + customer;
		
		
		return Response.status(201).entity(result).build();
		
	}  
	//delete customer
	@DELETE
	@Path("/delete/{CustomerId}")
	public Response deleteTrackInJSON(@PathParam("CustomerId") int Cid)
	throws URIReferenceException{
		//when we get customer id pass it to the business logic
		// implementation
		return Response.status(200).entity("Track id " +Cid+
				"successfully deleted").build();
	}
	//Update
	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer updateCustomer(Customer customer){
		
		customer.setCustomerName(customer.getCustomerName() +"updated");
		return customer;
		
	}
}
