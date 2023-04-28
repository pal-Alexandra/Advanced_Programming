## General info
This folder contains the solution for the eighth homework. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem

JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

## Tasks (for laboratory8)
  * :smile: Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
  * :smile: Write an SQL script that will create the following tables:
    * :smile: albums: id, release year, title, artist, genre(s)
    * :smile: artists: id, name (for example: Beatles)
    * :smile: genres: id, name (for example: Rock)
    *  :smile: an associative (junction) table in order to store each album genres
  * :smile: Update pom.xml, in order to add the database driver to the project libraries.
  * :smile: Create a singleton class in order to manage a connection to the database.
  * :smile: Create DAO classes that offer methods for managing artists, genres and albums (at least one).
  * :smile: Implement a simple test using your classes.
  
## Tasks (for homework8)

* :smile: Create an object-oriented model of the data managed by the Java application.
* :smile: Implement all the DAO classes.
* :smile: Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
* :smile: Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)
