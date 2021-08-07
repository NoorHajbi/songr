# songr


## Lab: 11 - Spring for Full-Stack Web Apps

1. `http://localhost:8080/` ->   
   will send you to **Home** page.


2. `http://localhost:8080/helloForm` ->   
   will send you to **Form** page, that when you submit the form, it will redirect you to `http://localhost:8080/hello`,
   That includes **Hello, ${name}!**.


3. `http://localhost:8080/hello/${name}` OR
   `http://localhost:8080/hello?name=${name}` ->   
   Includes **Hello, ${name}!**.


4. `http://localhost:8080/capitalize/{capitalizeME}` ->  
   will show you words in UpperCase.


5. `http://localhost:8080/albums` ->  
   will send you to a page with three Albums.
   

---

## Lab: 12 - Spring and REST

1. add the dependencies on postgres and JPA.

```
    dependencies {
	compile 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation('org.springframework.boot:spring-boot-starter-thymeleaf')
	implementation('org.springframework.boot:spring-boot-starter-web')
	runtimeOnly('org.postgresql:postgresql')
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}
```
  
2. When the dependencies on postgres and JPA are added, The app will stop working until we have the configuration
   in `application.properties` to access your Postgres database.
   
```
spring.datasource.port=8080 spring.datasource.url=jdbc:postgresql://localhost:5432/`dbname`
spring.datasource.username=`username`
spring.datasource.password= `password`
spring.jpa.database=POSTGRESQL spring.jpa.show-sql=true spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
   ```
     
3. Update Album model so that it can be saved in a database.
     

4. A user should be able to add albums to the site.

   `http://localhost:8080/addAlbum` ->  
   Form page, for adding Album to DB.
       
 
5. A user should be able to see information about all the albums on the site.


6. Error Page, steps:
- `server.error.whitelabel.enabled=false` ->
  Adding this the `application.properties` file,
  will disable the error page and show a concise page that originates from the underlying application container.
  
- Create a custom HTML error page, `error.html`. 
  If we save this file in resources/templates directory,
  it'll automatically be picked up by the default Spring Boot's BasicErrorController.
  
- Create a custom ErrorController.

---
## Lab: 13 - Related Resources and Integration Testing

1. **Song** model, has a title, a length, a trackNumber, and the album on which that song appears.
2. A user sees information about all the songs on the site.
3. A user is able to view a page with data about one particular album.
4. A user is able to add songs to an album.
5. A user is able to see the songs that belong to an album when looking at that album.

`http://localhost:8080/addSong` ->  
   Form page, for adding Song to DB.

`http://localhost:8080/songs` ->
   will send you to a page with added Songs.

---
## Lab: 14 - Related Resources and Integration Testing

Resources
[jBCrypt](https://www.mindrot.org/projects/jBCrypt/)
Update your server to protect a secret recipe by requiring users to sign up for an account and log in. Users should only be able to see the recipe after they’ve logged in and established an authenticated session.

Create this authentication system on your own. Do not use Spring’s own built-in auth system.

Display a user’s username somewhere on the page to indicate to a user that they’re logged in.

Use Bcrypt to hash and check user passwords. Make sure not to return user’s passwords or their hashes, if you return user information in the response to any request.

Feature Tasks
Create a database
Create a table that models users with a username, id, and hashed password.
Create a table that models posts with a postId, userId and text content.
Create a table with a 1-to-many relationship between users and posts.
Authenticate the site so only logged-in users can see posts.
Use Bcrypt to hash all passwords stored on the site.
Submission Instructions
Continue working in your repository for the first 5 Spring labs.
Work on a non-master branch and make commits appropriately.
Ensure that you can run a single Gradle command to launch your server. Include that command in a README.md file.
Create a pull request to your master branch with your work for this lab.
Submit the link to that pull request on Canvas. Add a comment with the amount of time you spent on this assignment.
Grading Rubric
2 pts for proper use of bcrypt to hash passwords 2 pts for proper handling of login and sign up routes 1 pt for displaying logged-in user information 1 pt for README

---

### Resources:
1. [Getting started with Spring](https://spring.io/guides/gs/serving-web-content/)
2. [Spring initializr](https://start.spring.io/)
3. [How To Install and Use PostgreSQL on Ubuntu 20.04](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-20-04)
4. [Spring Boot: Customize Whitelabel Error Page](https://www.baeldung.com/spring-boot-custom-error-page)
