<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="<c:url value="/resources/css/projectStyle.css" />" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
<title>Pet Store : Final Project</title>
</head>
<body>

<div id="container">
    <div class="header">
       <div class="header1">
	    	<h1><img src="resources/Images/pet-icon.png" alt="Pet store" width="100px" height="80px"/>Pet Store</h1>
      </div>
    </div>
    
        <div id="signUpForm" class="styleForm">
	    <form:form method="GET" action="addLoginUser" commandName="loginUser">
		<div id="loginHeader">
           <h2>Sign Up</h2>
		 </div> <br/>
		 <table class="table table-bordered">
		  <tr>
            <th>Enter Username :</th>
            <td><form:input path="username" name="username" placeholder="myusername" id="userName"/>
              <font color="red"><form:errors path="username"/></font>
              <div class="unique-user-name"></div>
            </td>
          </tr>
           
          <tr>
            <th>Enter Password :</th>
            <td><form:input path="password" name="password" type="password" placeholder="eg. X8df!90EO"/> 
			  <font color="red"><form:errors path="password"/></font>
			</td>
		  </tr>
		  
		  <tr>
            <th> Enter Email ID-: </th>
		    <td><form:input path="emailId" type="email" name="emailId" placeholder="abc@mail.com"/>
			  <font color="red"><form:errors path="emailId"/></font>
			</td>
		  </tr>
		  
		  <tr>
		    <th>Enter ContactNo :</th>
		    <td><form:input path="contactNo" name="contactNo" type="number" required="required"/>
		    <font color="red"><form:errors path="contactNo"/></font>
		   </td>
		  </tr>
		   
		  <tr>
		   <th>Select Role: </th>
		   <td><form:radiobutton path="roleType" value="seller" required = "required"/>seller<br/>
		       <form:radiobutton path="roleType" value="customer" required = "required"/>customer
		   </td>
		  </tr>
		  </table> <hr>
		   <input id="register" type="submit" value="Create your account">
		   <p id="two">Already have an account? <a class="signin" href="#" id="signin">Sign in</a></p>
		   <input type="hidden" name="action" id="createAcc" value="createAcc">
		</form:form>
        </div>
        
        <div id="loginForm" class="styleForm">
	    <form:form method="GET" action="signInUser" commandName="loginUser">
		<div id="loginHeader">
           <h2>Log In</h2>
		 </div> <br/>
		<table  class="table table-bordered">
		  <tr>
            <th>Enter Username :</th>
            <td><form:input path="username" name="username" placeholder="myusername" required="required"/>
              <font color="red"><form:errors path="username"/></font>
            </td>
          </tr>
           
          <tr>
            <th>Enter Password :</th>
            <td><form:input path="password" name="password" type="password" placeholder="eg. X8df!90EO" required="required"/> 
			  <font color="red"><form:errors path="password"/></font>
			</td>
		  </tr>
		  </table>
		   <input type="checkbox" name="rememberMe" value="RememberMe">Keep Me Logged In
           <input type="submit" name="login" id="register" value="Login"><br/><br/><hr>
		    <p id="two">
					Not a member yet ?
					<a href="#" class="signup"  id="signup">Join us</a>
				</p>
		 
        </form:form>
		</div>
	
    
    <div class="footer">
            <div class="insidefooter"> 
			    <div class="foot" id="name"><a href="">Pet Store</a></div>
				   <span> Follow us on -- <a href="">FACEBOOK </a>| <a href=""> TWITTER </a> |<a href=""> YOUTUBE</a></span>
            	<div class="foot" id="sm"><span><a href=""> Home | Site Map | Search | Terms Of Use<br />
                @Pet Store. Boston, Massachusetts 02115. Copyright complaints</span>
                </div>
	       </div>
    </div>

</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$("#signup").click(function() {
$("#loginForm").fadeOut("slow", function() {
$("#signUpForm").fadeIn("3000");
});
});
// On Click SignIn It Will Hide Registration Form and Display Login Form
$("#signin").click(function() {
$("#signUpForm").fadeOut("slow", function() {
$("#loginForm").fadeIn("3000");
});
});

$("#userName").blur(function(){
var name = $("#userName").val();

$get("http://localhost:8080/edu/checkUniqueUsername",
		{
	     username : name
	},
	  function(data,status){
		if(data == "true"){
			$(".unique-user-name").html("User Name Unique!");
		}
		else if(data == "false")
		{
			$(".unique-user-name").html("User Name already taken. Please select another name");
		}
	});
});


});
</script>
</body>
</html>