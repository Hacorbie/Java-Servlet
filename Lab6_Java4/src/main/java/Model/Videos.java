package Model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Videos")
public class Videos {
	@Id
	String Id;
	String Title;
	String Poster;
	String Description;
	
	Boolean Active = true;
	Integer Views = 0;
	@OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
	List<Favorites> Favorites;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getViews() {
		return Views;
	}
	public void setViews(Integer views) {
		Views = views;
	}
	public Boolean getActive() {
		return Active;
	}
	public void setActive(Boolean active) {
		Active = active;
	}
	public List<Favorites> getFavorites() {
		return Favorites;
	}
	public void setFavorites(List<Favorites> favorites) {
		this.Favorites = favorites;
	}


}
