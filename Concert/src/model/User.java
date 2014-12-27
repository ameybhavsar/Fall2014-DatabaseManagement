package model;
import java.io.*;

public class User {
	String uid;
	String uname;
	String dob;
	int score;
	String email;
	String upass;
	String udetails;
	String city;
	String lastaccess;
	String datejoined;
	String category;
	String subcategory;
	 public User()
	 {
		 score = 0 ;
	 lastaccess=null;
			 datejoined=null;		 
	 }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}
	public String getcategory()
	{
	return category;
}
	public String getsubcategory()
	{
	return subcategory;
}
	

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDob() {
		return dob;
	}
	public void setcategory(String category)
	{
	this.category=category;
}
	public void setsubcategory(String subcategory)
	{
	this.subcategory=subcategory;
}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUdetails() {
		return udetails;
	}

	public void setUdetails(String udetails) {
		this.udetails = udetails;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLastaccess() {
		return lastaccess;
	}

	public void setLastaccess(String lastaccess) {
		this.lastaccess = lastaccess;
	}

	public String getDatejoined() {
		return datejoined;
	}

	public void setDatejoined(String datejoined) {
		this.datejoined = datejoined;
	}

}
