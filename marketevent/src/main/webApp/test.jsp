<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/12/16
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<table>
<tr>

    <td>id</td>
    <td>name</td>
</tr>
    <tr>
        <td>${productCategory.categoryCode}</td>
        <td>${productCategory.categoryName}</td>
    </tr>
</table>
<table>
    <tr>

        <td>id</td>
        <td>name</td>
    </tr>
    <tr>
        <td>${productComment.productId}</td>
        <td>${productComment.orderId}</td>
    </tr>
</table>
<table>
    <tr>

        <td>id</td>
        <td>name</td>
    </tr>
    <tr>
        <td>${productInfo.productCore}</td>
        <td>${productInfo.productName}</td>
    </tr>
</table>
<table>
    <tr>

        <td>id</td>
        <td>name</td>
    </tr>
    <tr>
        <td>${productPicInfo.productId}</td>
        <td>${productPicInfo.picDesc}</td>
    </tr>
</table>

</body>
</html>
