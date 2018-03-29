JCC = javac
	
compile:
	$(JCC) -cp ".:mysql-connector.jar" *.java
	
clean:
	$(RM) *.class