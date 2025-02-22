package com.example.weatherApp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        // Create and configure Tomcat instance
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082); // Set the port to 8080

        // Create a context for the web application
        Context context = tomcat.addContext("", new File(".").getAbsolutePath());

        // Create and configure Spring application context
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebConfig.class); // Register the Spring MVC configuration class

        // Create DispatcherServlet and associate it with the application context
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        // Add DispatcherServlet to Tomcat context
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcher"); // Map DispatcherServlet to root path

        // Start Tomcat server
        tomcat.start();
        tomcat.getServer().await(); // Keep the server running
    }
}