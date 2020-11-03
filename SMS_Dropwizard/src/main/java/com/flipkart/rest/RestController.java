/**
 * 
 */
package com.flipkart.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author ShabbirMoosakhan
 *
 */
@Path("/hello")
public class RestController {
	@GET
	@Path("/method1")
    public String getMsg()
    {
         return "Hello World !! - Get Message 2";
    }
	
	@GET
	@Path("/method2")
    public String getMsg1()
    {
         return "Hello World !! - Get Message 1";
    }
}
