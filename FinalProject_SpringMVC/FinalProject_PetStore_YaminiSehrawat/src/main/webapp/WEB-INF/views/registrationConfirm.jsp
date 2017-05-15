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
<title>Pet Store : Final Project</title>
</head>
<body>
<div id="container">
    <div class="header">
       <div class="header1">
	    	<h1><img src="resources/Images/pet-icon.png" alt="Pet store" width="100px" height="80px"/>Pet Store</h1>
      </div>
    </div>
    
    <div class="styleForm">
       <h3> New User Created Successfully:</h3> 
       <table class="table table-bordered table-hover">
       <tr>
         <th>User Name:</th>
         <td>${loginUser.username}</td>
       </tr>
       
       <tr>
         <th>Email:</th>
         <td> ${loginUser.emailId}</td>
       </tr>
       
       <tr>
         <th>Contact:</th>
         <td>${loginUser.contactNo}</td>
       </tr>
       
       <tr>
         <th>Role :</th>
         <td>${loginUser.roleType}</td>
       </tr>
       </table>
       <form:form method="GET" action="logout" >
		  <input type="submit" name="submit" id="register" value="Return to Login Page"/>
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
 </body>
</html>