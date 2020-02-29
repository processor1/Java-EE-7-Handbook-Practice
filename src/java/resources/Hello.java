/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Mobile Apps
 */

@Path("Hello")
public class Hello {
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String  sayHello(){
        return "<h2>Hello Jax-RS Rest</h2>";
    }
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXml(){
        return "<?xml version=\"1.0\"?> " + "<hello> Jax-RS Hello Rest" + "</hello>";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlain(){
        return "Jax-Rs Rest Plain";
    }
}
