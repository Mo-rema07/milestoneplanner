
package main.java.com.morema.servlet;

import com.morema.messageBoard.db.H2Message;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Runner {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    private static final int PORT = 9000;

    private final H2Message h2Message;

    public Runner() {
        h2Message = new H2Message();
    }

    public void start() throws Exception {
        Server server = new Server(PORT);

        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.setInitParameter("org.eclipse.jetty.servlet.Default." + "resourceBase", "src/main/resources/webapp");

        handler.addServlet(new ServletHolder(new MessageServlet(h2Message)), "/index");
        handler.addServlet(new ServletHolder(new MessageServlet(h2Message)), "/");
        handler.addServlet(new ServletHolder(new MessageServlet(h2Message)), "/add"); // we post to here

//        DefaultServlet ds = new DefaultServlet();
//        handler.addServlet(new ServletHolder(ds), "/");

        server.start();
        LOG.info("Server started, will run until terminated");
        System.out.println("Server started, will run until terminated");
        server.join();
    }

    public static void main(String[] args) {
        try {
            LOG.info("starting message board");
            Runner runner = new Runner();
            runner.start();
        } catch (Exception e) {
            LOG.error("Unexpected error running message board: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
