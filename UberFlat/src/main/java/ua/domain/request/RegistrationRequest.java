package ua.domain.request;


import ua.entity.ComentForUser;

public class RegistrationRequest {
	
	private Integer id;

	private String fullName;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private String passwordRepeat;
	
	private boolean isOwner;
	
	private ComentForUser comentForUser;
	
	public RegistrationRequest() {
		super();
	}
	
	

	public RegistrationRequest(Integer id, String fullName, String phone, String email, String password,
			String passwordRepeat, boolean isOwner, ComentForUser comentForUser) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
		this.isOwner = isOwner;
		this.comentForUser = comentForUser;
	}



	public ComentForUser getComentForUser() {
		return comentForUser;
	}

	public void setComentForUser(ComentForUser comentForUser) {
		this.comentForUser = comentForUser;
	}

	public boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}