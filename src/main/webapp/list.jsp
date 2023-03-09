<%@page import="models.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<body>
	<div style="margin: 0 auto; width: 60%;">
		<table>
			<tr>
				<th>bookId</th>
				<th style="width: 20%">title</th>
				<th>description</th>
				<th>detail</th>
				<th>status</th>
				<th>function</th>
			</tr>
			<%
				if(request.getAttribute("listBooks")!=null){
					
					 ArrayList<Book> listBooks=(ArrayList<Book>) request.getAttribute("listBooks");
					 for(Book objBook: listBooks){
			%>
			<tr>
				<td style="text-align: center"><%=objBook.getBookId() %></td>
				<td><%=objBook.getTitle() %></td>
				<td><%=objBook.getDescription() %></td>
				<td><%=objBook.getDetail() %></td>
				<td style="text-align: center"><%=objBook.isStatus()? 1 : 0 %></td>
				<td>
					<a href="<%=request.getContextPath()%>/edit?bookId=<%=objBook.getBookId()%>">Sửa</a>
				 	<a href="<%=request.getContextPath()%>/del?bookId=<%=objBook.getBookId()%>"
					onclick="return confirm('Bạn có chắc chắn muốn xóa không?')">Xóa</a>
				</td>
			</tr>
			<%}} %>
		</table>
	</div>
</body>
</html>