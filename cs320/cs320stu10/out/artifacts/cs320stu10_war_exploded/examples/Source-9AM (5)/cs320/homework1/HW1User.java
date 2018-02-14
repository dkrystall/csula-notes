package cs320.homework1;

public class HW1User {

	private String name;
	private String email;
	private String password;
	
	public HW1User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
}
