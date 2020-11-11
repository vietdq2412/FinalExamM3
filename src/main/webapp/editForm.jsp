<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <title>Add product</title>
</head>
<body>
<div class="container">
    <form action="/product?action=edit" method="post">
        <h1>Edit product</h1>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.getName()}">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price" value="${product.getPrice()}">
        </div>
        <div class="form-group">
            <label for="qua">Quantity</label>
            <input type="text" class="form-control" id="qua" name="quantity" value="${product.getQuantity()}" >
        </div>
        <div class="form-group">
            <label for="color">color</label>
            <input type="text" class="form-control" id="color" name="color" value="value="${product.getColor()}"">
        </div>
        <div class="form-group">
            <label >Description</label>
            <textarea type="text" class="form-control" id="desc" name="desc">${product.getDescription()}</textarea>
        </div>
        <div class="form-group">
            <select name="category" id="">
                <c:forEach items="${listCategory}" var="category">
                    <option value="${category}">${product.getCategory()}</option>
                </c:forEach>
            </select>
        </div>
        <button class="btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
