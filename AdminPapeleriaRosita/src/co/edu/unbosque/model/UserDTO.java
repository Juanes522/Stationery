package co.edu.unbosque.model;

public class UserDTO {
	
	private String name;
	private String password;
	private String answer;
	private String question;
	private boolean isAdministrator;
	
	public UserDTO() {}

	public UserDTO(String name, String password, String question, String answer, boolean isAdministrator) {
		super();
		this.name = name;
		this.password = password;
		this.answer = answer;
		this.question = question;
		this.isAdministrator = isAdministrator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdministrator() {
		return isAdministrator;
	}

	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", password=" + password + ", answer=" + answer + ", question=" + question
				+ ", isAdministrator=" + isAdministrator + "]";
	}
	
	
	
}
