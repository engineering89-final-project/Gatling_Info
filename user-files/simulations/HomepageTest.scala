
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://127.0.0.1:5000")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_1 = Map(
		"Origin" -> "http://127.0.0.1:5000",
		"sec-ch-ua" -> """Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_6 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"Cache-Control" -> "no-cache",
		"Pragma" -> "no-cache",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92""",
		"sec-ch-ua-mobile" -> "?0")

    val uri1 = "https://fonts.gstatic.com/s"

	val scn = scenario("RecordedSimulation")
		.exec(http("LOAD_HOMEPAGE")
		// .exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri1 + "/materialicons/v98/flUhRq6tzZclQEJ-Vdg-IuiaDsNcIhQ8tQ.woff2")
			.headers(headers_1),
            http("request_2")
			.get(uri1 + "/ubuntu/v15/4iCs6KVjbNBYlgoKfw72nU6AFw.woff2")
			.headers(headers_1),
            http("request_3")
			.get(uri1 + "/ubuntu/v15/4iCv6KVjbNBYlgoCjC3jsGyNPYZvgw.woff2")
			.headers(headers_1),
            http("request_4")
			.get(uri1 + "/ubuntu/v15/4iCv6KVjbNBYlgoCxCvjsGyNPYZvgw.woff2")
			.headers(headers_1),
            http("request_5")
			.get(uri1 + "/kanit/v7/nKKS-Go6G5tXcraQI4GnZaNhMXBxEu8.woff2")
			.headers(headers_1),
            http("request_6")
			.get("/")
			.headers(headers_6)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}