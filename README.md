# Springboot Complete Authentication


## Overview

Here is a spring boot application with complete authentication system. 
We have email password signup and login feature and to protect the routes we have JWT based authentication.

Lets analyize the below diagram:
- We have users sending requests to our server
- We are load balancing all the requests to multiple server with nginx
- Storing users data in db enable flag false
- Generate a token with the user id and send it to user
- When user verifies that we are enabling the enable flag as true
- In login we are creating a jwt token and sending it in response body
- Clients store the token and send it as bearer token everytime its hits a api
- For routes they have internal filter which verifies the jwt token and lets user hits the api


<img width="1058" alt="Screenshot 2023-06-20 at 3 02 46 AM" src="https://github.com/rijusougata13/springbootCompleteAuthentication/assets/52108435/a44c7eb7-16e5-4dc6-be73-4e83d7af2527">




## Run With Docker:

-  ``` docker-compose build ``` and `docker-compose up`

## API Details

-  Registration Route: `curl --location 'http://localhost:5000/api/v1/registration' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"sougata",
    "lastName":"das",
    "email":"riju@gmail.com",
    "password":"pass"
}'` 

-  Confirmation route: `http://localhost:5000/api/v1/registration/confirm?token=7b8abcd3-df95-45e3-8e37-8ed6f407543d`

-  login route: `curl --location 'http://localhost:5000/api/v1/registration/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email":"riju@gmail.com",
    "password":"pass"
}'`

-  Ping authenticated route: `curl --location 'http://localhost:5000/ping' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWp1QGdtYWlsLmNvbSIsImV4cCI6MTY4NzI0NjE5MywiaWF0IjoxNjg3MjEwMTkzfQ.RlU99zJiLdewIy0CdvBibrN_m5nV5Zw0KXya9OHcVaw'`

