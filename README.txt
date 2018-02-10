Online Market Application

Steps to execute:

1. Place the contents into your directory on Tesla. Open two instances of putty and login (for client and server).

2. Run the make file to compile all *.java files using following command: % make

3. Start the RMI registry using command: % rmiregistry 2096& (where 2096 is the port that I've used for running my application)

4. Start the server using the following command: % java -Djava.security.policy=policy MarketServer 
The server should be up and running now to accept client requests

5. Run the client using the following command: % java -Djava.security.policy=policy ApplicationStartup.
Login view is displayed on the screen

6. Try authenticating the user with the following username and passwords:
- For Admin:
userName: admin
password: admin
- For Customer:
userName: customer
password: customer
You should see separate screens for both admin and customer

7. Invalid authentication displays relavant message on client

8. Once you have completed this work please remember to clean up by terminating the RMI Registry. You 
   can bring this process to the foreground through the following command:
   % fg
   At which point you can kill the process.