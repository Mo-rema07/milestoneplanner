
package com.group_2.servlet;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Runner {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static final int PORT = 9000;


    public Runner() {
    }

    public void start() throws Exception {
        Server server = new Server(PORT);

        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setInitParameter("org.eclipse.jetty.servlet.Default.resourceBase", "src/main/webapp");
//        handler.setResourceBase("src/main/webapp");
//        System.out.println(handler.getResourceBase());
        handler.addServlet(new ServletHolder(new LoginServlet()), "/login");
        handler.addServlet(new ServletHolder(new Welcome()), "/Welcome");

        DefaultServlet ds = new DefaultServlet();
        handler.addServlet(new ServletHolder(ds), "/");

        server.start();
        LOG.info("Server started, will run until terminated");
        server.join();
    }

    public static void main(String[] args) {
        try {
            LOG.info("starting Milestone Planner");
            Runner runner = new Runner();
            runner.start();
        } catch (Exception e) {
            LOG.error("Unexpected error running Milestone Planner: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
