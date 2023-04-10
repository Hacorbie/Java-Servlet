package Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Favorites", uniqueConstraints={
@UniqueConstraint(columnNames = {"VidId" , "UserId"})
})

public class Favorites {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long Id;
	@ManyToOne @JoinColumn(name = "UserId")
	Users user;
	@ManyToOne @JoinColumn(name = "VidId")
	Videos video;
	@Temporal(TemporalType.DATE)
	Date LikeDate = new Date();
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public Date getLikeDate() {
		return LikeDate;
	}
	public void setLikeDate(Date likeDate) {
		LikeDate = likeDate;
	}
	
	

	
}
