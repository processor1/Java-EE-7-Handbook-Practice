/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1

*/

@Path("/hello")
public class HelloRest {
    @GET
    @Produces("text/plain")
    public String hello(){
        return "Hello From EE 7";
    }
}
