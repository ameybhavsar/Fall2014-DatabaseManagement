<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="dao.Musicdao"%>
<%@page import="model.User"%>
<%@page import="java.sql.*"%>
<%@page import="dao.DBConnection"%>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="../css/star-rating.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="../js/star-rating.js" type="text/javascript"></script>
    <body>
<form id="ratestar" name="ratestarform" method="post" action="<%=request.getContextPath() %>/MusicController" >
         <input type="hidden" id='ratingstar' value="ratingstar" name="action">
                  <input type="text" id='ratingss' name="ratedvalue">
         
         Your Rating for c1003:<br>
    <input id="input-21c" name="userrate" value="0" type="number" class="rating" min=0 max=5 step=1 data-size="sm" >
       	<input type="submit" value="Submit" name="submit">  
       			<input type="hidden" name="usid" value=""></input>
       	
       	</form> 
       	
       	
 <script>
     jQuery(document).ready(function () {
     	 $('#input-21c').on('rating.change', function() {
           $a= $('#input-21c').val();
            $("#ratingss").attr('value',$a);
         

        });
     	  });
    </script>
         <br>Average Rating:<br> 
      <input id="input-21d" value="" type="number" class="rating" min=0 max=5 step=0.5 data-size="sm" readonly>
 </html>       
    