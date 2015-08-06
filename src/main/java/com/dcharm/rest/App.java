package com.dcharm.rest;

import com.dcharm.rest.config.DevConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by wangqiang on 2015/8/6.
 */
public class App {
    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new QueuedThreadPool(50, 10);
        Server server = new Server(threadPool);
        ServerConnector http = new ServerConnector(server);
        http.setHost(null);
        http.setPort(8080);
        http.setIdleTimeout(1000);
        server.addConnector(http);

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation("com.dcharm.rest.config");
        context.register(DevConfiguration.class);
        context.getEnvironment().setDefaultProfiles("dev");

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath("/");
        ServletHolder servletHolder = new ServletHolder(new DispatcherServlet(context));
        contextHandler.addServlet(servletHolder, "/*");
//        contextHandler.addEventListener(new ContextLoaderListener(context));
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }

}
