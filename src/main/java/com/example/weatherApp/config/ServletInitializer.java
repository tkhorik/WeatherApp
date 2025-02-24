package com.example.weatherApp.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletInitializer extends AbstractDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }

    @Override
    protected String getServletName() {
        return "appDispatcher";
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(jakarta.servlet.ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
    }

    @Override
    protected org.springframework.web.context.WebApplicationContext createServletApplicationContext() {
        org.springframework.web.context.support.AnnotationConfigWebApplicationContext context =
                new org.springframework.web.context.support.AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        return context;
    }

    @Override
    protected org.springframework.web.context.WebApplicationContext createRootApplicationContext() {
        org.springframework.web.context.support.AnnotationConfigWebApplicationContext context =
                new org.springframework.web.context.support.AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfig.class);
        return context;
    }
}