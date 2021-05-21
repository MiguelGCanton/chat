# Getting Started


in the docker-commands.txt you will find the necesary commands to start the database

### Reference Documentation



### Guides

the sistem has the next endpoints:

to see the documentation, check socialNetwork.raml

## Request examples

### get all profiles
curl --location --request GET 'http://localhost:8080/profiles'

### get all pblications for a user
curl --location --request GET 'http://localhost:8080/profiles/1/publications'

### add a profile
curl --location --request POST 'http://localhost:8080/profiles' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "juan"
}'

### add a publication

curl --location --request POST 'http://localhost:8080/profiles/1/publications' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "generic publication"
}'

### add a friend

curl --location --request POST 'http://localhost:8080/profiles/1/friends/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "message": "generic publication"
}'
