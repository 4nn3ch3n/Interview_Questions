<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Interview Questions</title>
</head>
<body>
	<h1>Interview Questions</h1>
	<form method="get">
		<input type="search" required />
		<button type="submit" formaction="QuestionResultsPage">Search</button> <br/>
		
		<c:forEach var="company" items="${ companies }">
			<input type="radio" name="company" value="${ company.companyName }"/> <label> ${ company.companyName } </label>
		</c:forEach>
		<br/>
		
		<input type="checkbox" name="stream" value="Java Developer"/> Java Developer
		<input type="checkbox" name="stream" value="App Support"/> App Support
		<input type="checkbox" name="stream" value="PMO"/> PMO	
	</form>
	<br/>	
	<form>
		<button type="submit" formaction="AddQuestionPage">Add Question</button>
		<button type="submit" formaction="AddCompanyPage">Add Company</button>
	</form>
	
	<br/>
	
	<table>
		<thead><h2>Questions List</h2></thead>
		<c:forEach var="question" items="${ questions }">
			<tr>
				<td>${ question.question }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>