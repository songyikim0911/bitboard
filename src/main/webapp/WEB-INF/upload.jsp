<%--
  Created by IntelliJ IDEA.
  User: ksi64
  Date: 2021-08-20
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>Title
<body>
<form action = "/upload" method ="post" enctype="multipart/form-data">
    <!--//enctype 인코딩 타입-->
    <input type ="text" name ="title" value=test....">
    <input type ="file" name="uploadFiles" multiple>
    <!--multipart 입력창 하나로 파일 여러개 올려서 사용 가능-->
    <button type="submit">Submit</button>
</form>
</body>
</html>
