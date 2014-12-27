<!DOCTYPE html>
<html lang="en">
<head>
<style>
html{
background:url(<%=request.getContextPath() %>/main.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<title>Artist Sign Up page</title>
<meta charset="utf-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/Music/js/demo.css" type="text/css" media="all">
</head>
<body id="page1">
<div class="container">
<header>
      <h2><center><font size=26 color=#333300>ARTIST SIGN UP</font></center></h2>
      </header>
 <div  class="form">
 <form id="contactform" name="myForm" method="post" action="<%=request.getContextPath() %>/MusicController" onsubmit="return validate()">
 <p class="contact"><label for="uname">User Name</label></p> 
 <input id="name" name="uname" placeholder="First and last name" required="" tabindex="1" type="text"> 
 <p class="contact"><label for="email">Email</label></p> 
 <input id="email" name="email" placeholder="example@domain.com" required="" type="email"> 
 <p class="contact"><label for="username">Create a username</label></p> 
 <input id="username" name="username" placeholder="username" required="" tabindex="2" type="text"> 
 <p class="contact"><label for="password">Create a password</label></p> 
 <input type="password" id="password" name="password" required=""> 
 <p class="contact"><label for="repassword">Confirm your password</label></p> 
 <input type="password" id="repassword" name="repassword" required=""> 
 <input type='hidden' name='action' value='artistsignup'>
 <input class="button" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"> 	 
  
   </form> 
</div>      
</div>  
</body>
</html>
