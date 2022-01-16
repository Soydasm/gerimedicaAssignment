##GeriMedica Assignment
We would like you to write a small (yet realistic) application (that we expect would take roughly 1-2 hour to develop). 

###Conditions: 
* Use java & spring
* Use an in-memory database

### Goal:
The goal is to create an application that allows uploading and getting a csv file.
The sample csv file can be found [in the file named testData.csv][testData.csv]
The first line of the file are the headers!

Note: The field **code** is **unique**

#### REST API
The application allows interaction through a Rest endpoint that allows the user to:
* Upload the data
* Fetch all data
* Fetch by code
* Delete all data

The CodeController class contains the aforementioned endpoints. The methods body has to be replaced 
(as marked with `// TODO replace`)

#### Data storage:
Store the data to a database. The in memory database table will contain the fields as described on the csv file 
The in-memory database is configured in the application.yaml

#### Project structure:
This project contains a proposed project structure. Feel free to change it as you see fit.

### Submission 
Please provide the source code as a zip via email 
e.baluchova@gerimedica.nl  AND  a.nikoloutsos@gerimedica.nl

Good luck and have fun! 

[testData.csv]: testData.csv
