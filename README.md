# TransactionRewards

Created a new spring boot project using spring initializer. 

Rewards API Endpoints

This document provides instructions on how to use the Rewards API endpoints.

Base URL

`http://localhost:8080` 


Endpoints

 1. Get Monthly Summary of Rewards for All Customers

HTTP Method: GET
Endpoint: `/calculaterewards/rewards/summary/monthly`
Description: Retrieves a monthly summary of rewards for all customers.

GET http://localhost:8080/calculaterewards/rewards/summary/monthly

2. Calculate Total Rewards for All Customers

HTTP Method: GET
Endpoint: `/calculaterewards/rewards/summary`
Description: Calculates the total rewards for all customers.

GET http://localhost:8080/calculaterewards/rewards/summary

3. Get Rewards for a Specific Customer by ID

HTTP Method: GET
Endpoint: `/calculaterewards/rewards/customers/{id}`
Description: Fetches rewards details for a specific customer using their unique ID.
Replace `{id}` with the actual customer ID.

GET http://localhost:8080/calculaterewards/rewards/customers/123

4. Get Rewards for a Specific Customer by ID for a Specific Month

HTTP Method: GET
Endpoint: `/calculaterewards/rewards/customers/{id}/monthly`
Description: Retrieves rewards for a specific customer and month.
Parameters:
`id`: Customer's unique identifier.
`month`: Numeric representation of the month (1-12).
Replace `{id}` with the actual customer ID and include `month` as a query parameter.

GET http://localhost:8080/calculaterewards/rewards/customers/123/monthly?month=5


How to Run the Application

1. Ensure you have Java and Maven installed on your system.
2. Navigate to the root directory of the project via the terminal or command prompt.
3. Execute the following command to start the application:

mvn spring-boot:run

The API will be available at `http://localhost:8080` after the application starts.

Testing the Endpoints

You can test these endpoints using tools such as Postman or cURL. Simply use the HTTP method specified along with the full endpoint URL, and replace any path variables or include query parameters as needed.















