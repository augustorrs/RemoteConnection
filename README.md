# AUGUSTO SOUZA 2017376

# GITHUB ADDRESS

https://github.com/augustorrs/RemoteConnection

# CA 1

This source is to connect online mySQL database and get database content by query and add new data.
It is written using Java in Netbeans 8.0.2.
It is using mysql-connector-java-8.0.19.jar as external library to connect database.

## DESIGN PATTERN USED

1. Factory Method Pattern
It defines an interface or abstract class for creating an object but let the subclasses decide which class to instantiate.
Subclasses are responsible to create the instance of the class.
It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code.
That means the code interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends that abstract class.

2. Singleton Pattern
It defines a class that has only one instance and provides a global point of access to it.
A class must ensure that only single instance should be created and single object can be used by all other classes.
There are two types: Early Instantiation and Lazy Instantiation.

Source: https://www.javatpoint.com/

## HOW TO RUN SOURCE

1. Confirm that Netbeans is installed in your PC.
2. Download source code and open it in Netbeans.
3. Run source code.
4. It show several options and you can test each option. 

## USAGE

  Get all countries: 1,
  Get countries by code: 2,
  Get countries by name: 3,
  Add new country: 4,
  Exit: 5.

