# Gatling
- open source testing software, can be used for load and performance testing of software
- the test software is configured with the browser instance of the software being tested - in this case it is the ITJobsWatch web app
- a test script is written and then executed

## Recorder
- used to quickly generate scenarios - records a simple simulation used to mimic user behaviour
- after downloading the Gatling files, navigate to the `bin` folder and execute the `recorder.sh/recorder.bat` to set this location as the GATLING_HOME
- this then opens up a Jave recorder page, where network, simulation and output settings can be applied
- when running tests in browser, the page must also be configured to use the Gatling recorder's proxy
- the port selected in the recorder config is the port that the browser must connect to so the recorder can capture the navigation, so after setting it in the recorder settings the broser must be configured to the same port

## Running Gatling tests
- in the same `bin` folder, execute the `gatling.sh/gatling.bat`, which will then return a list of simulation examples
- when the chosen simulation is complete, the console will display a link to an HTML display of the results