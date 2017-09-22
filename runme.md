# Project Title

NetTracer Coding Exercise

## Getting Started

### Configuration

There are two ways you can configure the application:

````
1. Navigate to the resource folder under source directory and modify array.txt file with comma delimited integers:
````
* src/main/resources/array.txt - Sample data: comma delimited integers - 1,5,7,10,15,17,20,10
````
2. Navigate to the resource folder under source directory and modify application.properties file and set random flag.
````
* src/main/resources/application.properties:
    - Sample data: init.k=3 - K Items Returned)
    - Sample data: init.kth - Kth Item Returned)
    - Sample data: random=y - ignores array.txt input)
    - Sample data: random.init=50 - Initializes an Array with 50 Integers)

### Execution

There are two ways to execute the application:

````
1. Go to command line, navigate to project folder.  type: mvn clean install spring-boot:run
````
* You will get the output based on the application properties set.
````
2. Go to command line, navigate to project folder.  type: mvn clean install
    wait for build to complete:
    Type: java -jar target/kitems-0.0.1-SNAPSHOT.jar (You will get the output based on the application properties set)
    Type: java -jar target/kitems-0.0.1-SNAPSHOT.jar k (k being the same value for K items and Kth item you want returned)
    Type: java -jar target/kitems-0.0.1-SNAPSHOT.jar k kth (K items and Kth item set separately)
````