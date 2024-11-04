<%@ page import="com.specialty.SpecialtyVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- This page uses Script to get values --%>

<%
  SpecialtyVO specialtyVO = (SpecialtyVO) request.getAttribute("specialtyVO"); // SpecialtyServlet.java(Controller), stored in request as specialtyVO
%>

<html>
<head>
<title>Specialty Details - listOneSpecialty.jsp</title>

<style>
  table#table-1 {
    background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
    width: 600px;
    background-color: white;
    margin-top: 5px;
    margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>This page uses Script to get values:</h4>
<table id="table-1">
  <tr><td>
     <h3>Specialty Details - listOneSpecialty.jsp</h3>
     <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">Back to Home</a></h4>
  </td></tr>
</table>

<table>
  <tr>
    <th>Specialty Number</th>
    <th>Specialty Name</th>
    <th>Specialty Description</th>
  </tr>
  <tr>
    <td><%=specialtyVO.getSpecNo()%></td>
    <td><%=specialtyVO.getSpecName()%></td>
    <td><%=specialtyVO.getSpecDesc()%></td>
  </tr>
</table>

</body>
</html>
