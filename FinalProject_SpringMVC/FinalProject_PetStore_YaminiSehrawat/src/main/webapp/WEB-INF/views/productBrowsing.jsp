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
    

    <div class="navigation">
    <ul class="nav nav-tabs" style="background-color:#161616;">
      <li class="active" id="aboutPetStore"><a data-toggle="tab" href="#aboutPetStore">About</a></li>
      <li id="dogProd"><a data-toggle="tab" href="#dogBrowse">Dogs</a></li>
      <li id="catProd"><a data-toggle="tab" href="#catBrowse">Cats</a></li>
      <li style="float:right;"><a data-toggle="tab"  href="#cart"><span class="glyphicon glyphicon-shopping-cart"></span> Your Cart</a></li>
       <li style="float:right;line-height:25px;">
         <form:form method="GET" action="logout" >
		  <input type="submit" value="Logout" class="btn btn-info"/>
	     </form:form>	
      </li>
    </ul>
    </div>


<br/>
 <div class="head">
 <table>
	<tr>
		<td>
		   <p style="float:left;color:red;font-style:italic;">Welcome ${sessionScope.loginUserName}</p>
		</td>
	</tr>
	<tr>
		<td>
		  <p style="float:left;font-style:italic;">Buy Food, accessories for your pets!</p>
		</td>													
    </tr>
 </table>
 </div>
 <hr>
 <div style="display:inline;">
   <form:form method="GET" action="productSearch" >
    <table>
    <tr>
     <td>Search For Products?</td>
     <td><input placeholder="enter keyword" id="pSearch" name="keyword" required="required"/></td>
    </tr>
    <tr>
      <td><input type ="radio" name="search" value="byID" required="required" /><label> Search By ID</label></td>
      <td><input type ="radio" name="search" value="byName" required="required"/><label>Search By Name</label></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Search" class="btn btn-info" /></td>
    </tr>
     </table>
 </form:form>
 </div>
 <br/><hr>
    
  <div id="productBrowse">  
    <div class="tab-content">
    
    <div id="aboutPetStore" class="tab-pane fade in active" style="background-image:url(resources/Images/back1.gif);">
     <h2 style="font-style:italic;text-shadow: 2px 2px #FF0000;">Welcome To Pet Store</h2>
      <p>At Pet Store, we offer products for only dogs and cats. We are here to support pet parents by providing products, food, accossories, and supplies.</p>
      <p>Our comprehensive commitment to meeting the social, physical, emotional, and mental needs of your pets reflects our mission that nothing is more important<br/> than sharing a lifetime of memories with our pets.</p>
      <p>Our aim is to nurture the complete health and well being of all animals.</p>
      <h4 style="font-style:italic;">Featured Pet Products</h4>
       <p>Along with toys, supplements, beds, and many other pet supplies, we offer a mixture of healthy treats and foods necessary to keep your pets fit and happy.</p>
       <p>You can also find a variety of premium pet services available at Petco right inside most stores.</p><br/>
         <h4> Our featured pet products include: </h4>
          <ul style="list-style-type:circle;">
            <li>Food</li>
            <li>Accessorries</li>
            <li>Clothes</li>
          </ul>
          
       <div id="rightBody4">
		   <h3 style="text-align:left;color:red;font-size:20px;"> Check Customer Reviews</h3>
	          <img src="resources/Images/e4.jpg" class="imageScroll" alt="e4"/><p class="textScroll">The prices on the site are also reasonably low. They do sell more expensive items, but they are generally the larger items or the items in bulk.</p>
		      <img src="resources/Images/e5.jpg" class="imageScroll" alt="e5"/><p class="textScroll">Friendly and knowledgable staff, pretty good selection in the branch, really kid-friendly.</p>
		      <img src="resources/Images/e6.jpg" class="imageScroll" alt="e6"/><p class="textScroll">This store is mammoth.  The new extension houses a huge collection of pet products.  Their courtyard man, it was just fantastic.  It definitely makes you feel like you are in New England for sure. </p>
		      <img src="resources/Images/e4.jpg" class="imageScroll" alt="e4"/><p class="textScroll">Grand and beautiful library castle vibe. The courtyard is a must, a little gem that many Bostonians themselves haven't seen. </p>
	          <p>The popular study room with the green desk lamps is always packed. There are plenty other rooms to study or do homework, just go look for them.
                 Take your time and the explore. It's like a library, art museum, castle combo! Don't worry about getting lost. Rooms are labeled from the outside and 
				 directories on every flow</p>
			  <p>The Boston Athenaeum is a must see for locals and visitors alike. It is a really interesting place to check out that is a little off the beaten path. 
			      It is only about a block away from the state house almost right on the freedom trail so it is an easy attraction to add to your list! There are only a few 
			      rooms open to non-members so it is not a hugely time consuming item to add to your list. It is a beautiful place to visit and tons of history. </p>
		</div>
    
    </div> 
    
    
    <div id="dogBrowse" class="tab-pane fade">
    
  <form:form action="addToCart" commandName="shoppingCart" method="GET" enctype="multipart/form-data"> 
    <table class="table table-bordered table-hover table-responsive" id="myTable">
    <thead>
      <th  class="danger">ProductID</th>
      <th  class="danger">Name</th>
      <th  class="danger">Description</th>
      <th  class="danger">Price(in $)</th>
      <th  class="danger">Photo</th>
      <th  class="danger">Action</th>
    </thead>
    <input type="hidden" id="productID" name="productID" value="action"/>
    <c:forEach items="${productList}" var="product">
    <tbody>
        <tr class="info">
          <th scope="row">${product.productId}</th>
          <form:input path="productId" value="${product.productId}" type="hidden" />          
          
          <td>${product.productName}</td>
          <form:input path="productName" value="${product.productName}" type="hidden" />
          
          <td>${product.productDesc}</td>
          <form:input path="productDesc" value="${product.productDesc}" type="hidden" />
          
          <td>${product.productPrice}</td>
         <form:input path="productPrice" value="${product.productPrice}" type="hidden" /> 
          
          <td><img height="150" width="150" class="img-circle" src="${product.photoName}"/></td>
          <form:input path="photoName" value="${product.photoName}" type="hidden" />
          
          <td><input type="submit" value="Add to Cart" class="btn btn-info" onclick="return checkProductId('${product.productId}');"/></td>
        </tr>
    </tbody> 
    </c:forEach>
    </table>
   </form:form>
    </div>
    
    <div id="catBrowse" class="tab-pane fade">
    
   <form:form action="addToCart" commandName="shoppingCart" method="GET" enctype="multipart/form-data"> 
    <table class="table table-bordered table-hover">
    <thead>
      <th  class="danger">ProductID</th>
      <th  class="danger">Name</th>
      <th  class="danger">Description</th>
      <th  class="danger">Price</th>
      <th class="danger">Photo</th>
      <th  class="danger">Action</th>
    </thead>
    <input type="hidden" id="catProductID" name="catProductID" value="action"/>
    <c:forEach items="${productList}" var="product">
    <tbody>
        <tr class="info">
          <th scope="row">${product.productId}</th>
          <form:input path="productId" value="${product.productId}" type="hidden" />
            
          <td>${product.productName}</td>
          <form:input path="productName" value="${product.productName}" type="hidden" />
          
          <td>${product.productDesc}</td>
          <form:input path="productDesc" value="${product.productDesc}" type="hidden" />
          
          <td>${product.productPrice}</td>
          <form:input path="productPrice" value="${product.productPrice}" type="hidden" />
          
          <td><img height="150" width="150" class="img-circle" src="${product.photoName}"/></td>
          <form:input path="photoName" value="${product.photoName}" type="hidden" />
          
          <td><input type="submit" value="Add to Cart" class="btn btn-info" onclick="return checkCatProductId('${product.productId}');"/></td>
       </tr>
    </tbody> 
    </c:forEach>
    </table>
    </form:form>
    </div> 
    
  <div id="cart" class="tab-pane fade">
    <h2 style="color:red;font-style:italic;">Your Shopping Cart</h2>
    
    <form:form action="RemoveCart" commandName="shoppingCart" method="GET">
    <table class="table table-bordered table-hover">
    <thead>
      <th  class="danger">ProductID</th>
      <th  class="danger">Name</th>
      <th  class="danger">Description</th>
      <th  class="danger">Price</th>
      <th  class="danger">Photo</th>
      <th  class="danger">Action</th>
    </thead>
    <input type="hidden" id="removeProductID" name="removeProductID" value="action"/>
    <c:forEach var="item" items="${scl.getShoppingCartList()}" step="1">
    <tbody>
        <tr class="info">
          <th scope="row">${item.productId}</th>
          <form:input path="productId" value="${item.productId}" type="hidden" />
            
          <td>${item.productName}</td>
          <form:input path="productName" value="${item.productName}" type="hidden" />
          
          <td>${item.productDesc}</td>
          <form:input path="productDesc" value="${item.productDesc}" type="hidden" />
          
          <td>$${item.productPrice}</td>
          <form:input path="productPrice" value="${item.productPrice}" type="hidden" />
          
          <td><img height="150" width="150" class="img-circle" src="${item.photoName}"/></td>
          <form:input path="photoName" value="${item.photoName}" type="hidden" />
          
          <td><input type="submit" value="Remove" class="btn btn-info" onclick="return checkRemoveProductId('${item.productId}');"/></td>
       </tr>
    </tbody> 
    </c:forEach>
    </table>
    </form:form>
    <div style="float:right">
    <form:form action="Checkout" method="GET" >
    <input name="TotalPrice" value="${scl.getTotalPrice()}" id="totalPrice" type="hidden" style="margin-right:5px"/>
    Total Price: $ ${scl.getTotalPrice()}
    <c:if  test="${scl.totalPrice gt 0}">
    <input type='submit' name='submit' value='Check Out' class="btn btn-info" style="margin:5px"/>
    </c:if>
    </form:form>
    </div>
 </div>
  
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
function checkProductId(id){
	document.getElementById("productID").value = id;
};
function checkRemoveProductId(removeId){
	document.getElementById("removeProductID").value = removeId;
}

function checkCatProductId(id){
	document.getElementById("catProductID").value = id;
};

</script>
<script>
$(document).ready(function(){
$('#myTable').dataTable();
});
</script>

</body>
</html>