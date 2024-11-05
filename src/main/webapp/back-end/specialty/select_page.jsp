<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Specialty: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>Specialty: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Specialty: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href="${pageContext.request.contextPath}/back-end/specialty/listAllSpecialty.jsp">List all Specialties</a></li> 
  <li><a href="${pageContext.request.contextPath}/back-end/specialty/addSpecialty.jsp">Add a New Specialty</a></li>
  
  
  <li>
    <FORM METHOD="post" action="${pageContext.request.contextPath}/specialty.do">
        <b>輸入占卜項目編號 (如10):</b>
        <input type="text" name="specNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="specialtySvc" scope="page" class="com.specialty.SpecialtyService" />
   
  <li>
     <FORM METHOD="post" action="${pageContext.request.contextPath}/specialty.do">
       <b>選擇占卜項目編號:</b>
       <select size="1" name="specNo">
         <c:forEach var="specialtyVO" items="${specialtySvc.all}" > 
          <option value="${specialtyVO.specNo}">${specialtyVO.specNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" action="${pageContext.request.contextPath}/specialty.do">
       <b>選擇占卜項目名稱:</b>
       <select size="1" name="specName">
         <c:forEach var="specialtyVO" items="${specialtySvc.all}" > 
          <option value="${specialtyVO.specName}">${specialtyVO.specName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display_By_Name">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>占卜項目管理</h3>

<ul>
  <li><a href="${pageContext.request.contextPath}/back-end/specialty/addSpecialty.jsp">Add a New Specialty</a></li>
</ul>

</body>
</html>