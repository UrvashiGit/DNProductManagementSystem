<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List Product</h1>
<table class="table table-striped" border="1">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Measure Unit</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="product" items="${productList}">
			    <tr>
				<td>
					${product.id}
				</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.measureUnit}</td>
				<td>
				  <spring:url value="/products/${product.id}/delete" var="deleteUrl" />
				  <spring:url value="/products/${product.id}/update" var="updateUrl" />

				  <%-- <button class="btn btn-info"
                                          onclick="location.href='${userUrl}'">Query</button> --%>
				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> 
                 </td>
			    </tr>
			</c:forEach>
		</table>

</body>
</html>