package org.totalqa.RestServices;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class PostTest {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
	
	    HttpPost postrequest = new HttpPost(
	            "http://www.thomas-bayer.com/sqlrest/PRODUCT");
/*	    List<NameValuePair> nvps = new ArrayList<NameValuePair>() {{
	        addAll(new BasicNameValuePair("content-type", "application/xml"));
	        addAll(new BasicNameValuePair("Server", "Apache-Coyote/1.1"));

	    }};
*/	    
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
	            "    <NAME>Chair Shoe</NAME>\n" +
	            "    <PRICE>24.9</PRICE>\n" +
	            "</PRODUCT>";

	    postrequest.setEntity(new StringEntity(xml));

	    HttpResponse response = httpClient.execute(postrequest);

	    if (response.getStatusLine().getStatusCode() != 201) {
	        throw new RuntimeException("Failed : HTTP error code : "
	                + response.getStatusLine().getStatusCode());
	    }
	    else
	    	System.out.println("Record has been posted successfully");

	   // httpClient.getConnectionManager().shutdown();
	}
	}


