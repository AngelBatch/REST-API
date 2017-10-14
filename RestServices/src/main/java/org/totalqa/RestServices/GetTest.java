package org.totalqa.RestServices;


	import org.testng.Assert;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class GetTest {

		public static void main(String[] args) {
			//FirefoxDriver driver = new FirefoxDriver();
			//System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
			RestAssured.baseURI = "http://www.thomas-bayer.com/sqlrest/INVOICE";
			RequestSpecification httpRequest = RestAssured.given();

			Response response = httpRequest.request(Method.GET, "/5");

			// Now let us print the body of the message to see what response
			// we have recieved from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);

			/*		String City = response.path("City");
			System.out.println(City);

			JsonPath jsonPathEvaluator = response.jsonPath();
			String jsonCity = jsonPathEvaluator.get("City");
			System.out.println(jsonCity);
			 */
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
		System.out.println("aparna");
     		Assert.assertEquals(statusCode, 200, "Correct status code not returned :");

			String statusLine = response.getStatusLine();
			System.out.println(statusLine);

			String contentType = response.getHeader("Content-Type");
			System.out.println("Content Type value: " + contentType);

			String serverType = response.getHeader("Server");
			System.out.println("Server value: " + serverType);

			String acceptLanguage = response.getHeader("Content-Encoding");
			System.out.println("Content Encoding: " + acceptLanguage);


		}

	}



