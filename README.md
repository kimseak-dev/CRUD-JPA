# CRUD-JPA
basic crude using JPA using Hibernate and database mysql

# JPA = Java Persistence API

- [ ] Why is it come to be?
- [ ] Usually all application store the information in database + perform database related operations.
- [ ] Developer need a lot of work to connect to database and to save the classes into the right database table.
- [ ] JPA -> reduce the database related interactions significantly.
- [ ] Basically it has the ability to map java objects to relational models.

relation mode SQL   <————————————————————> object model (java classes)

The basic problem is that SQL and object oriented programming languages represent data in different way

- [ ] Relation objects in sql in represented in tables / tabular format
- [ ] Object in java are represented basically by a directed graph / object format
- [x] Because of this -> mismatches can occur

For example: Inheritance is not supported by relational database such as sql + object model has more granularity than relational model.

- [x] So what  is JPA?
- [x] It is a collection of classes and method that help developers to execute database related operations
- [x] For example: insert, remove, update table ….


# Before JPA

Java     	<—————————--———————————> 	||||||||||
Classes	<—————————————————————>     SQL table

		Lots of configurations and JDBC related code
		Why? To translate java object to SQL tables

# After JPA

Java   	 	——>		J P A		——>  	|||||||||| 
Classes		<——					<——        SQL tables


- [x] So JPA is going to manage everything for us ( it uses JDBC in the background)
- [x] We have to focus on business logic
- [x] We have to manipulate java classes and object
- [x] JPA will make the mapping between java object and relational database table


# JPA providers
- [ ] It’s very important -> JPA is a specification
- [ ] It defines the behavior with interfaces but without concrete implementations.
- [ ] JPA providers -> such Hibernate or EclipseLink -> define the concret implementation for the JPA specification
- [ ] So the persistence providers have the implementation classes for JPA specifications/
- [ ] Why its it good? Abstraction!!!
- [ ] 



# JPA Architecture

- [x] So we could use JDBC with native SQL commands
- [x] It would be much more convenient to use java object instead of manipulating relational database table
- [x] JPA solve this issue!!!


# javax.persistence

Entity Manager Factory		|			
Entity Transaction			|	——> 	|	JPA		| 	-—->	|	Entity 	|	—-->		SQL/MySql relation database  
EntityManager				|	<——	|			|	<——	|			|	<—--
Query					|
Persistence				|


- [x] EntityManager  factory —> a simple factory for EntityManager, helps to instantiate and manage multiple instance.
- [x] EntityManager —> a java interface,, defines persistence related operations on java objects.
- [x] Persistence  —> class containing static method to obtain EntityManagerFactory instance. 
- [x] Entity —> there are the persistence object. There are the records in the relational database.
- [x] Entity Transaction —> operations are maintained by this class


# Example 

public class Student {
	int id;
	String name;						<——> 	JPA	 	<——>  |id	|name	|age
	int age												      |1	| Joe		| 18
	...
}

Student s=  new Student(1, “Joe”, 18);

Don’t worry about java object and table it will be handled by Java Persistence API

- [x] Basically this is the object relational mapping  -> we have an orm.xml file that contains all the information or we can configure it via notation

- [x] Xml based configurations is faster  ———> xml does not require compilation
- [x] Annotations  ———> reflection in the background which is n to so fast
- [ ] So what is object relation mapping?
- [x] It is ability to convert data from object type to relational type and vice versa.
- [ ] So basically ORM bind / maps a java object to a database table
- [ ] It is highly stable
- [ ] Quite good in performance.


# We usually use annotations for configuration

- [ ] @Entiy  ——> declares the class as entity
- [ ] @Table ——> declares the table name
- [ ] @Id  ——> specifies the property, usually used for identify primary key of the table.

- [x] @Transient ——> this filed is not stored in the database
- [ ] OneToMany ——> relationship between jointed table
- [ ] ManyToMany


- [x] Why is it good? If we run our java code, it will generate the table in to database with the parameters we have configured via annotation!!!

@Table vs @Entity

- [ ] @Table is optional while @Enitity is needed

- [x] @Enity
class MyEntity{}

- [ ] In this case a table with name MyEntity will be created in the database 
- [ ] The entity name will be MyEntity as well JPQL query : select * from MyEntity 
- [x] @Enity(name = “my-entity-name”)
@Table(name = “my-entity-table-name”)
class MyEntity{
}

- [ ] A table with name my-entity-table-name  will be created in the database but 
- [ ] The entity name will be MyEntityName as well JPQL query : select * from MyEntityName


# CODING
 - create FOLDER META-INF -> create  persistence.xml
