<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="models.Book"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="module">
			<h2>
				<span>Sửa thông tin sách</span>
			</h2>

			<div >
				<p style="color: red; font-weight: bold">${err}</p>
				<form action="<%=request.getContextPath()%>/EditProduct" method="post">
					
					<%
						if(request.getAttribute("objBook")!=null){
							Book objBook=(Book) request.getAttribute("objBook");
						
					%>
					<p>
						<input type="hidden" name="bookId" value="<%=objBook.getBookId() %>" />

					</p>

					<p>
						<label>title</label><br/>
						<input type="text" name="title" value="<%=objBook.getTitle() %>" />
					</p>

					<p>
						<label>description</label><br/>
						<textarea rows="3" cols="25"  name="description"><%=objBook.getDescription() %></textarea>
					</p>

					<p>
						<label>detail</label><br/>
						<textarea rows="3" cols="25"  name="detail"><%=objBook.getDetail() %></textarea>
					</p>
					
					<p>
						<label>enabled</label><br/>
						<input type="text" name="enabled" value="<%=objBook.getEnabled() %>" />
					</p>					
					<%} %>
						<input  type="submit" value="Sửa sách" />
				</form>
			</div>
		</div>
		
	
</body>
</html>
	