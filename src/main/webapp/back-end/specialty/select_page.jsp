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

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
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
        <b>��J�e�R���ؽs�� (�p10):</b>
        <input type="text" name="specNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>

  <jsp:useBean id="specialtySvc" scope="page" class="com.specialty.SpecialtyService" />
   
  <li>
     <FORM METHOD="post" action="${pageContext.request.contextPath}/specialty.do">
       <b>��ܥe�R���ؽs��:</b>
       <select size="1" name="specNo">
         <c:forEach var="specialtyVO" items="${specialtySvc.all}" > 
          <option value="${specialtyVO.specNo}">${specialtyVO.specNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" action="${pageContext.request.contextPath}/specialty.do">
       <b>��ܥe�R���ئW��:</b>
       <select size="1" name="specName">
         <c:forEach var="specialtyVO" items="${specialtySvc.all}" > 
          <option value="${specialtyVO.specName}">${specialtyVO.specName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display_By_Name">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�e�R���غ޲z</h3>

<ul>
  <li><a href="${pageContext.request.contextPath}/back-end/specialty/addSpecialty.jsp">Add a New Specialty</a></li>
</ul>

</body>
</html>