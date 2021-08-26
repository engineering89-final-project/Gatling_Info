# Criteria for testing

## How many users?
- certain response time/performance for a set number of users?
- how many users till performance drops a certain amount?
- performance test at "standard" number of users, load test above this number to see how site deals with extra traffic?
- `setUp(scn.inject(rampUsers(10) over (5 seconds))).protocols(httpProtocol)` adds 10 users over 5 seconds

## What timeframe? 
- inject users all at once?
- increase users over a timeframe and monitor performance?

## Different tests for different user journies?
- adding roles as an admin?
- searching for roles as a user?

## Test tips
- https://www.youtube.com/watch?v=TlwSZRs6yKo
- can select no static resources when creating script from HAR - will only test core files/functionality
- test with and without static? they are often cached anyway
- ensure full logging is enabled in `conf/logback.xml` - `<logger name="io.gatling.http.engine.response" level="TRACE" />`
- use Chrome dev tools
- refactor and remove static content - put common headers in http protocol etc
- swap out hardcoding for parameters where possible
- use csv/custom code to include every product/option on site
- refactor for each method - etc method for homepage, method for roles page, method for sorting etc
- can create scenarios from methods
- add in pause times for realism
- use https://gatling.io/docs/gatling/reference/current/general/simulation_setup/ for injection of users

## Criteria
- test t2 micro server at different user numbers and injection rates
- find "cutoff" points when performance starts to drastically drop
- if site constantly has over this number suggest upgrading server for web app