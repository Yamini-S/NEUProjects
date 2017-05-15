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

<div id = "container">
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
    
    <div id="addProductForm" class="styleForm">
    <form:form method="post" action="addProducts" commandName="product" enctype="multipart/form-data">
      <h4> Enter Your Product Details </h4>
      <table class="table table-bordered">
      <tr>
        <th>ProductCatalog</th>
        <td><form:radiobutton path="productType" value="Dogs" required="required"/>Dogs
          <form:radiobutton path="productType" value="Cats" required="required"/>Cats
        </td>
      </tr>
      
      <tr>
        <th>Product Name:</th>
        <td><form:input path="productName" name="productName" placeholder="Enter Product Name" required="required"/>
              <font color="red"><form:errors path="productName"/></font>
        </td>
      </tr>
      
      <tr>
        <th>Product Price:</th>
        <td><form:input path="productPrice" type="number" name="productPrice" placeholder="Enter Product Price" required="required"/>
              <font color="red"><form:errors path="productPrice"/></font>
        </td>
      </tr>
      
      <tr>
        <th>Product description:</th>
        <td><form:input path="productDesc" name="productDesc" placeholder="Enter Description" required="required"/>
              <font color="red"><form:errors path="productDesc"/></font>
        </td>
      </tr>
      
      <tr>
        <th> Select Photo (Max Size: 5MB):</th>
        <td><form:input path="photo" name="photo" type="file" required="required"></form:input>
              <font color="red"><form:errors path="photo"/></font>
        </td>
      </tr>
      </table>
      <input id="register" type="submit" value="Add Product"><hr>
      
   
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