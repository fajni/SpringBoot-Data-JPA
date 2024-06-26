## Questions

1. What is ORM?<br/><br/>

2. What is JPA? <br><br>

3. What is JPQL? <br><br>

4. Explain Mapping Rule in JPA. <br><br>

5. What is the difference between JPA and Hibernate?<br><br>

6. What are some advantages of using JPA?<br><br>

7. What is the Spring Data (or) Spring Boot Data JPA repository?<br><br>

8. What is the difference between PagingAndSortingRepository and JpaRepository?<br><br>

9.  What are pre-defined methods given by Repository interfaces?<br><br>

10. What is Entity class and Explain commonly used annotations for this?<br><br>

11. What is the naming convention for finder methods in the Spring Data repository interface?<br><br>

12. How can we create a custom repository in Spring Data JPA?<br><br>

13. What is PagingAndSortingRepository?<br><br>

14. What is @Query used for?<br><br>

15. What type of Queries can be implemented using @Query annotation?<br><br>

16. Give an example of using @Query annotation with JPQL?<br><br>

17. What are Collection Mappings Supported by JPA?<br><br>

18. What is PlatformTransactionManager?<br><br>

19. How can we enable Spring Data JPA?<br><br>

20. Differentiate between findById() and getOne()?<br><br>

21. What is the use of Dialect and give some examples?<br><br>

22. What is FetchType in JPA?<br><br>

23. What is the default FetchType in JPA?<br><br>

24. How can we see generated SQLS console/Log Files?<br><br>

25. What are different types of Joins supported by JPA? <br><br>

26. Provide both SQL and JPQL/HQL Joins Syntax?<br><br>

27. ...

## Answers

1. ORM stands for Object Relational Mapping. It's a technique used in creating a "bridge" between object-oriented programs and relational database. (Technique that connects our Java application to relational database.)<br/>
It's mainly used for Database Operations. Every operation (save, update, delete, select) needs to be in Object format <br/><br/>

2. JPA (_Java Persistence API_) is one of the ORM Specification. To simplify, ORM is a theoretical concept and JPA is a programmatic concept. <br>
   Used to persist data between the relational databases and Java objects. It acts as a bridge between java classes and relational databases. <br><br>

3. JPQL provides a way to write queries to execute seaches against entities. It is different from SQL queries, and JPQL queries understand the mapping that is defined between entities. <br>
   JPQL/HQL query is written by the class and variable name rather than Database Table Name and Column Name.<br>
   (SQL queries over classes, not tables.)<br><br>

4. We define Entity class for One Table. (Mapping class with a Table. One Java Class will be conected to One Table, such class is called Entity that is mapped with database Table). We define One Variable for One Column (4 variables, 4 columns). <br>
   Then One Object is converted into One Row (even reverse).<br><br>

5. Hibernate is a JPA implementation.

