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
