/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.filters;

import java.io.IOException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
*/
@Provider
@PreMatching

public class UserExtraFilter implements ContainerRequestFilter{

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String userAgent=requestContext.getHeaderString("User-Agent");
        if(null!=userAgent){
            requestContext.getHeaders().putSingle("X-User-Agent-Copy",userAgent);
        }
    }
    
    
    
}
