package app.model;

public class LoginModel {
	private int id_login;
	private String users;
	private String passwords;
	private String access;
	public int getId_login() {
		return id_login;
	}
	public void setId_login(int id_login) {
		this.id_login = id_login;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	
	public LoginModel(){}
	public LoginModel(int id_login, String users, String passwords, String access){
		this.id_login = id_login;
		this.users = users;
		this.passwords = passwords;
		this.access = access;
	}
	
}
