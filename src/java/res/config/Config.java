/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res.config;

import java.util.Set;
import java.util.HashSet;

import resources.BookImple;
import resources.HelloRest;
import resources.Hello;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
 */

@javax.ws.rs.ApplicationPath("rest")
public class Config extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resource = new HashSet<>();
        resource.add(BookImple.class);
        resource.add(HelloRest.class);
        resource.add(Hello.class);
        
        return resource;
    }

}
