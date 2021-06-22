<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div>    <br />
            <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a></div>
  
        <form:form role="form" action="postrequest.htm" method="post" commandName = "makerequest">
            <fieldset>
                <legend>Post request for vaccination:</legend>
                <br />

                <div>
                    <label><b>State</b></label>
                    <select name = "state">
                        <option>Massachusetts</option>
                        <option>New Hampshire</option>
                        <option>New York</option>
                        <option>Maine</option>
                        <option>New Jersey</option>
                        <option>North Carolina</option>
                        <option>South Carolina</option>
                        <option>Florida</option>
                        <option>California</option>
                        <option>Arizona</option>
                        <option>Illinois</option>
                        <option>Rhode Island</option>
                        <option>Pennsylvania</option>
                    </select>
                </div>  
                
                
                <div>
                    <label><b>City</b></label>
                    <select name = "city">
                        <option>Boston</option>
                        <option>New York</option>
                        <option>New Jersey</option>
                        <option>Miami</option>
                        <option>Washington</option>
                        <option>Phoenix</option>
                        <option>San Jose</option>
                        <option>Chicago</option>
                        <option>New England</option>
                    </select>
                </div> 
                
                
                <div>
                    <label><b>Vaccine name</b></label>
                    <select name = "vaccine">
                        <option>Covid-19</option>
                        <option>Hepatitis B</option>
                        <option>Meningitis</option>
                        <option>HIV</option>
                        <option>Varicella</option>
                        <option>Diphtheria</option>
                        <option>Measles</option>
                        <option>Mumps</option>
                        <option>Rubella</option>
                        <option>Polio</option>
                    </select>
                </div> 
                <div>
                    <div>
                        <label><b>Message : </b></label>
                        <input type = "text" name = "message" placeholder = "message"/>
                    </div> <br />
                    <button type="submit">Post A Request</button> 
                </form:form>
            </div>
    </body>
</html>