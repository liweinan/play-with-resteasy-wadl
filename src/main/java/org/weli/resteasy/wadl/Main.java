package org.weli.resteasy.wadl;

import com.sun.net.httpserver.HttpServer;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.jboss.resteasy.wadl.ResteasyWadlDefaultResource;

import java.net.InetSocketAddress;

/**
 * Created by weli on 7/1/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8080), 10);
        HttpContextBuilder contextBuilder = new HttpContextBuilder();
        contextBuilder.getDeployment().getActualResourceClasses().add(FooResource.class);
        contextBuilder.getDeployment().getActualResourceClasses().add(ResteasyWadlDefaultResource.class);
        contextBuilder.bind(httpServer);
        ResteasyWadlDefaultResource.getServices().put("/",
                org.jboss.resteasy.wadl.ResteasyWadlGenerator.generateServiceRegistry(contextBuilder.getDeployment()));
        httpServer.start();
        System.out.println("Server started and listening on http://localhost:8080");
        System.out.println("WADL at http://localhost:8080/application.xml");
        System.out.println("Press CTRL-C to stop...");
        System.in.read();
    }
}
