package model;

public class Artist {
	String artist_id;
	String apass;
	String artist_name;
	String category;
	String subcategory;
	String profile;
	String artist_detailslink;
	String date_joined;
	public String getArtist_id() {
		return artist_id;
	}
	public String getcategory() {
		return category;
	}
	public String getsubcategory() {
		return subcategory;
	}
	
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public void setcategory(String category) {
		this.category = category;
	}
	public void setsubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	public String getArtist_detailslink() {
		return artist_detailslink;
	}
	public void setArtist_detailslink(String artist_detailslink) {
		this.artist_detailslink = artist_detailslink;
	}
	public String getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(String date_joined) {
		this.date_joined = date_joined;
	}
	
	
	
}
