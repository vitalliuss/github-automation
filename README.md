github automation
=================

C# and Java WebDriver test automation project for GitHub


Java
====
Newer version;

Added the DriverSetup class so that before and after each method the driver is 
created and destroyed. This was for ease of use at the personal level and can
be reverted to the older version easily. 

Added the GoogleCloud pages & test(Still in progress). In which like the older version it uses
data taken from a resource file and executes tests depending on the data provided and 
what methods, tests are executed.


Older version (Currently does not work due to a change at the TestDataReader);

Run from command line: mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=dev clean test

====


