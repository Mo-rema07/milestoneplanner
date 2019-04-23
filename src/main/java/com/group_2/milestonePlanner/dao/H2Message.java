package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class H2Message  implements AutoCloseable {
    @SuppressWarnings("unused")
    static final Logger LOG = LoggerFactory.getLogger(H2Message.class);

    public static final String MEMORY = "jdbc:h2:mem:shop";
    public static final String FILE = "jdbc:h2:~/shop";

    private Connection connection;

    static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
            Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
            return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
    }

    public H2Message() {
        this(MEMORY);
    }

    public H2Message(String db) {
        try {
            connection = getConnection(db);
            loadResource("/message.sql");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMessage(Message message) {
        final String ADD_MESSAGE_QUERY = "INSERT INTO message (text) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(ADD_MESSAGE_QUERY)) {
            ps.setString(1, message.displayMessage());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> findMessages() {
        final String LIST_MESSAGES_QUERY = "SELECT text  FROM message";
        List<Message> out = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(LIST_MESSAGES_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                out.add(new Message(rs.getString(1)));
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    private void loadResource(String name) {
        try {
            String cmd = new Scanner(getClass().getResource(name).openStream()).useDelimiter("\\Z").next();
            PreparedStatement ps = connection.prepareStatement(cmd);
            ps.execute();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
