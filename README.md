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
- once this recording is complete, a scala language script will be produced
- this script can then be configured to run for a set number of users for example

## Running Gatling tests
- in the same `bin` folder, execute the `gatling.sh/gatling.bat`, which will then return a list of simulation examples
- when the chosen simulation is complete, the console will display a link to an HTML display of the results
#### Load Test
- when running the above `gatling` file, select the configured simluation from the previous recording
- enter a suitable `rundescription` - what the test is/number of users being tested etc
- load tests can be set up to add certain numbers of users over certain periods of time, e.g. 10 users added over 5 seconds
- users are added with the `setUp` command, an example scala file that injects 10 users over 5 seconds is shown here:
```scala
package blazemeter

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BlazemeterPricing extends Simulation {

	val httpProtocol = http
		.baseURL("http://www.demoblaze.com")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("vi,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Origin" -> "http://www.demoblaze.com")

	val headers_2 = Map("Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")

    val uri1 = "https://ajax.googleapis.com/ajax/libs/jquery"
    val uri2 = "https://unpkg.com"
    val uri3 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"

	val scn = scenario("BlazemeterPricing")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/fonts/Lato-Regular.woff2")
			.headers(headers_1),
            http("request_2")
			.get("/imgs/front.jpg")
			.headers(headers_2)))
		.pause(8)
		.exec(http("request_3")
			.get("/cart.html")
			.headers(headers_0))

	setUp(scn.inject(rampUsers(10) over (5 seconds))).protocols(httpProtocol)
	
}
```
- for these tests, the web app is deployed to an ec2 instance and the recording is made there