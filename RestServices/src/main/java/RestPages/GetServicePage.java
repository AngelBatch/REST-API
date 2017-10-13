package RestPages;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetServicePage {

	public void getMethod(String productId)
	{
		RestAssured.baseURI = "http://www.thomas-bayer.com/sqlrest/PRODUCT";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/"+productId);

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println(statusCode);

		try
		{
		Assert.assertEquals(statusCode, 200, "Record not found");
		}
		catch(AssertionError e)
		{
			System.out.println("Record not found");
		}
		
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
