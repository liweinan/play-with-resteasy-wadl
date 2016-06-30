package org.weli.resteasy.wadl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by weli on 7/1/16.
 */
@Path("/")
public class FooResource {
    @GET
    @Path("/hello")
    public String hello(String name) {
        return "Hello, " + name;
    }
}
