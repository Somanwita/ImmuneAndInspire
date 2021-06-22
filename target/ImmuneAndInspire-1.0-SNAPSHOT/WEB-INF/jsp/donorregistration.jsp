<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Donor Register Page</title>
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
            }
           
        </style>
    </head>
    
    <body>
        <h1><em>Immune And Inspire</em></h1>
        <form:form role="form" action = "donorregister.htm" commandName = "donor" method="post">    
           <fieldset>
                <legend>Vaccine Provider Registration </legend>
            
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
                    <form:password path="password" placeholder="Password"/>
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
                    <form:input path="age" type = "number" min = "1" max = "100" placeholder="Age"/>
                    <form:errors path="age"/>
                </div> <br />
            
                <div>
                    <label>List Of Vaccines</label>         
                    <form:select path = "vaccine">						       
                        <option>Covid-19</option>
		        <option>Hepatitis B</option>
		        <option>Meningitis</option>
		        <option>HIV</option>
		        <option>Varicella</option>
		        <option>Diphtheria</option>
		        <option>Measles</option>
		        <option>Polio </option>
                    </form:select>
                    <form:errors path="vaccine"/>
                </div> <br />
            
                <div>
                    <label>Phone Number</label>
                    <form:input path="phoneNumber" type = "number" min = "1000000000" max = "9999999999" placeholder="Phone Number"/>
                    <form:errors path="phoneNumber"/>
                </div> <br />
            
                <div>
                    <label>Address</label>
                    <form:input path="address" placeholder="Address"/>
                    <form:errors path="address"/>
                </div> <br />
                
                <div>
                    <label>City</label>
                    <form:input path="city" placeholder="City"/>
                    <form:errors path="city"/>
                </div> 
            
                <div>
                    <c:if test="${!empty requestScope.err}">
                        <p style="color:red">Username already exists. Please select a unique username.</p>
                    </c:if>
                </div> <br />
                
                <button>Register</button>    
           
          </fieldset>
       </form:form>   

    </body>
</html>
