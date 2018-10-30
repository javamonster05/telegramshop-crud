<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Products</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add Product
</h1>

<c:url var="addAction" value="/products/add"></c:url>

<form:form action="${addAction}" modelAttribute="product">
    <table>
        <c:if test="${!empty product.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"></form:input>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <%--name row--%>
        <tr>  
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <%--supplier id fk row--%>
        <tr>
            <td>
                <form:label path="supplier">
                    <spring:message text="Supplier ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="supplier.id"/>
            </td>
        </tr>
        <%--price--%>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>

            <td>
                <form:input path="price" />
            </td>
        </tr>
        <%--Description--%>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>

            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <%--imageId--%>
        <tr>
            <td>
                <form:label path="imageId">
                    <spring:message text="Image ID"/>
                </form:label>
            </td>

            <td>
                <form:input path="imageId"/>
            </td>
        </tr>
        <%--submit knopka--%>
        <tr>
            <td colspan="2">
                <c:if test="${!empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>" />
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Product List</h3>
<c:if test="${empty productList}">
    <h4>Currently no products in database</h4>
</c:if>
<c:if test="${!empty productList}">
    <table class="tg">
        <tr>
            <th width="80">Product ID</th>
            <th width="120">Product Name</th>
            <th width="80">Supplier ID</th>
            <th width="80">Price</th>
            <th width="150">Description</th>
            <th width="120">Image ID</th>
            <th width="60"></th>
            <th width="60"></th>
        </tr>

        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.supplier.id}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.imageId}</td>
                <td><a href="<c:url value='products/edit/${product.id}' />" >Edit</a></td>
                <td><a href="<c:url value='products/remove/${product.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</c:if>
</body>
