Prerequisites
=======
Install MongoDB
Install Maven

To run
=======
mvn clean install
mvn spring-boot:run

Migrations
=======
Eager migrations can be found in the migrations package.

Test Data
=======
CreateLotsOfPeople populates fake people into Mongo DB with unique IDs and random combinations of first and last names.

Sample JSON
=======
{
  "_id":"1000000001",
  "firstName":"Albus",
  "lastName":"Dumbledore",
  "wearsGlasses":true,
  "username":"dumbledore"
}

Lunch And Learn Tasks
=======
** Implement Update for PersonController (with tests)
** Implement Search for PersonController (with tests)
** Ensure an index is unique (username in Person)
** Write an integration test for unique username
** Do a migration via Java (add sibling field to Person)
** Return a person's siblings