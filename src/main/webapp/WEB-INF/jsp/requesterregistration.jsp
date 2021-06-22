<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Requester Register Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <h1><em>Immune And Inspire</em></h1>
        <form:form role="form" action="requesterregistration.htm" commandName = "requester" method="post">   
          <fieldset>
            <legend>Vaccine Requester Registration </legend>
            
            <div>
             <label>First name</label>
             <form:input path="firstName" placeholder="First name"/>
             <form:errors path="firstName"/>
            </div> <br />
            
            <div>
             <label>Last name</label>
             <form:input path="lastName" placeholder="Last name"/>
             <form:errors path="lastName"/>
            </div> <br />
            
            <div>
             <label>Password</label>
             <form:password path="password" placeholder="Password" />
             <form:errors path="password"/>
            </div> <br />
            
            <div>
             <label>Email</label>
             <form:input path="email" type = "email" placeholder="Email"/>
             <form:errors path="email"/>
            </div> <br />
            
            <div>
             <label>Gender</label>

            <form:select path = "gender">						       
		<option>Male</option>
		<option>Female</option>
		<option>Do not prefer to answer</option>
            </form:select>
            <form:errors path="gender"/>
            </div> <br />
            
            <div>
             <label>Age</label>
             <form:input path="age" placeholder="Age" type = "number" min = "1" max = "100"/>
             <form:errors path="age"/>
            </div> <br />
            
            <div>
            <label>List Of Vaccines</label>
            <form:select path = "requestedvaccines">						       
		<option>Covid-19</option>
		<option>Hepatitis B</option>
		<option>Meningitis</option>
		<option>HIV</option>
		<option>Varicella</option>
		<option>Diphtheria</option>
		<option>Measles</option>
		<option>Polio </option>
            </form:select>
            <form:errors path="requestedvaccines"/>
            </div>  <br />
            
            <div>
             <label>Phone Number</label>
             <form:input path="phoneNumber" type = "number" min = "1000000000" max = "9999999999" placeholder="Phone Number"/>
             <form:errors path="phoneNumber"/>
            </div>  <br />
            
            <div>
             <label>Address</label>
             <form:input path="requestedAddress" placeholder="Address"/>
             <form:errors path="requestedAddress"/>
            </div> <br />
            
            <div>
             <label>City</label>
             <form:input path="requestedCity" placeholder="City" />
             <form:errors path="requestedCity"/>
            </div> 
            
            <div>
               <c:if test="${!empty requestScope.err}">
                <p style="color:red">UserName already exists. Please select a unique username</p>
               </c:if>
            </div> <br />
            
            <div>
                <button>Register</button>    
            </div> <br />
          </fieldset>
       </form:form>   

    </body>
</html>
