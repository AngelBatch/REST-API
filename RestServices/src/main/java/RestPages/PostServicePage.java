package RestPages;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class PostServicePage {
	public void postMethod() throws ClientProtocolException, IOException
	{
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost postrequest = new HttpPost(
				"http://www.thomas-bayer.com/sqlrest/PRODUCT");

		ArrayList<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		BasicNameValuePair bn;

		bn = new BasicNameValuePair("content-type", "application/xml");
		nvps.add(bn);
		bn = new BasicNameValuePair("Server", "Apache-Coyote/1.1");
		nvps.add(bn);	    


		for (BasicNameValuePair h : nvps) {
			postrequest.addHeader(h.getName(), h.getValue());
		}
		
		String xml= "<?xml version=\"1.0\"?><PRODUCT xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n" +
				"    <ID>55</ID>\n" +
				"    <NAME>Water Bottle</NAME>\n" +
				"    <PRICE>20.9</PRICE>\n" +
				"</PRODUCT>";

		postrequest.setEntity(new StringEntity(xml));

		HttpResponse response = httpClient.execute(postrequest);

		if (response.getStatusLine().getStatusCode() != 201) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}
		else
			System.out.println("Record has been posted Successfully");
	}
}