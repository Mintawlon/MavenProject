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
        <tr>
            <th>User_id</th>
            <th>Username</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <%
            ArrayList<User> dataList = (ArrayList<User>) request.getAttribute("userdata");
            for( int i =0; i< dataList.size(); i++){
                out.print("<tr>");
                out.print("<td>"+dataList.get(i).getUser_id()+"</td>");
                out.print("<td>"+dataList.get(i).getUsername()+"</td>");
                out.print("<td>"+dataList.get(i).getEmail()+"</td>");
                String URL =request.getContextPath()+"/UserController?getData=update&userId="+dataList.get(i).getUser_id();
                out.print("<td><a href="+URL+">Update</a></td>");
                out.print("</tr>");
            }
        %>
    </table>

</div>
<c:import url="include/footer.jsp">

</c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>

