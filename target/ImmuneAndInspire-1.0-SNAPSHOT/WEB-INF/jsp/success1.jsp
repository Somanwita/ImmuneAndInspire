<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Make a request success</title>
    <style>
            body {
                background-color: #c9cbff;
                font-family: "Times New Roman", Times, serif;
            }
            h1   {
                color: #944e6c;
                text-align: center;
                
            }
            a {
                font-size: 2rem;
            }
           
        </style>
</head>
<body>
<h1>Request posted successfully</h1>
<a href="${pageContext.request.contextPath}/back.htm"> << Go Back</a> <br />
<a href="${pageContext.request.contextPath}/reqhome.htm"> << Home Page</a>
</body>
</html>