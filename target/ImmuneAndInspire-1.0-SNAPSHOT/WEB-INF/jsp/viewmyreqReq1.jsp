<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

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
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script> 
            
            function deletereq(el, id) {
                $.ajax({
                    type: "GET",
                    url:  "deladonor/"+id+".htm",
                    data: "id=" + id,
                    success: function (response) {
                        $(el).closest("tr").remove();
                        $("#delreqbtn")
                            .show()
                            .html('<div style="color:red;position:absolute;margin:80px 600px" <strong>Record deleted Successfully</strong></div>')
                            .fadeOut(10000);
                        alert("Successfully Deleted!!");
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });  
            }
            
    </script> 
    </head>

    <body>
        <div>
            <h1><em>Immune And Inspire</em></h1>
            <div id="delreqbtn">
            </div>
            <div>
                <div><p> Vaccine Requester Full Name - ${sessionScope.requestersession.firstName } ${sessionScope.requestersession.lastName }</p></div>
                <div><a href="requesterlogout.htm">Sign out</a></li>
                <div><a href="${pageContext.request.contextPath}/viewreqprofile.htm">View Profile</a></div>
                <div><a href="${pageContext.request.contextPath}/requesterprofile.htm">Update Profile</a></div> 
                <div><a href="${pageContext.request.contextPath}/makearequest.htm">Make A Request</a></div>
                <div><a href="${pageContext.request.contextPath}/viewmyreqReq.htm">Request Status</a></div>
            </div>
        
        <h1>Your Vaccine Requests</h1>
        <div>Your total requests : ${fn:length(allReq)} </div>
        <table id ="dataTables-example">
            <thead>
                <tr>
                    <th>Request Id</th>
                    <th>Requested State</th>
                    <th>Requested City</th>
                    <th>Requested Vaccine</th>
                    <th>Message</th>
                    <th>Delete Action</th>
                    <th>View Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ra" items="${allReq}">
                    <tr>
                        <td>${ra.advertid}</td>
                        <td>${ra.state}</td>
                        <td>${ra.city}</td>
                        <td>${ra.vaccine}</td>
                        <td>${ra.message}</td>
                        <td><button type="button" onclick = "deletereq(this, ${ra.advertid});" >Delete Request</button></td>
                        <td><a href="viewadonor/${ra.advertid}.htm"><button type="button">View Donors</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
   <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
   <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
   
    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>

</body>

</html>
