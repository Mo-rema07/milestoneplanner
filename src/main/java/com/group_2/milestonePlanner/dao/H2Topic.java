package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class H2Topic  implements AutoCloseable {
	@SuppressWarnings("unused")
	static final Logger LOG = LoggerFactory.getLogger(H2Topic.class);

	public static final String MEMORY = "jdbc:h2:mem:shop";
	public static final String FILE = "jdbc:h2:~/shop";

	private Connection connection;

	static Connection getConnection(String db) throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");  // ensure the driver class is loaded when the DriverManager looks for an installed class. Idiom.
		return DriverManager.getConnection(db, "sa", "");  // default password, ok for embedded.
	}

	public H2Topic() {
		this(MEMORY);
	}

	public H2Topic(String db) {
		try {
			connection = getConnection(db);
			loadResource("/topic.sql");
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

	public void addTopic(Topic topic) {
		final String ADD_TOPIC_QUERY = "INSERT INTO topic (title) VALUES (?)";
		try (PreparedStatement ps = connection.prepareStatement(ADD_TOPIC_QUERY)) {
			ps.setString(1, topic.getTitle());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Topic> findTopics() {
		final String LIST_TOPICS_QUERY = "SELECT title  FROM topic";
		List<Topic> out = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement(LIST_TOPICS_QUERY)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.add(new Topic(rs.getString(1)));
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
