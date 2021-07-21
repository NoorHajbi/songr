# songr

[Getting started with Spring](https://spring.io/guides/gs/serving-web-content/)

## Lab: 11 - Spring for Full-Stack Web Apps

1. `http://localhost:8080/` ->   
   will send you to **Home** page.
    

2. `http://localhost:8080/helloForm` ->   
will send you to **Form** page, that when you submit the form,
   it will redirect you to `http://localhost:8080/hello`,
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

1.  add the dependencies on postgres and JPA.
2. Update Album model so that it can be saved in a database.
3. A user should be able to see information about all the albums on the site.
4. A user should be able to add albums to the site.