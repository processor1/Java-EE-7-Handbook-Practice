/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.filters;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1

 */
public class JaxRsClientFilter implements ClientRequestFilter {

    @Override
    public void filter(ClientRequestContext reqCtx) throws IOException {
        
        System.out.printf("**** DEBUG CLIENT REQUEST ****\n");
        System.out.printf("uri: %s\n", reqCtx.getUri());

        if (reqCtx.getEntity() != null) {
            System.out.printf("entity: %s\n", reqCtx.getEntity().getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(reqCtx.getEntity())));
        }
        System.out.printf("method: %s\n", reqCtx.getMethod());
        System.out.printf("mediaType: %s\n", reqCtx.getMediaType());
        System.out.printf("date: %s\n", reqCtx.getDate());
        System.out.printf("language: %s\n", reqCtx.getLanguage());

        for (String name : reqCtx.getHeaders().keySet()) {
            System.out.printf("header[%s] => %s\n", name, reqCtx.getHeaderString(name));
        }

        for (String name : reqCtx.getCookies().keySet()) {
            System.out.printf("cookie[%s] => %s\n", name, reqCtx.getHeaderString(name));
        }

        System.out.printf("**** END CLIENT REQUEST ****\n\n");
    }

}
