<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.specialty.*"%>

<%
// See SpecialtyServlet.java for setting the specialtyVO in request scope
SpecialtyVO specialtyVO = (SpecialtyVO) request.getAttribute("specialtyVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>新增占卜項目 - addSpecialty.jsp</title>

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
		<tr>
			<td>
				<h3>新增占卜項目 - addSpecialty.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img
						src="<%=request.getContextPath()%>/back-end/images/tomcat.png"
						alt="Tomcat Image" width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="${pageContext.request.contextPath}/specialty.do" name="form1">
		<table>
			<tr>
				<td>占卜項目編號:</td>
				<td><input type="text" name="specNo"
					value="<%=(specialtyVO == null) ? "" : specialtyVO.getSpecNo()%>"
					size="45" /></td>
			<tr>
				<td>占卜項目名稱:</td>
				<td><input type="TEXT" name="specName"
					value="<%=(specialtyVO == null) ? "" : specialtyVO.getSpecName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>占卜項目描述:</td>
				<td><input type="TEXT" name="specDesc"
					value="<%=(specialtyVO == null) ? "" : specialtyVO.getSpecDesc()%>"
					size="45" /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>

</body>
</html>
