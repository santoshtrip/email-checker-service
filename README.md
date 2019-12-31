# email-checker-service - This is SpringBoot app with REST endpoint to check unique email count
Command to start the application : ./gradlew bootRun
Command to run the test: ./gradlew test
Sample request for the POST request:

curl -X POST \
  http://localhost:9091/email/check \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:9091' \
  -d '{ 
   
      "emails":["t@gmail.com","t2@gm.com"]
   
}'


