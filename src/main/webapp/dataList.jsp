<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/26/2023
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
    <title>Edit User Data</title>
</head>
<body>
<c:import url="include/header.jsp">

</c:import>
<div>
    <table>
        <thead>
        <td>User_id</td>
        <td>Username</td>
        <td>Email</td>
        <td>Password</td>
        </thead>
        <tbody>
           <%
              ArrayList<User> dataList = (ArrayList<User>) request.getAttribute("userdata");
              for( int i =0; i< dataList.size(); i++){
                  out.print("<td>"+dataList.get(i).getUser_id()+"</td>");
                  out.print("<td>"+dataList.get(i).getUsername()+"</td>");
                  out.print("<td>"+dataList.get(i).getEmail()+"</td>");
              }
           %>
        </tbody>
    </table>
</div>
<c:import url="include/footer.jsp">

</c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>

