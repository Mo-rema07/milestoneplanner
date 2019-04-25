package com.group_2.milestonePlanner.dao;

import com.group_2.milestonePlanner.model.Milestone;
import com.group_2.milestonePlanner.model.Project;
import com.group_2.milestonePlanner.model.User;
import com.group_2.milestonePlanner.repo.MilestoneList;
import com.group_2.milestonePlanner.repo.ProjectList;
import com.group_2.milestonePlanner.repo.UserList;

import java.sql.*;


public class DAO {
	private static MilestoneList milestones = new MilestoneList();



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
				"    pk_user_id INTEGER PRIMARY KEY,\n" +
				"    name VARCHAR(255),\n" +
				"    password VARCHAR(255),\n" +
				"    email VARCHAR(255)\n" +
				");\n" +
				"\n" +
				"CREATE TABLE IF NOT EXISTS project\n" +
				"(\n" +
				"    pk_project_id INTEGER AUTO_INCREMENT PRIMARY KEY,\n" +
				"    name VARCHAR(255),\n" +
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
			while (rs.next()) {
				list.put(new User(rs.getString("name"),rs.getString("password"),
						rs.getString("email"),rs.getInt("pk_user_id")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static void addUser (User user){
		String ADD_USER_QUERY = "INSERT INTO user (name, password, email) VALUES ( \'"+
				user.getUser_id()+"\',\'"+user.getUserName()+"\',\'"+
				user.getPasswordHash()+ "\',\'"+ user.getEmail()+"\')";

		try (PreparedStatement ps = conn.prepareStatement(ADD_USER_QUERY)) {
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static ProjectList loadProjects(){
		final String LIST_PROJECTS_QUERY = "SELECT * FROM project";
		ProjectList list = new ProjectList();
		try(PreparedStatement ps = conn.prepareStatement(LIST_PROJECTS_QUERY)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.put( new Project(rs.getString("name"),rs.getInt("fk_user_id")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static void addProject (Project project){
		String ADD_PROJECT_QUERY = "INSERT INTO project (name, fk_user_id) VALUES ( \'"+
				project.getName()+"\',\'"+project.getOwnerId()+"\')";
		try (PreparedStatement ps = conn.prepareStatement(ADD_PROJECT_QUERY)) {
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static MilestoneList loadMilestones(){
		final String LIST_MILESTONE_QUERY = "SELECT * FROM milestone";
		MilestoneList list = new MilestoneList();
		try(PreparedStatement ps = conn.prepareStatement(LIST_MILESTONE_QUERY)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				boolean isComplete = rs.getInt("isComplete") == 1;
				boolean hasStarted = rs.getInt("hasStarted") == 1;
				Date dueDate = rs.getDate("dueDate");
				Date completionDate = rs.getDate("completionDate");
				String name = rs.getString("name");
				int pk_project_id = rs.getInt("pk_project_id");
				list.put(new Milestone( isComplete, hasStarted, name, dueDate,
						completionDate, pk_project_id));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static void addMilestone (Milestone milestone){
		milestones.put(milestone);
	}


}
