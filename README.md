# Metis ~ todo List Java

This project creates an todo List in Java using swing which is connected to a MySQL Database.

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
    task MEDIUMTEXT,
);
```
The last thing we need to set up is pom.xml . Simply copy paste the below code into pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>TODO_LIST</groupId>
   <artifactId>TODO_LIST</artifactId>
   <version>1.0-SNAPSHOT</version>
   <packaging>jar</packaging>
   <dependencies>
      <dependency>
         <groupId>org.netbeans.external</groupId>
         <artifactId>AbsoluteLayout</artifactId>
         <version>RELEASE120</version>
      </dependency>
      <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.27</version>
      </dependency>
   </dependencies>
   <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <maven.compiler.source>11</maven.compiler.source>
      <maven.compiler.target>11</maven.compiler.target>
   </properties>
   <build>
      <plugins>
         <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
         <plugin>
            <!-- Build an executable JAR -->
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.1.0</version>
            <configuration>
               <archive>
                  <manifest>
                     <addClasspath>true</addClasspath>
                     <classpathPrefix>lib/</classpathPrefix>
                     
                     <mainClass>Todo_List.DatabaseOperation</mainClass>

                  </manifest>
               </archive>
            </configuration>
         </plugin>
      </plugins>
   </build>
</project>

```
Now we're ready to go
## Usage
Change the directory to the root (i.e. where pom.xml is) and write the following commands
```bash
mvn compile
mvn exec:java -Dexec.mainClass=Todo_List.Todo
```
