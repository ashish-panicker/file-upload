<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>File Upload Form</h1>
	<hr />

	<fieldset>
		<legend>Upload File</legend>
		<form action="FileUpload" method="post"
			enctype="multipart/form-data">
			<label for="filename_1">File: </label> <input id="filename_1"
				type="file" name="filename_1" size="50" /><br /> <label
				for="filename_2">File: </label> <input id="filename_2" type="file"
				name="filename_2" size="50" /><br /> <br /> <input type="submit"
				value="Upload File" />
		</form>
	</fieldset>
</body>
</html>