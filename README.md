# springbootCompleteAuthentication

## Overview

<img width="1058" alt="Screenshot 2023-06-20 at 2 48 33 AM" src="https://github.com/rijusougata13/springbootCompleteAuthentication/assets/52108435/7afd80aa-8652-4183-b860-cb1b73528cb8">


## Details:

-  ``` docker-compose build ``` and `docker-compose up` 
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

