Online Market Application

Steps to execute:

1. Place the contents into your directory on Tesla/machine. Open an instance of putty and login.

2. Run the make file to compile all *.java files using following command: make

3. Start the RMI registry using command: rmiregistry 2096& (where 2096 is the port that I've used for running my application)

4. Server is setup on Machine01(in-csci-rrpc01.cs.iupui.edu). Start the server on machine01 using the following command: % java -cp ".:mysql-connector.jar" -Djava.security.policy=policy MarketServer 
The server should be up and running now to accept client requests

5. Run the clients (multiple clients from machine02 to machine05) using the following command: %  java -cp ".:mysql-connector.jar" -Djava.security.policy=policy ApplicationStartup

Signup as a customer or Login on the screen

6. Try authenticating the user with the following username and passwords:
- For Admin:
userName: admin
password: admin
- For Customer:
userName: customer
password: customer
Database:
username: lmodi
password: lm3003
You should see separate screens for both admin and customer

7. Invalid authentication displays relevant message on client

8. All functionalities have been implemented successfully

9. Once you have completed this work please remember to clean up by terminating the RMI Registry. You 
   can bring this process to the foreground through the following command:
   % fg
   At which point you can kill the process.