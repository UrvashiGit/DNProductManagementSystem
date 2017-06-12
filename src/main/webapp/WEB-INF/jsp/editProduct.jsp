<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Edit Product

 <form:form method="post" action="updateProduct" modelAttribute="product">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"/>
          	<form:hidden path="id" />
          </td>  
         </tr>    
         <tr>    
          <td>description :</td>    
          <td><form:input path="description" /></td>  
         </tr>   
         <tr>    
          <td>measureUnit :</td>    
          <td><form:input path="measureUnit" /></td>  
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Update" /></td>    
         </tr>    
        </table>    
       </form:form>  

</body>
</html>