/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.filters;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
*/

@Provider
public class ExpHttpRequest implements ContainerResponseFilter{
	
    static private SimpleDateFormat format=new SimpleDateFormat("EEE,dd MMMyyy  HH:mm:ss Z");
    
	@Override 
	public void filter(ContainerRequestContext reqContext,ContainerResponseContext respContext)throws IOException{
	
            if(reqContext.getMethod().equals("GET")){
                 Date date=new Date(System.currentTimeMillis()  + 60 * 100);
                respContext.getHeaders().add("Expires",format.format(date));
            }
            
            if(reqContext.getMethod().equals("POST")){
                Date date=new Date(System.currentTimeMillis()  + 60 * 100);
                respContext.getHeaders().add("Expires",format.format(date));
                
            }
	}
    
}