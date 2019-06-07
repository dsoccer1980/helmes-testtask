
# Testtask

Used stack: Spring Boot, Spring Data JPA, PostgreSql<br><br>

Before program is executed, database in PostgreSql should be created. <br>
Database dumb is attached with file helmesdb.backup  <br><br>
Currently specified settings. <br>
database name:helmesdb <br>
username: postgres <br>
password: postgres <br>
They can be changed in file application.yml <br>

The task:
1. Correct all of the deficiencies in index.html <br>

2. "Sectors" selectbox: <br>
 2.1. Add all the entries from the "Sectors" selectbox to database <br>
 2.2. Compose the "Sectors" selectbox using data from database <br>

3. Perform the following activities after the "Save" button has been pressed:  <br>
 3.1. Validate all input data (all fields are mandatory) <br>
 3.2. Store all input data to database (Name, Sectors, Agree to terms) <br>
 3.3. Refill the form using stored data  <br>
 3.4. Allow the user to edit his/her own data during the session <br>
