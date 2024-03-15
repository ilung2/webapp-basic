package app07;

import java.util.Objects;

public class User {
	private String id;
	private String password;
	private String role;
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public User(String id, String password, String role) {
		super();
		this.id = id;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password);
	}
}
