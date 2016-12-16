# EsamuRFT Backend Server
University project for creating a game application.

## Synopsis
This repository's code just focuses on the backend server. It's a possible implementation of the requirements.

## Installation
This project has been written as a **maven** project. If you want to install it you will need Apache Maven installed on your computer.
The server uses **MongoD**B for the database layer, you'll also need it. (Modify the **Spring** Config, if you need it for the connection or something.)
+ First of all you have to compile the protobuf class, it will be in the generated-sources folder:
  + **mvn clean install -P compile-protos**
+ Then:
  + **mvn install**

Now, you can deploy it to an Application Server, or Tomcat. This server only uses HTTP servlets.

Developed and tested in Wildfly.

## Contributors
+ **Nagykéri Bence**
+ **Balogh István**
