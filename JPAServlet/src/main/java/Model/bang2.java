package Model;

import javax.persistence.*;

@Entity
@Table(name="Bang2")
public class bang2{

   @Id
   @Column(name="Ten")
   private String Ten;

   @Column(name="Luong")
   private int Luong;


public String getTen() {
	return Ten;
}

public void setTen(String ten) {
	Ten = ten;
}

public int getLuong() {
	return Luong;
}

public void setLuong(int luong) {
	Luong = luong;
}

public bang2(String ten, int luong) {
	super();
	Ten = ten;
	Luong = luong;
}

public bang2() {
	super();
}

   
}
