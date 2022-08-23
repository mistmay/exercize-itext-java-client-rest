<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List, com.advancia.clientj.model.User"%>
<%
List<User> users = (List<User>) request.getAttribute("users");
if (users == null) {
	response.sendRedirect("UserServlet");
} else {
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Giuseppe Marchesiello">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<title>User List</title>
</head>
<body>
	<main class="p-5">
		<section class="container">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Surname</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (User user : users) {
					%>
					<tr>
						<td><%=user.getName()%></td>
						<td><%=user.getSurname()%></td>
						<td><%=user.getAge()%></td>
					</tr>
					<%
}
%>
				</tbody>
			</table>
			<form class="mt-3 d-flex justify-content-center align-items-center"
				method="get" action="DownloadServlet">
				<button type="submit" class="btn btn-primary">Generate Pdf</button>
			</form>
		</section>
	</main>
</body>
</html>
<%
}
%>
