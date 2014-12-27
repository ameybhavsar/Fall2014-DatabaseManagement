package controller;
import dao.DBConnection;

import java.sql.*;
import java.util.*;
import java.io.*;

import dao.Musicdao;
import model.User;
import model.Artist;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

/**
 * Servlet implementation class MusicController
 */
@WebServlet("/MusicControl")
@MultipartConfig(maxFileSize=16177215)
public class MusicControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		try{
			String redirect = request.getParameter("redirect");
			String redirect1 = request.getParameter("redirect1");
			String aredirect = request.getParameter("aredirect");
			String concertid = request.getParameter("concertid");
			String reviewconcertid = request.getParameter("reviewconcertid");
			String concertfind = request.getParameter("concertfind");
			System.out.println("Redirect"+redirect);
			System.out.println(aredirect);
			
		String action = request.getParameter("action");
		System.out.println(action);
		System.out.println("this is printed"+action);
		if(aredirect!=null)
		{
			System.out.println("Inside this control");
			HttpSession session = request.getSession();
			session.setAttribute("aredirection", aredirect);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/fartistprofile.jsp");
			
		}
		if(concertfind!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("fconcert", concertfind);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/attendconcert.jsp");
			
		}
		if(reviewconcertid!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("reviewconcertid", reviewconcertid);
			response.sendRedirect(request.getContextPath()
					+"/bootstrap-star-rating-master/examples/reviewconcert.jsp");
			
		}
		
