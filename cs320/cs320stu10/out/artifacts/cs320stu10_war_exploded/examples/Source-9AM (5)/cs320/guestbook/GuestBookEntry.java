package cs320.guestbook;

public class GuestBookEntry {
	private static int numberOfEntries = 0;
	
	Integer id;
	String name;
	String message;
	
	public GuestBookEntry(String name, String message) {
		this.id = numberOfEntries++;
		this.name = name;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
