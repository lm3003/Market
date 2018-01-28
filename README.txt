Online Market Application

The server file is MarketServer.java and the client file is MarketClient.java

Steps to execute:

1. Place the contents into your directory on Tesla. Open an instance of putty and login.

2. Run the make file to compile all *.java files using following command: 'make'

3. Start the RMI registry using command: 'rmiregistry 2096&' (where 2096 is the port that I've used for running my application)

4. Start the server using the following command: 'java -Djava.security.policy=policy MarketServer'. 
The server should be up and running now to accept client requests

5. Run the client using the following command: 'java -Djava.security.policy=policy MarketClient'. 
The client pokes the server and server responds back with the message 'Hello Client'

6. Once you have completed this work please remember to clean up by terminating the RMI Registry. You 
   can bring this process to the foreground through the following command:
   % fg
   At which point you can kill the process.