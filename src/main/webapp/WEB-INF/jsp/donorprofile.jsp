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
    <body >
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Vaccine Provider - ${sessionScope.donorsession.firstName } ${sessionScope.donorsession.lastName }</p>
            <div><a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a> </div>
            <div><a href="${pageContext.request.contextPath}/donorReq.htm">My Requests</a> </div>
            <div><a href="requesterlogout.htm" class="btn btn-default btn-flat">Sign out</a> </div>
            <div><a href="${pageContext.request.contextPath}/donorhome.htm">Home</a> </div>
            <br /> <br />

            <form:form role="form" action="updatedonorprofile.htm" commandName = "person" method="post">
                <fieldset>
                    <legend>Update Your Profile :</legend>
                    <label><b>First Name:</b></label> 
                    <form:input path="firstName" value = "${updateSta.firstName }" required = "required"/> <form:errors path="firstName"/> <br /><br />
                    <label><b>Last Name</b></label> 
                    <form:input path="lastName" value = "${updateSta.lastName }" required = "required"/> <form:errors path="lastName"/> <br /><br />
                    <label><b>Password</b></label> 
                    <form:password path= "password" value = "${updateSta.password }" required = "required"/> <form:errors path="password"/> <br /><br />
                    <label><b>Email</b></label> 
                    <form:input path="email" type = "email" value = "${updateSta.email }" id="form-email-name" required = "required"/> <form:errors path="email"/> <br /><br />
                    <label><b>Gender</b></label> 
                    <form:input path= "gender" value = "${updateSta.gender }" required = "required"/> <form:errors path="gender"/> <br /><br />
                    <label><b>Age</b></label> 
                    <form:input path="age"  type = "number" min = "1" max = "100" value = "${updateSta.age }" required = "required"/> <form:errors path="age"/> <br /><br />
                    <label><b>Address</b></label> 
                    <form:input path= "address" value = "${updateSta.address }" required = "required"/> <form:errors path="address"/> <br /><br />
                    <label><b>City</b></label> 
                    <form:input path="city" value = "${updateSta.city }" required = "required"/><form:errors path="city"/>  <br /><br />
                    <label><b>Phone Number</b></label> 
                    <form:input path= "phoneNumber" type = "number" min = "1000000000" max = "9999999999" value = "${updateSta.phoneNumber }" required = "required"/> <form:errors path="phoneNumber"/> <br /><br />
                   
                    <div><input type="submit" value="Update Profile" ></div>
           
                    <div>
                        <c:if test="${!empty requestScope.error}">
                            <p style="color:red">Updated Successfully</p>
                        </c:if>
                    </div> 
                </fieldset>
            </form:form>
        </div>
     
    </body>
</html>