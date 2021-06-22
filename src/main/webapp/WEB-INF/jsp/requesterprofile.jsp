<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
            legend {
                font-size: 2rem;
                font-weight: bold
            }
            p {
                color: #944e6c;
                font-size: 2rem;
            }
            label {
                display: inline-block;
                width: 180px;
                text-align: left;
                font-size: 1.4rem;
            }​
           
        </style>
    </head>
    <body>

        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Requester Name - ${sessionScope.requestersession.firstName } ${sessionScope.requestersession.lastName }</p>
            <div><a href="${pageContext.request.contextPath}/requesterhome.htm"><span>Home</span></a></div>  
            <div><a href="${pageContext.request.contextPath}/viewreqprofile.htm">View Profile</div>
            <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a></div>
            <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>                
        </div>
        <br />

        <div>
            <form:form role="form" action="updaterequesterprofile.htm" commandName = "requester" method="post">
                <fieldset>
                    <legend>Update Requester Profile :</legend>
                        <br /> <br />
                        <label><b>First Name:</b></label>
                        <form:input path="firstName" value = "${updateSt.firstName }"/> <form:errors path="firstName"/> <br /><br />
                        <label><b>Last Name</b></label>
                        <form:input path="lastName" value = "${updateSt.lastName }"/> <form:errors path="lastName"/> <br /><br />
                        <label><b>Password</b></label>
                        <form:password path= "password" value = "${updateSt.password }"/> <form:errors path="password"/> <br /><br />
                        <label><b>Email</b></label>
                        <form:input path="email" type = "email" value = "${updateSt.email }"/> <form:errors path="email"/> <br /><br />
                        <label><b>Gender</b></label>
                        <form:input path= "gender" value = "${updateSt.gender }"/> <form:errors path="gender"/> <br /><br />
                        <label><b>Age</b></label> 
                        <form:input path="age" value = "${updateSt.age }" type = "number" min = "1" max = "100" /> <form:errors path="age"/> <br /><br />
                        <label><b>Address</b></label>
                        <form:input path= "requestedAddress" value = "${updateSt.requestedAddress }" /> <form:errors path="requestedAddress"/> <br /><br />
                        <label><b>City</b></label>
                        <form:input path="requestedCity" value = "${updateSt.requestedCity }" /> <form:errors path="requestedCity"/> <br /><br />
                        <label><b>Phone Number</b></label> 
                        <form:input path= "phoneNumber" type = "number" min = "1000000000" max = "9999999999" value = "${updateSt.phoneNumber }" /> <form:errors path="phoneNumber"/> <br /><br />
                        <label><b>Vaccine Name</h4></b></label> 
                        <form:input path= "requestedvaccines" value = "${updateSt.requestedvaccines }" /> <form:errors path="requestedvaccines"/> <br /><br />
                                               
                    <c:if test="${!empty requestScope.error}">
                        <p style="color:green">Profile updated successfully</p>
                    </c:if>
                <br />
                <div><input type="submit" value="Update Profile"></div>
            </fieldset>
        </form:form>
    </div>

</body>
</html>