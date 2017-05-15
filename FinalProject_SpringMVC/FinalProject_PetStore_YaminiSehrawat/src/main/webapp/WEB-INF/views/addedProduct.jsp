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
    
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Pet Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li style="color:white;">Welcome ${sessionScope.loginUserName}</li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
         <form:form method="GET" action="logout" >
		  <input type="submit" value="Logout" class="btn btn-info"/>
	   </form:form>	
      </li>
    </ul>
  </div>
  </nav>
    
        <div  class="styleForm">
        <h4><strong> Product Added Successfully:</strong></h4><br/>
        <table class="table table-bordered">
        <tr>
          <th>Product Name:</th>
          <td>${product.productName}</td>
        </tr>
        <tr>
          <th>Price:</th>
          <td>${product.productPrice}</td>
        </tr>
        <tr>
          <th>Description: </th>
          <td>${product.productDesc}</td>
        </tr>
        <tr>
          <th>Status: </th>
          <td>Product Added</td>
        </tr>
        </table>        
        <form:form method="POST" action="addMoreProduct" >
		  <input type="submit" name="submit" id="pLogout" value="Add More Product?"/>
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
</body>
</html>