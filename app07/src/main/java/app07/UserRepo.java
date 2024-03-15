package app07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {
	private static UserRepo instance = new UserRepo();
	
	public static UserRepo getInstace() {
		return instance;
	}
	
	private UserRepo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public User findUser(User user) {
		String sql = "SELECT * FROM user WHERE id = ? AND password = ?";
		try (Connection conn
				= DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					String role = rs.getString("role");
					user.setRole(role);
					
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertUser(User user, Connection conn) {
		String sql = "INSERT INTO user (id, password) VALUES(?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, user.getId());
			stmt.setString(2, user.getPassword());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean existId(String id, Connection conn) {
		String sql = "SELECT count(*) FROM user WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return rs.getBoolean(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}





