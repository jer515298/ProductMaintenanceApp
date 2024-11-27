Changes Made to the Application
1.	Database Integration:
o	The application now uses a MySQL database named music with a Products table. The Product class and database structure align with JPA entity annotations.
o	Example data is inserted into the Products table to match assignment requirements.
2.	SSL and Authentication:
o	Added secure connection (HTTPS) for all pages except the home page (index.html).
o	Configured Tomcat's server.xml to enable SSL on port 8444.
o	Defined roles (programmer and customer_service) and users in the tomcat-users.xml file to restrict access to secure pages.
3.	web.xml Configuration:
o	Updated the deployment descriptor to define servlet mappings and session timeout.
o	Added security constraints to restrict access to specific roles.
4.	Project Build:
o	Configured Maven to compile the project and generate the .war file for deployment.
o	Verified that the application builds and runs with no missing dependencies.
________________________________________
What the Team May Need to Do to Get it to Run on your computer
1.	Tomcat Configuration:
o	Ensure tomcat-users.xml includes the roles and users specified (e.g., programmer, customer_service, user1, user2) with the correct usernames and passwords.
2.	Database Setup:
o	Create a music database with a Products table matching the structure in the Product entity class.
o	Insert sample data into the Products table if you want test data available immediately.
3.	SSL Configuration:
o	Verify that SSL is enabled in Tomcat and the server.xml file includes the correct keystore details.
o	If you don’t have the keystore.jks file, generate one or update the SSL configuration to match your environment.
4.	Application Deployment:
o	Build the project using Maven and deploy the generated .war file to the Tomcat webapps directory.
o	Restart Tomcat to deploy the application.
5.	Access the Application:
o	Use the URL for unsecured pages: http://localhost:8080/product-maintenance/.
o	Use the URL for secure pages: https://localhost:8444/product-maintenance/ProductServlet?action=list.
o	Login credentials:
	Username: user1, Password: password1 (programmer role)
	Username: user2, Password: password2 (customer service role)
  Here is my tomcat-users.xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements. See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License. You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<tomcat-users xmlns="http://tomcat.apache.org/xml" 
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
              xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd" 
              version="1.0">

    <!-- Built-in manager roles -->
    <role rolename="manager-gui"/>
    <role rolename="manager-script"/>
    <role rolename="manager-jmx"/>
    <role rolename="manager-status"/>
    
    <!-- Application-specific roles -->
    <role rolename="programmer"/>
    <role rolename="customer_service"/>

    <!-- Users with assigned roles -->
    <user username="admin" password="changeme" roles="manager-script,admin"/>
    <user username="user1" password="password1" roles="programmer"/>
    <user username="user2" password="password2" roles="customer_service"/>
</tomcat-users>
