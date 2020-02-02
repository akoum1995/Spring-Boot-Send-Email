package email.example.email.entities;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String email;
	
	public User() {
		
	}
	public User(int id, String email) {
		this.id = id;
		this.email = email;
	}
	public User(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
