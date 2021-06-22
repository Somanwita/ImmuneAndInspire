<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add Vaccine Page</title>
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
        <p>Vaccine Provider - ${sessionScope.donorsession.firstName } ${sessionScope.donorsession.lastName }</p>
            <div><a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a> </div>
            <div><a href="${pageContext.request.contextPath}/donorReq.htm">My Requests</a> </div>
            <div><a href="requesterlogout.htm" class="btn btn-default btn-flat">Sign out</a> </div>
            <div><a href="${pageContext.request.contextPath}/donorhome.htm">Home</a> </div>
            <br /> <br />
        <form:form role="form" action = "addvaccine.htm" commandName = "vaccine" method="post">    
           <fieldset>
                <legend> Add Vaccine</legend><br /> <br />
            
                <div>
                    <label>Vaccine Name</label>
                    <form:input path="vaccineName" placeholder="Vaccine name"/>
                    <form:errors path="vaccineName"/>
                </div> <br />
            
                <div>
                    <label>Vaccine Price</label>
                    <form:input type="number" path="vaccinePrice" placeholder="Vaccine Price"/>
                    <form:errors path="vaccinePrice"/>
                </div> <br />
        
                
                <button>Add Vaccine</button>    
           
          </fieldset>
       </form:form>   

    </body>
</html>

