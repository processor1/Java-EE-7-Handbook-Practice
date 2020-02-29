/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.res.test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.concurrent.Future;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
*/

public class TestHelloEndpoint {
    
    
    static public void main(String[] args)throws InterruptedException, ExecutionException{
        
        Client client=ClientBuilder.newClient();
        WebTarget target=client.target("http://localhost:8080/EE7_HandBook/rest/hello");
        Future<Response> response=target.request().async().get();
        
        Set<String> set=response.get().getStringHeaders().keySet();
        set.forEach((out) -> {
            try {
                System.out.println(out + " == " +  response.get().getStringHeaders().get(out));
            } catch (InterruptedException ex) {
                Logger.getLogger(TestHelloEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(TestHelloEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
        
    }
}
