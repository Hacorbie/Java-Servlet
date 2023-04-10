package Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Favorite", uniqueConstraints={
@UniqueConstraint(columnNames = {"VidId" , "UserId"})
})
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	@ManyToOne @JoinColumn(name = "UserId")
	User user;
	@ManyToOne @JoinColumn(name = "VidId")
	Video video;
	@Temporal(TemporalType.DATE)
	Date LikeDate = new Date();
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Date getLikeDate() {
		return LikeDate;
	}
	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}
	public Favorite() {
		super();
	}
	
}
