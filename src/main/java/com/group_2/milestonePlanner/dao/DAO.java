package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.model.Project;
import com.group_2.milestonePlanner.model.User;
import com.group_2.milestonePlanner.repo.MilestoneList;
import com.group_2.milestonePlanner.repo.ProjectList;
import com.group_2.milestonePlanner.repo.UserList;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class DAO {

	private static String db_url = "jdbc:sqlite:planner.db";
	private static Connection conn;

	static {
		try {
			conn = DriverManager.getConnection(db_url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTables(){
		String sql =  "CREATE TABLE IF NOT EXISTS user\n" +
				"(\n" +
				"    pk_user_id INTEGER AUTO_INCREMENT PRIMARY KEY,\n" +
				"    name VARCHAR(255),\n" +
				"    password VARCHAR(255),\n" +
				"    email VARCHAR(255)\n" +
				");\n" +
				"\n" +
				"CREATE TABLE IF NOT EXISTS project\n" +
				"(\n" +
				"    pk_project_id INTEGER AUTO_INCREMENT PRIMARY KEY,\n" +
				"    name VARCHAR(255),\n" +
				"    owner VARCHAR(255),\n" +
				"    email VARCHAR(255),\n" +
				"    fk_user_id INTEGER,\n" +
				"    FOREIGN KEY(fk_user_id) REFERENCES user(pk_user_id)\n" +
				"\n" +
				");\n" +
				"\n" +
				"CREATE TABLE IF NOT EXISTS milestone\n" +
				"(\n" +
				"    pk_milestone_id INTEGER AUTO_INCREMENT PRIMARY KEY,\n" +
				"    isComplete INTEGER,\n" +
				"    hasStarted INTEGER,\n" +
				"    dueDate text,\n" +
				"    completionDate text,\n" +
				"    name VARCHAR(255),\n" +
				"    fk_project_id   INTEGER,\n" +
				"    FOREIGN KEY(fk_project_id) REFERENCES user(pk_project_id)\n" +
				");";

		try {
			conn = DriverManager.getConnection(db_url);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public static UserList loadUsers(){
		final String LIST_USERS_QUERY = "SELECT * FROM user";
		UserList list = new UserList();
		try (PreparedStatement ps = conn.prepareStatement(LIST_USERS_QUERY)) {
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.getString("name"));
			while (rs.next()) {
				list.put(new User(rs.getString("name"),rs.getString("password"),rs.getString("email")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static void addUser (User user){
		String ADD_USER_QUERY = "INSERT INTO user (name, password, email) VALUES ( \'"+
				user.getUserName()+"\',\'"+user.getPasswordHash()+"\',\'"+
				user.getEmail()+"\')";

		try (PreparedStatement ps = conn.prepareStatement(ADD_USER_QUERY)) {
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static ProjectList loadProjects(){
		return new ProjectList();
	}

	public static void addProject (Project project){

	}

	public static MilestoneList loadMilestones(){
		return new MilestoneList();
	}

	public static void addMilestone (Milestone milestone){

	}

	private void loadResource(String name) {
		try {
			String cmd = new Scanner(getClass().getResource(name).openStream()).useDelimiter("\\Z").next();
			PreparedStatement ps = conn.prepareStatement(cmd);
			ps.execute();
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
}
