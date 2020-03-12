package com.springboot.jdbc.firstoption;

public class AppUser {
	
	private Long id;
	private String username;
	private String password;
	private String useremail;
	private String userfirstname;
	private String userlastname;
	private String useraddress;

	public AppUser(Long id, String username, String password, String useremail, String userfirstname,
			String userlastname, String useraddress) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.useremail = useremail;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.useraddress = useraddress;
	}

	public AppUser() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((useraddress == null) ? 0 : useraddress.hashCode());
		result = prime * result + ((useremail == null) ? 0 : useremail.hashCode());
		result = prime * result + ((userfirstname == null) ? 0 : userfirstname.hashCode());
		result = prime * result + ((userlastname == null) ? 0 : userlastname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (useraddress == null) {
			if (other.useraddress != null)
				return false;
		} else if (!useraddress.equals(other.useraddress))
			return false;
		if (useremail == null) {
			if (other.useremail != null)
				return false;
		} else if (!useremail.equals(other.useremail))
			return false;
		if (userfirstname == null) {
			if (other.userfirstname != null)
				return false;
		} else if (!userfirstname.equals(other.userfirstname))
			return false;
		if (userlastname == null) {
			if (other.userlastname != null)
				return false;
		} else if (!userlastname.equals(other.userlastname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", useremail=" + useremail
				+ ", userfirstname=" + userfirstname + ", userlastname=" + userlastname + ", useraddress=" + useraddress
				+ "]";
	}

}
