### Sentiment Analysis Spring-Boot Application using Aylien Text API and JSoup

### Steps to compile and run the app:-
    Compile - mvn -e -X clean install
    Run - mvn spring-boot:run

- The application is built with Spring-Boot 1.5.9.RELEASE, Hibernate 5.0.12.Final with MySQL, and uses Embedded Tomcat as REST Server.
- The application uses dependencies JSoup for HTML/DOM Parsing, and Aylien text-parsing/sentiment analysis API as suggested in the interview.

Once you run the application, the REST Endpoints and their responses that were executed in the Interview are below -

### POST Request:- 
`http://localhost:8080/data`

### Request Body:
```java
{
  "url": "https://www.google.com",
  "callbackUrl" : "https://inpwrd.com/results"
}
```

### GET Request:-
`http://localhost:8080/data?url=https://www.google.com`

Response:-
```java
{
  "pageTitle": "Google",
  "description": "Search the world's information, including webpages, images, videos and more. Google has many special features to help you find exactly what you're looking for.",
  "author": "",
  "polarity": "neutral",
  "subjectivity": "subjective",
  "text": "Say \"Ok Google\" to start a voice search.Search without lifting a finger. When you say \"Ok Google,\" Chrome will search for what you say next.",
  "polarity_confidence": "0.7664952874183655",
  "subjectivity_confidence": "1.0"
}
```

### The Database Entity that I am using with MySQL is below for persistency -

```sql
CREATE DATABASE IF NOT EXISTS `sentimentanalysis`;

CREATE TABLE IF NOT EXISTS `sentimentanalysis`.`sentimentanalysis` (
  `url` VARCHAR(100) NOT NULL,
  `callback_url` VARCHAR(100) NULL,
  `page_title` VARCHAR(100) NULL,
  `description` VARCHAR(500) NULL,
  `polarity` VARCHAR(45) NULL,
  `subjectivity` VARCHAR(45) NULL,
  `text` VARCHAR(500) NULL,
  `polarity_confidence` VARCHAR(100) NULL,
  `subjectivity_confidence` VARCHAR(100) NULL,
  `author` VARCHAR(45) NULL,
  PRIMARY KEY (`url`),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = big5
```
