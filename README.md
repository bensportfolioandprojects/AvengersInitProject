This project is my 2nd of 3 for the QA Software Engineering course. It included setting up a fullstack application using HTML, Java and Javascript, with CSS to style the frontend. I created a database with a table to store data, and also an API. As for the theme for the project I went with something I have knowledge in and a passion for and that is the Marvel Cinematic Universe.

Getting Started
The code has been compiled into a FatJar. You can open up the file from its location, and double click on the .jar file. You can also run java -jar Recipes.jar.

Prerequisites
You will need SQL Workbench to see the information in my sql-schema and sql-data files, though you can open these in your preferred IDE if you prefer. The testing aspect requires Junit and Mockito. gitBash required to build in bash or console.

Building
To form the code aspect, you can go into the AvengersInitiativeProject project, and open a gitBash terminal there. Enter "mvn clean package" to build the fatjar, and run with only the commands "java -jar ims-0.0.1-jar-with-dependencies". This will open my java executable in a console to interact with.

Testing
To run the tests, if you open the code in your an IDE and navigate to the top level of the src/test/java file. you can then "Launch java" and it will run the testing aspect of the project.

Unit and Integration Tests
All of the main files have been tested including the controller, domain, repos services classes and integration tests in the controllerTests class.

Tools Used
Jira - Kanban board and epic/stories visualisation - Link - https://bphillips96.atlassian.net/jira/software/projects/AV/boards/1/backlog?sprintCompleted
Maven - Dependency and Build Management
Git - Gitbash functionality for command line interface
Github - Repository management and integration with Jira for automatic Jira update
Bootstrap - varying HTML and CSS aspects of the project
Confluence - Additional pages for risk matrices and further documentation
MySQLWorkbench and Server
Mockito - Mocking dependencies for unit testing
Junit - Testing
PlantUML - UML creation

Acknowledgments
I would like to acknowledge the help given by the staff at QA, the assistance of my cohort and also any of the many fixes I found online through various sites such as stackoverflow.

Authors
Ben Phillips - Project and additional resources
This project is licensed under the MIT license - see the LICENSE.md file for details
