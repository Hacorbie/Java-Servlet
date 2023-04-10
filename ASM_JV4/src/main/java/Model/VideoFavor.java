package Model;




import java.util.Date;

import javax.persistence.*;

@Entity
public class VideoFavor {
	@Id
	String videott;
	Long fc;
	Date lc;
	Date oc;
	
	
	public String getVideott() {
		return videott;
	}


	public void setVideott(String videott) {
		this.videott = videott;
	}


	public Long getFc() {
		return fc;
	}


	public void setFc(Long fc) {
		this.fc = fc;
	}


	public Date getLc() {
		return lc;
	}


	public void setLc(Date lc) {
		this.lc = lc;
	}


	public Date getOc() {
		return oc;
	}


	public void setOc(Date oc) {
		this.oc = oc;
	}


	public VideoFavor(String videott, Long fc, Date lc, Date oc) {
		this.videott = videott;
		this.fc = fc;
		this.lc = lc;
		this.oc = oc;
	}

	
	
}
