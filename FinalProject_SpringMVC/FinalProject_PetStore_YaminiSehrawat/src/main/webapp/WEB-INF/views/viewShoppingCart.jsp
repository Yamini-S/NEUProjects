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
     <ul class="nav navbar-nav navbar-right">
      <li>
         <form:form method="GET" action="logout" >
		  <input type="submit" value="Logout"/>
	     </form:form>	
      </li>
    </ul>
  </div>
</nav>

<div class="title">
  <h3>Products In Your Cart </h3>
  <input type="hidden" name="productID" id="productID" value=""/>
  <h4>Total Price: ${scl.getTotalPrice()}</h4>
  
</div>

<div>
<div class="content">

  <div class="insidecontent">
  <c:forEach var="item" items="${scl.getShoppingCartList()}" step="1"> 
  <form:form action="RemoveShoppingCart" commandName="shoppingCart" method="POST">
    <div class="section section-l section-m section-s">
	   <div class="image"><img height="150" width="150" class="img-circle" src="${item.photoName}"></a></div>
	     <div class="text">
	       <h5>${item.productName}</h5>
	       <p>${item.productDesc}</p>
	       <p>${item.productPrice}</p>
	     </div>
      </div>
      
    <form:input path='productId' value="${item.productId}" type="hidden"/> 
	<form:input path='photoName' value="${item.photoName}" type="hidden"/>
	<form:input path='productName' value="${item.productName}" type="hidden"/>
	<form:input path='productDesc' value="${item.productDesc}" type="hidden"/>
	<form:input path='productPrice' value="${item.productPrice}" type="hidden"/>
	<input type='submit' value='Remove'></input>  
  </form:form>
  </c:forEach>  

</div>
</div>

   <form:form action="Checkout" method="GET">
	  <input type='hidden' name='TotalPrice' value='${scl.totalPrice}' id='totalPrice'/><br/>
		<c:if  test="${scl.totalPrice gt 0}"> 
		  <input type='submit' name='submit' value='Check Out' style="width: 200px; "></input>
		</c:if>
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