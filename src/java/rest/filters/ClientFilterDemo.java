/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.filters;

import java.io.IOException;
import javax.ws.rs.client.*;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1

 */
public class ClientFilterDemo implements ClientRequestFilter {

    public void filter(ClientResponseContext resCtx) throws IOException {
        System.out.printf("**** DEBUG CLIENT RESPONSE ****\n");
        System.out.printf("status: %s\n", resCtx.getStatus());
        System.out.printf("status info: %s\n", resCtx.getStatusInfo());
        System.out.printf("length: %s\n", resCtx.getLength());
        System.out.printf("mediaType: %s\n", resCtx.getMediaType());
        System.out.printf("date: %s\n", resCtx.getDate());
        System.out.printf("language: %s\n", resCtx.getLanguage());
        resCtx.getHeaders().keySet().forEach((name) -> {
            System.out.printf("header[%s] => %s\n", name, resCtx.getHeaderString(name));
        });
        resCtx.getCookies().keySet().forEach((name) -> {
            System.out.printf("cookie[%s] => %s\n", name, resCtx.getHeaderString(name));
        });
        System.out.printf("**** END CLIENT RESPONSE ****\n\n");
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
