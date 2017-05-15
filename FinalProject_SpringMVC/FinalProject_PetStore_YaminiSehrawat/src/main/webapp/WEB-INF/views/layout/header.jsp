<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

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