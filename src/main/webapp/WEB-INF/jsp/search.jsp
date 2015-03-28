<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html ng-app="flexWebApp">
<head>
    <title>Codathon</title>
</head>
<body>
<h2>Please take a look at the searchable products and add querystring to search offers on that product e.g, add "?productName=mobile" in the querystring to see the offers on mobile </h2>
    <div>
        <core:forEach items="${offers}" var="offer">
            <div>
                Product Name: ${offer.product.name}<br/>
                Product price: ${offer.product.price}<br/>
                Offer price: ${offer.offerPrice}<br/>
                Offer string: ${offer.offerString}
            </div>
            <br/>
            <hr>
        </core:forEach>
    </div>

    <div>
        <h4>Here are the searchable products</h4>
        <core:forEach items="${products}" var="product">
            <div>
                Product Name: ${product.name}
                Product price: ${product.price}
            </div>
        </core:forEach>
    </div>

    <div>
        <h4>Here are the offer strings from various sites</h4>
        <core:forEach items="${offerStrings}" var="offerString">
            <div>
                ${offerString}
            </div>
        </core:forEach>
    </div>

</body>
</html>