<?xml version="1.0" encoding="UTF-8"?>

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">
   <persistence-unit name="com.root.jpa" transaction-type="RESOURCE_LOCAL">
   	<provider>org.hibernate.ejb.HibernatePersistences</provider>
	<class>com.udemy.jpa.Student</class>
   	<properties>
   		<property name="hibernate.archive.autodetection" value="class"/>
   		
   		<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5InnoDBDialect"/>
   		<property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
   		<property name="hibernate.connection.url" value="jdbc:mysql://localhost/udemy"/>
   		<property name="hibernate.connection.user" value="root"/>
   		<property name="hibernate.connection.password" value="123"/>
   		<!-- It create table of each model auto if value is create if value is update if stable   -->
   		<property name="hibernate.hbm2ddl.auto" value="update"/>
   		
   		<property name="hibernate.show_sql" value="true"/>
   		<property name="hibernate.format_sql" value="true"/>
   		<property name="use_sql_comments" value="true"/>
   	</properties>
   </persistence-unit>
</persistence>


- [ ] Java persistence API is released with java specification
- [x] So of course it support all object oriented concepts -> such as hesitance
- [x] We can define relationship between entities
- [x] There are the 3 type of JPA inheritance strategies
- [ ] 1. Sigle_Table
- [ ] 2. Joint_Table
- [ ] 3. Table_Per_Concrete_Class




# EntityRelationship

- [x] OneToOne
- [x] OneToMan
- [x] Has A and Is A
This is object-oriented programming and UML terminology, not Java-specific. There are actually three cases you should be aware of:
1. A House is a Building (inheritance);
2. A House has a Room (composition);
3. A House has an occupant (aggregation).
The difference between (2) and (3) is subtle yet important to differentiate. Together they are forms of association. What's the difference? Composition implies the child object cannot live out of the context of the parent (destroy the house and rooms disappear) whereas aggregation implies the child can exist on its own (destroy the house and the occupant goes elsewhere).


- [x] public class Car extend Vehicle{ …}   is a relationship
- [x] public class Employee { private Address address}  has a relationship
- [ ] 

# JDBC

											JDBC API
											
										JDBC Driver Manager

JDBC Driver									JDBC Driver 						JDBC Driver	
	
     Oracle											SQL								MySQL
    
- [x] It stands for Java Database Connectivity
- [ ] Basically it is a database-independent connectivity between java programming language and a wide ranges of database
- [ ] It uses database specific drivers to connect to databases
- [x] DriverManager -> supports multiple concurrent driver that can be communicate with different database!!!


- [x] Driver Manager  manages several database drivers. Matches  connection requests  from the java application with proper database driver.
- [x] Driver interface that manages the connections with the database. We do not communicate with the driver directly
- [x] Connection  interface with all the method that needed for connecting database.
- [x] Statement we use statements in order to submit SQL statements to database.
- [x] ResultSet  this contain the data we have retrieved from the database after anSQL statement.

# Advantage
- [ ] Simple sql processing
- [ ] Very good performance with large datasets
- [ ] Convenient for small applications
- [ ] Quit simple syntax.

# Disavantage
- [ ] It can get very complex if we use it for large applications
- [ ] No encapsulation
- [ ] Quite hard to implement MVC concept with it.
- [ ] Not so convenient -> new technologies are developer friendly
- [ ] For example: JPA, Hibernate, EclipseLink
- [ ] 
# Memory Care

# Fetching

- [ ] JPA basic concept —> make a duplicate copy of the database in the cache memory
- [ ] We manipulate the duplicate version
- [x] When we call getTransaction().commit() —> this time the original database will updated according to changes.
- [x] We can load /fetch data form database 2 ways
- [ ] Eager fetch —> when we search for a record and find it, we return the whole record
- [ ] Lazy fetch  —> we  search for re cord and if we find it  —> we store the information that is available but do not return data. Data will be returned only we the setter method is called. For example getStudents(). Memory Friendly!!!

# Cascade
- [x] Use of the cascade annotation element can be used to propagate the effect of an operation to associated entities.
- [x] The cascade functionality us most typically used in parent-child relationship or in cases of composition.
- [ ]  

Author	  —————> Book
	 	  —————> Book
		  —————> Book
# What if we rid of author object? Of course we should remove the book object as we’ll
- [x] That’s why cascading com tube
1. CascadeType.PERSISTS ->  if persist() is called on the parent object, the child will be persist as well
2. CascadeType.REMOVE  -> child will be removed
3. CascadeType.MERGE -> child will be merged as well
4. CascadeType.REFRESH -> child will be refreshed as well.
5. CascadeType.ALL  -> all of the above mention!!!

# - [x] Explainations

EntityManager context
student1
Student 2
Student 3
If we call entityManager.persist() on a given object: I will be added to the context!!!

entityManager.detach(Student3) it will be detached —> it is removed from the context, the EntityManager no longer manages that given object.

# Why is it good? EntityManager can perform operation again such as refresh() and remove() 
 
- [ ] Merge VS persist: both of them add the given entity to the context
- [ ] Persist: future updates will be tracked
- [ ] Merge: a new instance is created with the copied state and this instance will be managed by EntityManager. So any changes made the original object will not be part of transaction. Ok we can merge again!!!
- [ ]  





     
																



		







