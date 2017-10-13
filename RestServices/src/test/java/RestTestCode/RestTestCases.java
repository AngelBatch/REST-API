package RestTestCode;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import RestPages.DeleteServicePage;
import RestPages.GetServicePage;
import RestPages.PostServicePage;

public class RestTestCases {
	GetServicePage getPage;
	PostServicePage postPage;
	DeleteServicePage deletePage;
		
	@Test(enabled=true,priority=1,groups = { "posttest" })
	public void postTest() throws ClientProtocolException, IOException
	{
		postPage = new PostServicePage();
		postPage.postMethod();
	}
	
	@Parameters({"Id"})
	@Test(enabled=true,priority=2,groups = { "posttest" ,"deltest","gettest"})
	public void getTest(String Id)
	{
		getPage = new GetServicePage();
		getPage.getMethod(Id);
	}
	
	@Test(enabled=true,priority=1,groups = { "deltest" })
	public void deleteTest() throws ClientProtocolException, IOException
	{
		deletePage = new DeleteServicePage();
		deletePage.deleteMethod();
	}	
}
