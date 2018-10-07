/**
 * 
 */
package amp.managed.ws.rest.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**	
 * @author MVEKSLER
 *
 */
public class AmazonServiceJUnit 
{
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:7001/amp-ws-api/AmazonService").build();
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
			
		}
		catch( Exception e)
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
		
	}
	
//	@Test
//	public void testSayPlainTextHello() 
//	{
//		String cMethodName = "";
//		
//		try
//		{
//			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
//	        StackTraceElement ste = stacktrace[1];
//	        cMethodName = ste.getMethodName();
//
//	        Client client = Client.create();
//
//			WebResource webResource = client
//			   .resource(getBaseURI().toString() + "/sayPlainTextHello");
//
//			ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN_TYPE)
//	                   .get(ClientResponse.class);
//
//			if (response.getStatus() != 200) 
//			{
//			   throw new RuntimeException("Failed : HTTP error code : "
//				+ response.getStatus());
//			}
//
//			String output = response.getEntity(String.class);
//
//			System.out.println("Output from Server .... \n");
//			System.out.println(output);
//		}
//		catch( Exception e )
//		{
//			System.out.println(cMethodName + "::Exception:" + e.getMessage());
//		}
//	}
	//-------
	@Ignore
	@Test
	public void itemSearch1() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
			
		    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		    params.add("MerchantId", "All");
    		params.add("SearchIndex", "Kitchen");
    		params.add("ResponseGroup", "ItemAttributes");
    		params.add("Brand", "Cuisinart");
		    
    		Client client = Client.create();

    		WebResource webResource = client.resource(getBaseURI().toString() + "/itemSearch");
    		
    		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).
    											  type(MediaType.APPLICATION_FORM_URLENCODED).
												  post(ClientResponse.class, params);
    		
			if (response.getStatus() != 200) 
			{
			   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String cResXml = response.getEntity(String.class);
    		
    		System.out.println("Response: " + cResXml);
	        
		}
		catch( Exception e )
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	//---------------
	@Test  @Ignore
	public void itemSearch2() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	      
		    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
			params.add("MerchantId", "All");
    		params.add("SearchIndex", "Grocery");
    		params.add("ResponseGroup", "Large");
    		params.add("BrowseNode", "6967216011");
    		
    		Client client = Client.create();

    		WebResource webResource = client.resource(getBaseURI().toString() + "/itemSearch");
    		
    		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).
    											  type(MediaType.APPLICATION_FORM_URLENCODED).
												  post(ClientResponse.class, params);
    		
			if (response.getStatus() != 200) 
			{
			   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String cResXml = response.getEntity(String.class);
    		
    		System.out.println("Response: " + cResXml);
		}
		catch( Exception e)
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	//---------------
	@Test  @Ignore
	public void itemLookup() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	        params.add("ItemId", "B0014WYXYW");
	        params.add("ResponseGroup", "Large");
    		
	        Client client = Client.create();

    		WebResource webResource = client.resource(getBaseURI().toString() + "/itemLookup");
    		
    		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).
    											  type(MediaType.APPLICATION_FORM_URLENCODED).
												  post(ClientResponse.class, params);
    		
			if (response.getStatus() != 200) 
			{
			   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String cResXml = response.getEntity(String.class);
    		
    		System.out.println("Response: " + cResXml);
		}
		catch( Exception e)
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	//---------------
	@Ignore
	@Test
	public void browseNodeLookup() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	        params.add("BrowseNodeId", "6386372011");
	        params.add("ResponseGroup", "BrowseNodeInfo");
    		
	        Client client = Client.create();

    		WebResource webResource = client.resource(getBaseURI().toString() + "/browseNodeLookup");
    		
    		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).
    											  type(MediaType.APPLICATION_FORM_URLENCODED).
												  post(ClientResponse.class, params);
    		
			if (response.getStatus() != 200) 
			{
			   throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String cResXml = response.getEntity(String.class);
    		
    		System.out.println("Response: " + cResXml);
		}
		catch( Exception e)
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	//---------------
}
