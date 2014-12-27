package dao;
import java.sql.*;
public class DBConnection {
public static Connection createConnection() throws Exception
{
System.out.println("Conn.........");
Connection conn=null;
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/musicdb";
String uname="root";
String pwd="saisha";
conn=DriverManager.getConnection(url,uname,pwd);
return conn;
}
public static void closeConnection(Connection con)
{
if(con!=null)
{
try{
con.close();
}
catch(SQLException e){
e.printStackTrace();
}
}
}
}
	

