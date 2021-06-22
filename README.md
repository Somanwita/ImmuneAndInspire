# ImmuneAndInspire

# Summary:
The goal of the web application is :-

* To make it easy for general public to find vaccine providers in a location and enroll for
vaccine.
* To make it easy for vaccine providers to register on a common platform accessible to
consumers and provide information about their vaccine.
* To make it easy for vaccine providers to track vaccination requests and schedule them.

The web app can be used by anyone who is interested to enroll for vaccine as well as the
organizations providing them.

The motivation for building the app is to provide a common platform for vaccine consumers and
providers . I think it would be valuable to have a common platform in current pandemic as there
are multiple organization working to provide vaccine for Covid-19.

# Functionalities:

* On the launch page, user see three options - Donor Registration and Requester
Registration and Login.
* Users can register themselves as Provider or Requester respectively. Username should be
unique for all users. Later they can login with username and password.
* Requester and Provider can update or view their profile.
* Provider can add vaccines along with its price. Vaccine with same name cannot be added
twice.
* Requester can create request for vaccination with necessary details.
* Provider can view a list of requests for vaccination and can choose from them and Accept
to donate vaccine.
* Requester can see all the requests made my himself/herself, delete any of the requests.
* Requester can see if any provider has accepted his/her request.
* If Provider accepts a request, its status gets updated to Request Accepted.
* Consumer can see the provider details and a confirmation for vaccination in PDF format.
* All the Login and Registration validations are taken care and all the fields made
mandatory during Login and Registration using Validators and JSTL core tags.
* Used inceptors to handle script injection.
* Handled SQL injection.
* Used Ajax for Single Page services.

# Technology stack:

* Spring MVC
    * Simple Form Controller
    * Validator
    * Interceptor
    * Abstract Pdf View
    * Hibernate
    * JSTL Tag Library
    * Ajax

# User Roles and performed tasks for each role:

* Vaccine Provider:
    * Users submit Donor Registration form to get registered as a Vaccine Provider, where
    they provide all the details like - First Name, Last Name, Password, Email, Gender,
    Age, Vaccine Name, Phone Number, Address, City.
    * User can login with username (i.e. firstname) and password.
    * Provider can view or update their profile.
    * Provider see the list of requested vaccines in All requests section and from that list
    they can choose and Accept to donate vaccine.
    * Once one provider accepts a request, that request is removed from All requests
    section and My requests section for that provider gets updated. The status of the
    requests is changed to “Request Accepted”.
    * Provider can update the status of the request to Request Completed if vaccination is
    done.
    * Provider can update the request status as Request Cancelled if the requester does not
    come for vaccination within 7 days of accepted date.
    * Vaccine provider can add name and cost of vaccine in Add Vaccine section.

* Vaccine Requester:
    * Users submit Requester Registration form to get registered as a Vaccine Requester,
    where they provide all the details like - First Name, Last Name, Password, Email,
    Gender, Age, Vaccine Name, Phone Number, Address, City.
    * User can login with username (i.e. firstname) and password.
    * Vaccine requesters can create new request for vaccine providing some details like
    requested city, requested state, requested vaccine and some additional message for the
    provider.
    * Requester can see the all the vaccine requests created by him/her in All Requests link.
    * Requester can delete request from that list.
    * For all the requested vaccines, requester see if any provider accepted his/her request
    when he/she clicks on “View Donor”. If no provider accepts the request, they get a
    message like “No producer has accepted your request yet.”
    * Otherwise, if any provider accept his/her request, requester can see the provider
    details when they click “View Donor”.
    * Once request is accepted by donor, one confirmation document is generated in pdf.
    The requester should bring that confirmation on the time of vaccination.
    * The confirmation pdf contains information about the Request Accept Date, Provider
    Name, Requested Vaccine, Estimated Costs etc. with some guidelines about
    vaccination.
    * The vaccination confirmation is valid for 7 days from the accepted date.
