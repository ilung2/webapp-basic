<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>
	<form action="./file" method="post" enctype="multipart/form-data">
		<input type="file" name="upload">
		<input type="submit">
	</form>
</body>
</html>