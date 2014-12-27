<!DOCTYPE html>
<html lang="en">
<head>
<title>User Sign Up</title>
<meta charset="utf-8">
<style>
html{
background:url(<%=request.getContextPath() %>/main.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/Music/js/demo.css" type="text/css" media="all">
</head>
<body id="page1">
<div class="container">
<header>
      <h2><center><font size=26 color=#333300>SIGN UP</font></center></h2>
      </header>
 <div  class="form">
 <form id="contactform" name="myForm" enctype="multipart/form-data" method="post" action="<%=request.getContextPath() %>/MusicControl?action=usignup" onsubmit="return validate()">
 <p class="contact"><label for="name">User ID</label></p> 
 <input id="name" name="uid"  placeholder="User ID" required="" tabindex="1" type="text"> 
 <p class="contact"><label for="email">Email</label></p> 
 <input id="email" name="email"  placeholder="example@domain.com" required="" type="email"> 
 <p class="contact"><label for="username">Name</label></p> 
 <input id="username" name="username"  placeholder="Name" required="" tabindex="2" type="text"> 
 <p class="contact"><label for="password">Create a password</label></p> 
 <input type="password" id="password" name="password" required=""> 
 <p><label>Upload Picture</label>
<input type="file"  name="ImageFile" id="ImageFile" />
</p>
 <p class="contact"><label for="city">City Residing in currently</label></p> 
 <input id="city" placeholder="City" name="city" required="" type="city"> 
<fieldset>
 <label>Birthday</label>
 <label class="month"> 
 <select class="select-style" name="BirthMonth">
                  <option value="">Month</option>
                  <option value="01">January</option>
                  <option value="02">February</option>
                  <option value="03" >March</option>
                  <option value="04">April</option>
                  <option value="05">May</option>
                  <option value="06">June</option>
                  <option value="07">July</option>
                  <option value="08">August</option>
                  <option value="09">September</option>
                  <option value="10">October</option>
                  <option value="11">November</option>
                  <option value="12" >December</option>
                  </label>
                 </select>    
 <label>Day<input class="birthday" maxlength="2" name="BirthDay"  placeholder="Day" required=""></label>
 <label>Year <input class="birthyear" maxlength="4" name="BirthYear" placeholder="Year" required=""></label>
</fieldset>
 <p class="contact"><label for="details">Short Desciption about Self</label></p> 
 <input id="details" type="details" name="details" placeholder="Short description" required="" type="text"> <br>
 <input class="buttom" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"> 	 
   </form> 
   <input type='hidden' name='action' value='usignup'>
</div>      
</div>  
</body>
</html>
