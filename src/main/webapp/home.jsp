<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/22/2023
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
    <title>Home Page</title>
</head>
<body>
<c:import url="include/header.jsp">

</c:import>
<div>
    <a href="${pageContext.request.contextPath}/DBConnection"></a>
</div>
<c:import url="include/footer.jsp">

</c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>
