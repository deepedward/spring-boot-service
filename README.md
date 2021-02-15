# spring-boot-service


## Directions
Please complete the following problem and submit the solution as mentioned in the instructions below. The expectations are the code should be clean, legible, tested and fully functional an example of what you would consider production quality. Feel free to structure the package as you see fit and add any helper/ util methods as needed.

## What we are looking for
You will be sending us an exported project as a zipfile or tarball, which will be shared to our developers for a code review. During this review:
* We'll compile, build and run the project
*	We'll evaluate the structure of your code, documentation, testability, readability and maintainability 

## Events API
The goal of this exercise is to build API's to support event management. Event is a program that the users would attend in the conference. Please find more about the high-level objective and request-response details for the API below.

## Objective
*	Build APIs as requested
*	CREATE
*	FETCH SPECIFIC EVENT
*	Handle Exceptions
*	Write Unit Tests (For CREATE and others are optional)

## Project Environment
*	Java 8 and above (Note: have used Java 8 instead of Java 11)
*	Maven
*	H2 in-memory database (Added to the project, but feel to use any database you're comfortable with)
*	PostMan (for testing)
 
## API Specification

### Create an Event API
Path: ``` /api/v1/events ```

Request:
```
{
    "name" : "Test Event",
    "published": true
}
```

Response:
```
{
    "id": 1,
    "name": "Test Event",
    "published": true,
    "createdAt": "2021-01-11T07:54:47.906+00:00"
}
```

### Fetch specific event
Path: ```/api/v1/events/1 ```

Response: Should return a specific event
```
    {
        "id": 1,
        "name": "Test Event",
        "published": true,
        "createdAt": "2021-01-11T07:54:47.906+00:00"
    }
```

### If event is not found, respond below
```
{
    "timestamp": "2021-01-11T16:23:00.865+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Event with id 6 not found.",
    "path": "/api/v1/events/6"
}
```

