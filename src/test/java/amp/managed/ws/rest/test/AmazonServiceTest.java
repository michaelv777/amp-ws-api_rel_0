/**
 * 
 */
package amp.managed.ws.rest.test;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import amp.amazon.webservices.rest.client.SignedRequestsHelper;



/**
 * @author MVEKSLER
 *
 */
public class AmazonServiceTest 
{
	/*
     * Your AWS Access Key ID, as taken from the AWS Your Account page.
     */
    private static final String AWS_ACCESS_KEY_ID = "AKIAIQU2FHPYCZDYXCIA";

    /*
     * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
     * Your Account page.
     */
    private static final String AWS_SECRET_KEY = "k9TUoikDHilxh11Ukrxl9PN1h4KxgQIpQ2HozC7w";

    /*
     * Use the end-point according to the region you are interested in.
     */
    private static final String ENDPOINT = "webservices.amazon.ca";
    
	private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:7001/amp-ws-api/AmazonService").build();
	}
	
	public void testSayPlainTextHello() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();

	        Client client = Client.create();

			WebResource webResource = client.resource(getBaseURI().toString() + "/sayPlainTextHello");

			ClientResponse response = webResource.accept("text/plain")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) 
			{
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
	        
		}
		catch( Exception e )
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	
	public void testAmazonWebservicesAPI() 
	{
		String cMethodName = "";
		
		try
		{
			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();

	        SignedRequestsHelper helper;

	        try {
	            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return;
	        }

	        String requestUrl = null;

	        Map<String, String> params = new HashMap<String, String>();

	        params.put("Service", "AWSECommerceService");
	        params.put("Operation", "ItemSearch");
	        params.put("AWSAccessKeyId", "AKIAIQU2FHPYCZDYXCIA");
	        params.put("AssociateTag", "michaelv777-20");
	        params.put("SearchIndex", "All");
	        params.put("Keywords", "Lighting Equipment ");
	        params.put("ResponseGroup", "Images,ItemAttributes,Offers");

	        requestUrl = helper.sign(params);

	        System.out.println("Signed URL: \"" + requestUrl + "\"");
	        
		}
		catch( Exception e )
		{
			System.out.println(cMethodName + "::Exception:" + e.getMessage());
		}
	}
	
	public static void main(String [ ] args)
	{
		try
		{
			new AmazonServiceTest().testAmazonWebservicesAPI();
		}
		catch( Exception e )
		{
			
		}
	}
}
