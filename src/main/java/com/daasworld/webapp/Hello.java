package com.daasworld.webapp;

import com.wordnik.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
@Api(value = "/hello", description = "Hello Operations")
@Produces({"application/json", "application/xml"})
public class Hello{

    @GET
    @Path("/")
    @Produces( { MediaType.APPLICATION_JSON } )
    @ApiOperation(value = "hello world", notes = "More notes about this method", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Blah blah"),
            @ApiResponse(code = 404, message = "blah blah blah blah")
    })
    public String sayHello() {
        System.out.println("sayHello called...");
        return "Hello World from the servlet";
    }
}