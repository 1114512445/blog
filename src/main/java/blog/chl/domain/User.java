package blog.chl.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	private String id;
	private String username;
	private String password;
	private String joinDate;
	private String spare;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password 
				 + ", joinDate=" + joinDate + ", spare=" + spare + "]";
	}
	
}
