# java-project
Java project which track the system info : CPU , RAM and uptime

# install the java
    - sudo apt update
    - sudo apt install openjdk-11-jdk
    - java -version

#  install the maven
    - sudo apt install maven -y
# install the dependency
    - mvn clean install
# Compile the and run the projects
    - mvn clean compile exec:java
# projects
    mvn archetype:generate -DgroupId=com.one2n.com -DartifactId=Helloworld -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DinteractiveMode=false


mvn clean test
 mvn
 mvn -v
 echo $JAVA_HOME
 mvn clean test
 mvn -v
 mvn package
 java -cp target/Helloworld-1.0-SNAPSHOT.jar com.one2n.com.App


 commands
 mvn clean
 mvn install 
 mvn compile 
 mvn test
 

 mvn checkstyle:check # Run Checkstyle to check the code against the rules:
 mvn spotless:apply # Run Spotless to apply formatting rules and auto-fix issues: