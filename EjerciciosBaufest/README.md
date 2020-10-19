# BaufestExcercises

1. This automation project has been created over MacOS so if you want to execute the web 
automation section you must change the "chromedriver" (src/main/resources/Driver/chromedriver) for the 
appropiate as your OS needs.

2. This automation project uses JAVA 11 version if you have another version installed 
you need to change your IDE configurations:
 - Go to Preferences/Build, Execution, Deployment/Compiler/Java Compiler and change java version as your OS uses.
 - Go to Proyect Structure/Project and change java version as your OS uses (also apply for Proyect Structure/Modules).

##Web
For the execution of web section you must run "Runner" java class (src/test/java/web/run/Runner.java)

##API
For the execution of api section you must run "APIRunner" java class (src/test/java/apis/run/APIRunner.java)

##Upcoming Updates
1. Use a Manager for create just one instance for new page object (singleton)
2. Use Hooks java class for web or api pre-conditions initiation
3. Use a configuration.properties file for set implicit or explicit wait values, set enviroment, kind of driver or driverPath, etc.
4. Create a testDataResources for json data and schema validation.