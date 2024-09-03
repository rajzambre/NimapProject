<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/add_product" method="post">

<!--<label for="id">Product Id :</label>
<input type="text" name="id" id="id" required="required"><br><br> -->

<label for="name"> Product Name :</label>
<input type="text" name="name" id="name" required="required"><br><br>

<label for="price">Product Price :</label>
<input type="text" name="price" id="price" required="required"><br><br>

<label for="category">Category :</label>

<select name="categoryId" id="category">

<c:forEach var="category" items="${categories}">
<option value="${category.id }">${category.name }</option>
</c:forEach>
</select><br><br>

<input type="submit" value="Add Product">

</form>
</body>
</html>