## General info
This folder contains the solution for the ninth homework. Solved/ unsolved tasks are checkmarked (:smile: / :confused:).

# The problem

Persistence
Continue the application from laboratory8, creating an object-oriented model and using JPA (Java Persistence API) in order to communicate with the relational database.

# NOTE
I used JAVA Spring framework to solve this tasks.

## Tasks (for laboratory9)
  * :smile: Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
  * :smile: Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
  * :smile: Create a singleton responsible with the management of an EntityManagerFactory object.
  * :smile: Define repository clases for your entities (at least one). They must contain the following methods:
    * :smile: create - receives an entity and saves it into the database;
    * :smile: findById - returns an entity based on its primary key;
    * :smile: findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
  * :smile: Test your application.

## Tasks (for homework9)
  * :smile: Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.
  * :smile: Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.
  * :smile: Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework. (I used the @Repository adnotation from Spring)
  * :smile: Insert, using JPA, a large number of fake artists and albums in the database and log the execution time of your JPQL statements. (The used statements are from Spring)
