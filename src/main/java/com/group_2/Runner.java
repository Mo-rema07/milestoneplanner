
package com.group_2;


import com.group_2.milestonePlanner.dao.DAO;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.File;


public class Runner {
    private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";
    static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws ServletException {

        //Create db tables if they do not exist
        DAO.createTables();

        Tomcat tomcat = new Tomcat();
        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) webPort = "8080";

        tomcat.setPort(Integer.valueOf(webPort));
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(WEBAPP_DIR_LOCATION).getAbsolutePath());
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            LOG.error(e.getMessage());
        }
        tomcat.getServer().await();
    }
}
