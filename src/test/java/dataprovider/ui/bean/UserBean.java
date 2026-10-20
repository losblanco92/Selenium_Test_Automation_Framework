package dataprovider.ui.bean;

import com.opencsv.bean.CsvBindByName;

public class UserBean {

	@CsvBindByName(column = "email")
	
	private String email;

	@CsvBindByName(column = "password")
	private String password;

	public UserBean() {

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

	@Override
	public String toString() {
		return "loginDatabean [email=" + email + ", password=" + password + "]";
	}

}
