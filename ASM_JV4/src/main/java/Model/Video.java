package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "Video")
public class Video {
	@Id
	String Id;
	String Title;
	String Poster;
	String Description;
	
	Boolean Active = true;
	Integer Views = 0;
	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	List<Favorite> Favorite;
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
	public Boolean getActive() {
		return Active;
	}
	public void setActive(Boolean active) {
		Active = active;
	}
	public Integer getViews() {
		return Views;
	}
	public void setViews(Integer views) {
		Views = views;
	}
	public List<Favorite> getFavorites() {
		return Favorite;
	}
	public void setFavorites(List<Favorite> favorite) {
		Favorite = favorite;
	}
	public Video() {
		super();
	}
	
}
