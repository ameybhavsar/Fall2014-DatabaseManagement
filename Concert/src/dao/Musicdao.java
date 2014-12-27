package dao;
import java.util.*;

import model.User;
import model.Artist;
import controller.MusicControl;

import java.sql.*;
/* CONCERT _ TEST */
public class Musicdao {
	Connection connect= null;
    PreparedStatement preparedStatement=null;
    CallableStatement cs=null;
    ResultSet rs=null;
    public void usersignup(User user)
    {
    	try{	
    	connect  = DBConnection.createConnection();
    	CallableStatement cs=connect.prepareCall("{call usersignup(?,?,?,?,?,?,?,?,?)}");
    	cs.setString(1,user.getUid());
    	cs.setString(2,user.getUname());
    	cs.setString(3,user.getDob());
    	cs.setInt(4, user.getScore());
    	cs.setString(5,user.getEmail());
    	cs.setString(6,user.getUpass() );
    	cs.setString(7,user.getUdetails());
    	cs.setString(8,user.getCity());
    	cs.setString(9,user.getLastaccess());
    	int x=cs.executeUpdate();
		cs.close();
		connect.close();
		}
    catch(Exception e)
    {
    	System.out.println("Inside User Sign Up" + e);
    }
    }
    public void Userfollow(String selection,String userid)
    {
    	try{
    		System.out.println(selection +" "+userid);
    		Connection connect  = DBConnection.createConnection();
    		preparedStatement = connect.prepareStatement("insert into user_follows values (?,?,now());");
    		preparedStatement.setString(1, selection);
    		preparedStatement.setString(2, userid);
    		int x = preparedStatement.executeUpdate();
    		System.out.println(x);
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    }
    public ArrayList<Artist> searchartist(String str)
    {
    	ArrayList<Artist> alist = new ArrayList();
    	try{
    		connect  = DBConnection.createConnection();
    		Statement st = connect.createStatement();
    		String query = "select distinct artist_id,artist_name,date_joined,category,subcategory,profile,artist_detailslink from artist natural join artist_plays where category like '%"+str+"%' or artist_name like '%"+str+"%' or subcategory like '%"+str+"';";
    		rs=st.executeQuery(query);
    		while(rs.next())
    		{
    			Artist artist = new Artist();
    			artist.setArtist_id(rs.getString("artist_id"));
    			artist.setArtist_detailslink(rs.getString("artist_detailslink"));
    			artist.setArtist_name(rs.getString("artist_name"));
    			artist.setcategory(rs.getString("category"));
    			artist.setDate_joined(rs.getString("date_joined"));
    			artist.setProfile(rs.getString("profile"));
    			artist.setsubcategory(rs.getString("subcategory"));
    			alist.add(artist);
    		}
    		return alist;
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	return null;
    	
    }
    public void insertcomment(String concertid,String uid,String comment)
    {try{
    	Connection connect  = DBConnection.createConnection();
    	Connection connect1  = DBConnection.createConnection();
		preparedStatement  = connect.prepareStatement("insert into user_comments values(?,?,?,now());");
		preparedStatement.setString(1, uid);
		preparedStatement.setString(2, concertid);
		preparedStatement.setString(3, comment);
		PreparedStatement ps = connect1.prepareStatement("update user set trustscore = trustscore+1 where user_id=?");
		ps.setString(1,uid );
		ps.executeUpdate();
		int x = preparedStatement.executeUpdate();
		System.out.println(x);
    }
    catch(Exception e)
    {
    	
    }
    }
    public void artistfan(String artistid,String uid)
    {
    	try{
    		Connection connect  = DBConnection.createConnection();
    		preparedStatement = connect.prepareStatement("insert into fan_of values (?,?,now());");
    		preparedStatement.setString(1, uid);
    		preparedStatement.setString(2, artistid);
    		int x = preparedStatement.executeUpdate();
    		System.out.println(x);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
    }
    public void concertattend(String cid , String uid)
    {
    try{
    	Connection connect  = DBConnection.createConnection();
		preparedStatement = connect.prepareStatement("insert into user_attendsorplans values (?,?,,'',now(),'');");
		preparedStatement.setString(1, uid);
		preparedStatement.setString(2, cid);
		int x = preparedStatement.executeUpdate();
		System.out.println(x);
    	
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    	
    }
    public ArrayList<User> search(String str)
    {
    	ArrayList<User> ulist = new ArrayList();
    	try{
    	connect  = DBConnection.createConnection(); 
         System.out.println(str+"Inside search function");
         Statement st = connect.createStatement();
         String query = "select distinct user_id,city,category,subcategory,user_name,profile_details from user natural join user_likes where category like '%"+str+"%' or user_name like '%"+str+"%' or subcategory like '%"+str+"';";
        // preparedStatement = connect.prepareStatement("select * from user natural join user_likes where category like '%'?'%' or user_name like '%'?'%' or subcategory like '%'?'%';");
         //preparedStatement.setString(1, str);
         //preparedStatement.setString(2, str);
         //preparedStatement.setString(3, str);
         rs=st.executeQuery(query);
         while(rs.next())
         {
        	 System.out.println("inside the loop");
        	 User user=new User();
user.setCity(rs.getString("city"));
user.setcategory(rs.getString("category"));
user.setsubcategory(rs.getString("subcategory"));
user.setUid(rs.getString("user_id"));
user.setUname(rs.getString("user_name"));
user.setUdetails(rs.getString("profile_details"));
System.out.println(user.getCity()+" "+user.getUid());
ulist.add(user);
 }
       return ulist;
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    	return ulist;	
    }
    public  User getuser(String uid)
    {
    	try{
     connect  = DBConnection.createConnection();
    // ArrayList<User> ulist = new ArrayList();
     User user=new User();
     Connection connect1 = DBConnection.createConnection();
     PreparedStatement ps = connect1.prepareStatement("update user set last_access_time = now() where user_id=? ");
     ps.setString(1, uid);
     ps.executeUpdate();
     preparedStatement = connect.prepareStatement("select * from user where user_id =?");
     preparedStatement.setString(1, uid);
     rs=preparedStatement.executeQuery();
     while(rs.next())
     {
    	 
    	 user.setUid(rs.getString(1));
    	 user.setDatejoined(rs.getString(10));
    	 user.setCity(rs.getString(8));
    	 user.setDob(rs.getString(3));
    	 user.setLastaccess(rs.getString(9));
    	 user.setScore(rs.getInt(4));
    	 user.setUname(rs.getString(2));
    	 user.setUpass(rs.getString(6));    	
    	 user.setLastaccess(rs.getString(9));
    	 user.setUdetails(rs.getString(7));
    	 //ulist.add(user);
     }
   	return user;
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
		return null;
    }
	

}
