<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
            p {
                color: #944e6c;
                font-size: 2rem;
            }
            
            button:hover {
                color: white;
                background-color: black;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
        <script>
            
            function accept(el) {
                var id = $(el).closest("tr").find('td:eq(0) input').val();
                alert("Accepted id : " + id);
                
                let url = 'acceptreq/' + id + '.htm';
                let data = 'id=' + id;
                
                $.get(url, function(id){ 
                    $(el).closest("tr").css("text-decoration", "line-through");
                    alert("Accepted!");
                }).fail(function(e) {
                    //alert('Error: ' + e);
                });
                
            }
        </script> 
    </head>
    <body>
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <p>Vaccine Provider :  ${sessionScope.donorsession.firstName } ${sessionScope.donorsession.lastName}</p>        
            <div><a href="${pageContext.request.contextPath}/donorhome.htm">Home</a></div>
            <div><a href="${pageContext.request.contextPath}/donorprofile.htm">View/Update Profile</a></div>
            <div><a href="${pageContext.request.contextPath}/requesterlogout.htm">Sign out</a></div> 
            <div><a href="${pageContext.request.contextPath}/donorReq.htm">My Requests</a></div> <br /> <br />
            <div><a href="${pageContext.request.contextPath}/viewallvaccinerequest.htm">All Requests</a></div>
            <div>
                <section>
                    <table border="1" cellpadding="5" cellspacing="5">
                        <tr>
                            <td><b>Advert ID</b></td>
                            <td><b>Date Posted</b></td>
                            <td><b>State</b></td>
                            <td><b>City</b></td>
                            <td><b>Vaccine</b></td>
                            <td><b>Message</b></td>
                            <td><b>Action</b></td>
                        </tr>
                        <c:forEach var="ra" items="${requestadvList}">
                        <tr>
                            <td style="display:none"><input type="text" value="${ra.advertid}"/></td>
                            <td>${ra.advertid}</td>
                            <td>${ra.dateposted}</td>
                            <td>${ra.state}</td>
                            <td>${ra.city}</td>
                            <td>${ra.vaccine}</td>
                            <td>${ra.message}</td>
                            <td><button id="acceptButton" type="button" onclick = "accept(this);" >Accept to donate</button></td>
                        </tr>
                        </c:forEach>
                    </table>
                </section>
            </div>
        </div>

    </body>
</html>