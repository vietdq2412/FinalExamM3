<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2020
  Time: 8:58 AM
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
    <title>Product management</title>
    <style>
        .table {
            border-left: solid 1px;
            border-right: solid 1px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="navbar">
        <div>
            <a href="/product?action=create"><button class="btn-primary">Add new product</button></a>
            <a href="/product?action=show"><button class="btn-success">Show products</button></a>
        </div>
        <div style="float: right;">
            <input type="text">
            <button class="btn-primary">Search</button>
        </div>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product name</th>
            <th scope="col">Price</th>
            <th scope="col">Color</th>
            <th scope="col">Quantity</th>
            <th scope="col">Category</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listProduct}" var="product">
            <tr>
                <th scope="row">${product.getId()}</th>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getColor()}</td>
                <td>${product.getQuantity()}</td>
                <td>${product.getCategory()}</td>
                <td>
                    <a href="/product?action=edit&&id=${product.getId()}"><button>Edit</button></a>
                    <a href="/product?action=delete&&id=${product.getId()}"><button>Delete</button></a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
