<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Update Specialty</title>
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
        table {
            width: 450px;
            background-color: white;
            margin-top: 1px;
            margin-bottom: 1px;
        }
        table, th, td {
            border: 0px solid #CCCCFF;
        }
        th, td {
            padding: 1px;
        }
    </style>
</head>
<body bgcolor='white'>

<table id="table-1">
    <tr><td>
        <h3>Update Specialty</h3>
        <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">Back to Home</a></h4>
    </td></tr>
</table>

<h3>Update Details:</h3>

<%-- Error messages --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">Please fix the following errors:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message}</li>
        </c:forEach>
    </ul>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/specialty.do">
    <table>
        <tr>
            <td>Specialty Number:<font color=red><b>*</b></font></td>
            <td>${specialtyVO.specNo}</td>
        </tr>
        <tr>
            <td>Specialty Name:</td>
            <td><input type="text" name="specName" value="${specialtyVO.specName}" size="45"/></td>
        </tr>
        <tr>
            <td>Specialty Description:</td>
            <td><input type="text" name="specDesc" value="${specialtyVO.specDesc}" size="45"/></td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="specNo" value="${specialtyVO.specNo}">
    <input type="submit" value="Submit Update">
</form>

</body>
</html>