6. Database Independent. (example: Moving from Oracle to MySQL JPA code works as usual.)<br>
   Easy to develop database operations. (most queries are generated by jpa, but you can write you own queries.).<br>
   JPQL (specification) / HQL (implementation) support.<br>
   Type (Datatypes) and Parameter Handling. (you dont bother about the database data types since there's auto mapping)<br><br>

7. You just extend interface and use oprations. There are mainly 3 Spring Data / Spring Boot Daja JPA repository (they are all interfaces, and their implementation class is generated by Spring Boot):
      - CrudRepository
      - PagingAndSortingRepository
      - JpaRepository
<br><br>

8. JpaRepository works only for relational databases. PaggingAndSortingRepository and CrudRepository work for both SQL and NoSQL databases.<br><br>

9. There are methods like: save(), delete(), findById(), findAll(), deleteById(), count(), ... <br><br>

10.  Entity class is a class mapped with Database Table (1 Class 1 Table). We can also call it as POJO (Plain Old Java Object) class. It must be mapped with Database table using JPA annotations such as @Entity, @Table, @Id, @Column, ...etc <br><br>

11.  The Naming convention of finder Method is predefined keyword followed by variable name in Java class. (example: `List<Person> findByLastName(string lastName)`, this will generate query internally, we don't have to write any queries here, findBy - to construct WHERE condition in query).<br><br>

12.  We can create custom repository by extending any one of the next interface: JpaRepository, CrudRepository, PagingAndSortingRepository, Repository (this is a empty repository that doesn't have any operations. Used if you want to create your own custom select, delete, etc operations)<br><br>

13.  PaginAndSortingRepository, by using this repository, we can sort the data(asc/desc). Also, we convert the record or print the record in page by page (Pagination), if you want to fetch data page by page. This repository extends CrudRepository. <br><br>

14.  @Query annotation is used to write custom query or user/programmer defined query. To create you own query that is not present in the given repositories. You can write both JPQL and native SQL query. <br><br>

15. By using @Query annotation we can write both select and non-select (update/delete, but not insert?) operations. But when we are using @Query with Update or Delete, we should also specify @Modifying annotation.
    <br> By using @Query we can write both JPQL and native SQL query (database dependent query). <br><br>

16. Based on the employee name fetch the data from the databse:<br> 
    <pre>
      @Query("SELECT e FROM Employee e WHERE e.name = ?1")
      List<Employee> getEmployeeByName(String name);
    </pre>
    Must define inside our Repository interface and must be abstract method.<br>
    Employee is a class, and name is property name inside Employee class.
   <br><br>

17. JPA supports collections like List, Set and Map. We need to add @ElementCollection over variable.<br>
When using element collection (__List/Map Collections__), that is going to create child table with 2/3 columns:
      - Key Column: Foreign Key Column,
      - Index Column: Position of value in collection,
      - Element Column: Actual Data of Collection.<br><br>
For __Set Collection__, table is created with 2 columns (Key, Element).
<br><br>

18. PlatformTransactionManager is an interface that extends TransactionManager (used to handle transactions). It enables @Transactional annotation which does commit in case of success and Rollback in case of Exception/Failed.
<br><br>

19. Spring Boot comes with Auto Configuration, if add Spring Data JPA Dependency in dependency file. (spring-boot-started-data-jpa).<br>
We must write some configuration in application.properties, like Database connection details and JPA details.<br><br>

20. findById() and getOne() are both used to fetch one row based on the primary key.<br>
findById() method present in CrudRepository where as getOne() method present in JpaRepository.<br>
If data is not found in findById() method then it will return null, means its return type is `Optional<T>` class. If data is not found in getOne() method, it will throw an exception called EntityNotFoundException.
<br><br>

21. Dialect is a class defined in JPA. All SQL queries are generated by Dialect. It generates SQLs at runtime based on our operations (method class). Like on calling save(), generated INSERT... SQL.<br>
If we move from one Database to another Database, Dialect property needs to be modified in properties file.

22. FetchType is used for SELECT operations used for Association Mappings or Collection Mappings. (example: Do you want to fetch Parent along with the Child data, do you want to fetch only Parent data from the tables).<br>
FetchTypes are:
      - EAGER (Loads Parent Entity along with its associate Child Entities)
      - LAZY (Loads only Parent Entity)
<br><br>
  Both are for SELECT operation.

23. There is not specific default value for FetchType. It depends on operation we do.
<br>
LAZY for: one-to-many, many-to-many, and also for ElementCollection.<br>
EAGER for: one-to-one, many-to-one.
<br><br>

24. Data JPA by default generated SQL and it will not be shown. To view them add property: `show-sql=true` in properties file. `spring.jpa.show-sql=true` <br><br>

25. INNER JOIN | JOIN (gets commonly connected rows from both tables).<br>
OUTER JOIN:
       - LEFT OUTER JOIN | LEFT JOIN (gets all rows from Left side table and connected rows from Right side table),
       - RIGHT OUTER JOIN | RIGHT JOIN (gets all rows from Right side table and connected rows from Left side table)
       - FULL OUTER JOIN | FULL JOIN (gets all rows from both side)
<br><br>

26. SQL Syntax: <br>
`SELECT <columns> FROM <ParentTable> <p>`<br>
`[JOIN TYPE]`<br>
`<ChildTable> <c>`<br>
`ON <p>.<PK> = <c>.<FK>`<br>
`WHERE <Condition>`<br><br>
JPQL/HQL Syntax:<br>
`SELECT <variables> FROM <ParentClass> <p>`<br>
`[JOIN TYPE]`<br>
`<p>.<HasAVariable> AS <c>`<br>
`WHERE <Condition>`<br><br>

27. 

##

Basic questions about Spring Boot Data JPA.

Credits: <a href= "https://www.youtube.com/watch?v=pAYKEIzlHmI"> Ashok IT</a>