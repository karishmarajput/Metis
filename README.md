# Metis ~ todo List Java

This project creates an todo List in Java using swing which is connected to a MySQL Database.
## Implementation
### Insert
Insert a new task in your todo list.<br>
<img src="https://github.com/karishmarajput/Metis/blob/8d3f8d9aaf52779feadc39a6ab3d7ddcfa375935/todo1.png">

### Delete
Delete a specific task from your todo list.<br>
<img src="https://github.com/karishmarajput/Metis/blob/8d3f8d9aaf52779feadc39a6ab3d7ddcfa375935/todo2.png">

### Delete All
Delete all the task from your todo list.<br>
<img src="https://github.com/karishmarajput/Metis/blob/8d3f8d9aaf52779feadc39a6ab3d7ddcfa375935/todo3.png">

## Installation
For running this project you will be needing [Maven](https://maven.apache.org/). Click here to [download](https://maven.apache.org/download.cgi)

Clone this repo into a folder with the following directory structure

```bash
.
    TODO_LIST 
          ├───pom.xml
          │
          │
          ├───lib
          │       mysql-connector-java-{version}.jar
          │
          ├───src
          │   ├───main
          │   │   └───java
          │   │       └───Todo_List
          │   │               .gitignore
          │   │               Todo.form
          │   │               Todo.java
          │   │               Credentials.java
          │   │               DatabaseOperation.java
          │   │               User.java                                    
          │   │               README.md
          │   │             
```
You can download the mysql-connector from [Maven Repository](https://mvnrepository.com/artifact/mysql/mysql-connector-java/)

The Credentials.java file contains all the credentials to connect to MySQL. Here is a demo

```java
package Todo_List;

public class Credentials {
    public static final String SQL_USERNAME = "username";
    public static final String SQL_PASSWORD = "password";
    public static final String SQL_URL = "jdbc:mysql://host:port/todo";
}
```
Now we have to create a database and table. For that we have to open mysql in the command line. Now we create the database.
```sql
CREATE DATABASE todo;
```

Now we create the table.

```sql
USE todo;
CREATE TABLE task (
    task MEDIUMTEXT
);
```


Now we're ready to go
## Usage
Change the directory to the root (i.e. where pom.xml is) and write the following commands
```bash
mvn compile
mvn exec:java -Dexec.mainClass=Todo_List.Todo
```