		if(concertid!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("concertrev", concertid);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/concertreview.jsp");
			
		}
		if(action.equalsIgnoreCase("logout"))
		{HttpSession session = request.getSession();
		session.removeAttribute("User");
		session.invalidate();
			request.getSession().invalidate();
			response.setHeader("Pragma","no-cache");  
			response.setHeader("Cache-Control","no-store");  
			response.setHeader("Expires","0");  
			response.setDateHeader("Expires",-1);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/Login.jsp");
			
		}
		if(redirect1!=null)
		{

			HttpSession session = request.getSession();
			session.setAttribute("redirection1", redirect1);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/fuserprofile.jsp");
		}
		if(redirect!=null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("redirection", redirect);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/userprofile.jsp");
			
		}
		if(action.equalsIgnoreCase("addreviewconcert"))
		{
			try{
				String commentid = request.getParameter("concertid");
				 String uid = request.getParameter("uid");
				 String comment = request.getParameter("comment");
				 
				 
				 
			}
				
		
		catch(Exception e)
		{
			
		}
		}
		if(action.equalsIgnoreCase("usignup"))
		{try{
			System.out.println("inside Signup Page");
			User user=new User();
			String uid = request.getParameter("uid");
			String uname = request.getParameter("username");;
			String year= request.getParameter("BirthYear");
			String month = request.getParameter("BirthMonth"); ; 
			String day = request.getParameter("BirthDay");
			String email = request.getParameter("BirthYear");
			String upass = request.getParameter("password");
			String udetails = request.getParameter("details");
			String city = request.getParameter("city");
			String dob = year+"-" +month+"-"+day;
			System.out.println(uid+" "+uname+" "+email+" "+upass+" "+udetails+" "+city+" "+dob);
			user.setUid(uid);
			user.setUname(uname);
			user.setEmail(email);
			user.setUpass(upass);
			user.setUdetails(udetails);
			user.setCity(city);
			user.setDob(dob);
			
			try
			{
			String ImageFile="";
			String itemName = "";
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			System.out.println(isMultipart);
			if (!isMultipart)
			{
				System.out.println("NOTHING NOTHIN NOTHING");
			}
			else
			{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;	
			items = upload.parseRequest(request);			 
			Iterator itr = items.iterator();
			while (itr.hasNext())
			{
			FileItem item = (FileItem) itr.next();
			if (item.isFormField())
			{
			String name = item.getFieldName();
			String value = item.getString();
			if(name.equals("ImageFile"))
			{
			ImageFile=value;
			}
			}
			else
			{
			try
			{
			itemName = item.getName();
			File savedFile = new File("E:/"+itemName);

			System.out.println("/Users/Raghav/Documents/workspace/"+itemName);
			item.write(savedFile);
			}
			catch (Exception e)
			{
			System.out.println("Error"+e.getMessage());
			}
			}
			}
			try
			{
			//st.executeUpdate("insert into test(image) values ('"+itemName+"')");
			 
			}
			catch(Exception el)
			{
			System.out.println("Inserting error"+el.getMessage());
			}
			}
			}
			catch (Exception e){
			System.out.println(e.getMessage());
			}
			
			
			Musicdao dao=new Musicdao();
			//dao.usersignup(user);
			response.sendRedirect(request.getContextPath()
				+ "/Music/Pages/User/Login.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		if(action.equalsIgnoreCase("addaconcert"))
		{
			try{
				System.out.println("Inside the addconcert condition");
				String uid = request.getParameter("uid");
				System.out.println(uid);
				Connection connect  = DBConnection.createConnection();
				PreparedStatement preparedStatement = connect.prepareStatement("select * from user where user_id = ?");
				preparedStatement.setString(1, uid);
				ResultSet rs=preparedStatement.executeQuery();
				rs.next();
				if(rs.getInt("trustscore")<5)
				{
					System.out.println("You cannot post a new Concert");response.sendRedirect(request.getContextPath()
							+"/Music/Pages/User/successfollow.jsp");
					
					
				}
				else
				{
					System.out.println("You can post");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		if(action.equalsIgnoreCase("ufollowu"))
		{try{
			String uid = request.getParameter("getuid");
			String fuid = request.getParameter("getfuid");
			System.out.println(uid +"follows "+fuid);
			System.out.println("Inside follow condition");
			Connection connect  = DBConnection.createConnection();
			PreparedStatement preparedStatement = connect.prepareStatement("insert into user_follows values (?,?,now());");
			preparedStatement.setString(1, fuid);
			preparedStatement.setString(2, uid);
			int x = preparedStatement.executeUpdate();
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/userfollow.jsp");
		}
		catch(Exception e)
		{response.sendRedirect(request.getContextPath()
				+"/Music/Pages/User/userfollow.jsp");
			System.out.println(e);
			
		}
		}
		if(action.equalsIgnoreCase("attendc"))
		{
			try{
				String cid = request.getParameter("getcuid");
						String uid = request.getParameter("getuid");
						 Musicdao dao = new Musicdao();
						 dao.concertattend(cid, uid);
						 response.sendRedirect(request.getContextPath()
									+"/Music/Pages/User/yourplan.jsp");
						
				
			}
			catch(Exception e)
			{
				
			}
			
		}
		if(action.equalsIgnoreCase("searchconcert")){
			try{
				String str = request.getParameter("concertsearch");
				HttpSession session1 = request.getSession();
				session1.setAttribute("concertsearch", str);
				
				response.sendRedirect(request.getContextPath()
						+"/Music/Pages/User/concertresult.jsp");
				
				
			}
			catch(Exception e)
			{
				
			}
			
		}
		
		if(action.equalsIgnoreCase("artistsignup"))
		{
			System.out.println("inside condition");
		response.sendRedirect(request.getContextPath()
				+ "/Music/jsp/approval.jsp");

		}
		if(action.equalsIgnoreCase("addcomment"))
		{
			String commentid = request.getParameter("concertid");
			 String uid = request.getParameter("uid");
			 String comment = request.getParameter("comment");
			 Musicdao dao = new Musicdao();
			 dao.insertcomment(concertid,uid,comment);
			 response.sendRedirect(request.getContextPath()
						+ "/Music/Pages/User/concertreview.jsp");
			 
		}
		if(action.equalsIgnoreCase("addReview"))
		{
			String uid =  request.getParameter("uid");
			String concertreviewid = request.getParameter("concertreviewid");
			Connection con = DBConnection.createConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_attendsorplans where user_id = ? and concert_id = ?;");
			ps.setString(1, uid);
			ps.setString(2, concertreviewid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("concertaddreview", concertreviewid);
				response.sendRedirect(request.getContextPath()
						+"/bootstrap-star-rating-master/examples/concertreviewadd.jsp");
				
			}
			else
			{
				response.sendRedirect(request.getContextPath()
						+ "/Music/Pages/User/noreview.jsp");	
			}
		}
		if(action.equalsIgnoreCase("searchuser"))
		{
		try{
			String str=request.getParameter("usersearch");
			System.out.println("inside music search controller");
			
			Musicdao dao=new Musicdao();
			ArrayList<User> userlist = dao.search(str);
			
			HttpSession session = request.getSession();
			session.setAttribute("ulist", userlist);
			response.sendRedirect(request.getContextPath()
					+"/Music/Pages/User/userresult.jsp");
		}
		catch(Exception e)
		{
		System.out.println(e);	
		}
		}
		if(action.equalsIgnoreCase("artistfollows"))
		{
			try{
				String artistid = request.getParameter("artistfan");
				String uid = request.getParameter("uid");
				Musicdao dao = new Musicdao();
				dao.artistfan(artistid,uid);
				response.sendRedirect(request.getContextPath()
				+"/Music/Pages/User/findartist.jsp");		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		if(action.equalsIgnoreCase("searchartist"))
		{
			try{
				String str=request.getParameter("artistsearch");
				System.out.println("Inside control"+str);
				Musicdao dao=new Musicdao();
				ArrayList<Artist> artistlist = dao.searchartist(str);
				HttpSession session = request.getSession();
				session.setAttribute("alist", artistlist);
				response.sendRedirect(request.getContextPath()
						+"/Music/Pages/User/artistresult.jsp");
			
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
	
		if(action.equalsIgnoreCase("userfollows"))
		{
			try{
				System.out.println("inside controller");
				String selection = request.getParameter("selectfollow");
				String userid = request.getParameter("uid");
				Musicdao dao = new Musicdao();
				dao.Userfollow(selection,userid);
				response.sendRedirect(request.getContextPath()+ "/Music/Pages/User/successfollow.jsp");
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(action.equalsIgnoreCase("signup"))
		{
			System.out.println("inside Signup Page");
			User user=new User();
			String uid = request.getParameter("uid");
			String uname = request.getParameter("username");;
			String year= request.getParameter("BirthYear");
			String month = request.getParameter("BirthMonth"); ; 
			String day = request.getParameter("BirthDay");
			String email = request.getParameter("BirthYear");
			String upass = request.getParameter("password");
			String udetails = request.getParameter("details");
			String city = request.getParameter("city");
			String dob = year+"-" +month+"-"+day;
			System.out.println(uid+" "+uname+" "+email+" "+upass+" "+udetails+" "+city+" "+dob);
			user.setUid(uid);
			user.setUname(uname);
			user.setEmail(email);
			user.setUpass(upass);
			user.setUdetails(udetails);
			user.setCity(city);
			user.setDob(dob);
			Musicdao dao=new Musicdao();
			dao.usersignup(user);
			response.sendRedirect(request.getContextPath()
				+ "/Music/jsp/approval.jsp");
}	
		if(action.equalsIgnoreCase("folunfol"))
				{
String uid = request.getParameter("getuid");
String fuid = request.getParameter("getfuid");
String todo = request.getParameter("followunfollow");

if(todo.equalsIgnoreCase("FOLLOW"))
{System.out.println(uid +"follows "+fuid);
	System.out.println("Inside follow condition");
	Connection connect  = DBConnection.createConnection();
	PreparedStatement preparedStatement = connect.prepareStatement("insert into user_follows values (?,?,now());");
	preparedStatement.setString(1, fuid);
	preparedStatement.setString(2, uid);
	int x = preparedStatement.executeUpdate();
	
	
}
if(todo.equalsIgnoreCase("UNFOLLOW"))
{
	Connection connect  = DBConnection.createConnection();
	System.out.println(fuid +","+uid);
	PreparedStatement preparedStatement = connect.prepareStatement("delete from user_follows where user_id = ? and follow_id=?;");
	preparedStatement.setString(1, fuid);
	preparedStatement.setString(2, uid);
	int x = preparedStatement.executeUpdate();
	System.out.println(x+"Inside unfollow condition");
}
response.sendRedirect(request.getContextPath()+ "/Music/Pages/User/userfollow.jsp");
			
				}
		if(action.equalsIgnoreCase("unfollowartist"))
				{
			Connection connect  = DBConnection.createConnection();
				
				String uid = request.getParameter("getuid");
				String auid = request.getParameter("getauid");
				PreparedStatement preparedStatement = connect.prepareStatement("delete from fan_of where user_id = ? and artist_id=?;");
				preparedStatement.setString(2, auid);
				preparedStatement.setString(1, uid);
				int x = preparedStatement.executeUpdate();
				System.out.println("Inside unfollow condition");
				response.sendRedirect(request.getContextPath()+ "/Music/Pages/User/findartist.jsp");
			
			
				}
		
		if(action.equalsIgnoreCase("login"))
		{
			String uid=request.getParameter("login");
			System.out.println(uid);
			Musicdao dao = new Musicdao();
			User user=new User();
			user=dao.getuser(uid);
			Connection connect  = DBConnection.createConnection();
			System.out.println(uid+" "+user.getCity()+" "+user.getEmail());
			HttpSession session = request.getSession();
			session.setAttribute("userdetails",user);
			response.sendRedirect(request.getContextPath()+ "/Music/Pages/User/userhome.jsp");
		}

		}
		catch(Exception e)
		{
			System.out.println(e);
			}
	}
		}


