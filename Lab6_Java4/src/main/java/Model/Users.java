package Model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class Users {
	@Id
	String id;
	String password;
	String fullname;
	String email;
	Boolean admin = false;
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	List<Favorites> Favorites;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public List<Favorites> getFavorites() {
		return Favorites;
	}
	public void setFavorites(List<Favorites> favorites) {
		this.Favorites = favorites;
	}
	
}
