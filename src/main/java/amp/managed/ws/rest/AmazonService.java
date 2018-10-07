 
package amp.managed.ws.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import amp.amazon.webservices.rest.client.AmazonClientWorker;
import amp.commerce.service.api.CommerceServiceClientBase;
import amp.commerce.service.api.CommerceServiceClientFactory;


@Path("AmazonService")
@Consumes({"application/json", "application/xhtml+xml", "application/xml", "multipart/form-data", "text/html", "image/jpeg", "text/plain", "text/xml", "image/gif" })
@Produces({"application/json", "application/xhtml+xml", "application/xml", "multipart/form-data", "image/jpeg", "text/plain", "text/xml", "image/gif" })
public class AmazonService 
{
	private static final Logger cLogger = 
			LoggerFactory.getLogger(AmazonService.class);
	
	//---class variables----------------------
	protected CommerceServiceClientBase cAmazonClientWorker = null;
	
	//---getters/setters----------------------
	public CommerceServiceClientBase getcAmazonClientWorker() {
		return cAmazonClientWorker;
	}


	public void setcAmazonClientWorker(CommerceServiceClientBase cAmazonClientWorker) {
		this.cAmazonClientWorker = cAmazonClientWorker;
	}
	
	//---class methods------------------------
	/**
     * Default constructor. 
     */
    public AmazonService() {
        // TODO Auto-generated constructor stub
    }

    //---examples----------------------------
//    /**
//     * Retrieves representation of an instance of AmazonService2
//     * @return an instance of String
//     */
//	@GET
//	@Produces("text/plain")
//	public String resourceMethodGET() { 
//		// TODO Auto-generated method stub
//		return "Hello From resourceMethodGET";
//	}
//
//	/**
//     * PUT method for updating or creating an instance of AmazonService2
//     * @content content representation for the resource
//     * @return an HTTP response with content of the updated or created resource.
//     */
//	@PUT
//	@Consumes("text/plain")
//	public void resourceMethodPUT(String content) { 
//		// TODO Auto-generated method stub
//		return;
//	}
//	
//	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("/sayPlainTextHello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() 
	{
		return "Hello Jersey";
	}
//	
//	// This method is called if XML is request
//	@GET
//	@Path("/sayXMLHello")
//	@Produces(MediaType.TEXT_XML)
//	public String sayXMLHello() 
//	{
//	    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
//	}
//	
//	// This method is called if HTML is request
//	@GET
//	@Path("/sayHtmlHello")
//	@Produces(MediaType.TEXT_HTML)
//	public String sayHtmlHello() 
//	{
//	    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
//	        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
//	}
	//--------------------------------------------------------------------------
	
	//--------------------------------------------------------------------------
	@POST
	@Path("/itemSearch")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String itemSearch(MultivaluedMap<String, String> mvParams)
    {
    	boolean cRes = true;
    	
    	String cMethodName = "";
    	String cResXml = "";
    	
    	HashMap<String, String> params = new HashMap<String, String>();
    	
    	try
    	{
    		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
	        StackTraceElement ste = stacktrace[1];
	        cMethodName = ste.getMethodName();
	        
	        //--------
	        if ( null == mvParams )
	        {
	        	cRes = false;
	        	
	        	cLogger.error(cMethodName + "::Error:params is null. Check MultivaluedMap<String, String> params parameter!");
	        }
	        
	        //--------
	        if ( cRes )
	        {
	        	if ( null == this.cAmazonClientWorker )
	        	{
	        		this.cAmazonClientWorker = 
	        				CommerceServiceClientFactory.buildCommerceServiceClient(AmazonClientWorker.class);
	        	
	        		if ( null == this.cAmazonClientWorker )
		    		{
	        			cLogger.error(cMethodName + "::this.cAmazonClientWorker id null for AmazonClientWorker.class!!");
		    			
		    			cRes = false;
		    		}
	        	}
	        }

	        //--------
	        if ( cRes )
	        {
	        	for( Map.Entry<String, List<String>> mvParam : mvParams.entrySet())
	        	{
	        		String mvValue = "";
	        		String mvKey = mvParam.getKey();
	        		
	        		List<String> mvValues = mvParam.getValue();
	        		
	        		if (mvValues != null && mvValues.size() >= 1)
	        		{
	        			mvValue = mvValues.get(0);
	        			
	        			params.put(mvKey, mvValue);
	        		}
	        	}
	        }
	        
	        //--------
	        if ( cRes )
	        {
	        	cResXml = this.cAmazonClientWorker.itemSearchXml(params);
	        }
	        
	        //--------
	        cLogger.info("------------------");
	        
	        return cResXml;
    	}
    	catch( Exception e)
    	{
    		cLogger.error(cMethodName + "::Exception:" + e.getMessage());
    		
    		return ( cResXml = cMethodName + "::Error:" );
    	}
    }
		
		//--------------------------------------------------------------------------
		/**
	     * Retrieves representation of an instance of AmazonService
	     * @return an instance of String
	     */
		@POST
		@Path("/itemLookup")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces("application/xml")
		public String itemLookup(MultivaluedMap<String, String> mvParams)
	    {
	    	boolean cRes = true;
	    	
	    	String cMethodName = "";
	    	String cResXml = "";
	    	
	    	HashMap<String, String> params = new HashMap<String, String>();
	    	
	    	try
	    	{
	    		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		        StackTraceElement ste = stacktrace[1];
		        cMethodName = ste.getMethodName();
		        
		        //--------
		        if ( null == mvParams )
		        {
		        	cRes = false;
		        	
		        	cLogger.error(cMethodName + "::Error:params is null. Check HashMap<String, String> params parameter!");
		        }
		        
		        //--------
		        if ( cRes )
		        {
		        	if ( null == this.cAmazonClientWorker )
		        	{
		        		this.cAmazonClientWorker = 
		        				CommerceServiceClientFactory.buildCommerceServiceClient(AmazonClientWorker.class);
		        	
		        		if ( null == this.cAmazonClientWorker )
			    		{
		        			cLogger.error(cMethodName + "::this.cAmazonClientWorker id null for AmazonClientWorker.class!!");
			    			
			    			cRes = false;
			    		}
		        	}
		        }

		        //--------
		        if ( cRes )
		        {
		        	for( Map.Entry<String, List<String>> mvParam : mvParams.entrySet())
		        	{
		        		String mvValue = "";
		        		String mvKey = mvParam.getKey();
		        		
		        		List<String> mvValues = mvParam.getValue();
		        		
		        		if (mvValues != null && mvValues.size() >= 1)
		        		{
		        			mvValue = mvValues.get(0);
		        			
		        			params.put(mvKey, mvValue);
		        		}
		        	}
		        }
		        
		        //--------
		        if ( cRes )
		        {
		        	cResXml = this.cAmazonClientWorker.itemLookupXml(params);
		        }
		        
		        //--------
		        cLogger.info("------------------");
		        
		        return cResXml;
	    	}
	    	catch( Exception e)
	    	{
	    		cLogger.error(cMethodName + "::Exception:" + e.getMessage());
	    		
	    		return ( cResXml = cMethodName + "::Error:" );
	    	}
	    }
		
		//--------------------------------------------------------------------------
		/**
	     * Retrieves representation of an instance of AmazonService
	     * @return an instance of String
	     */
		@POST
		@Path("/browseNodeLookup")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces("application/xml")
		public String browseNodeLookup(MultivaluedMap<String, String> mvParams)
	    {
	    	boolean cRes = true;
	    	
	    	String cMethodName = "";
	    	String cResXml = "";
	    	
	    	HashMap<String, String> params = new HashMap<String, String>();
	    	
	    	try
	    	{
	    		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		        StackTraceElement ste = stacktrace[1];
		        cMethodName = ste.getMethodName();
		        
		        //--------
		        if ( null == mvParams )
		        {
		        	cRes = false;
		        	
		        	cLogger.error(cMethodName + "::Error:params is null. Check HashMap<String, String> params parameter!");
		        }
		        
		        //--------
		        if ( cRes )
		        {
		        	if ( null == this.cAmazonClientWorker )
		        	{
		        		this.cAmazonClientWorker = 
		        				CommerceServiceClientFactory.buildCommerceServiceClient(AmazonClientWorker.class);
		        	
		        		if ( null == this.cAmazonClientWorker )
			    		{
		        			cLogger.error(cMethodName + "::this.cAmazonClientWorker id null for AmazonClientWorker.class!!");
			    			
			    			cRes = false;
			    		}
		        	}
		        }

		        //--------
		        if ( cRes )
		        {
		        	for( Map.Entry<String, List<String>> mvParam : mvParams.entrySet())
		        	{
		        		String mvValue = "";
		        		String mvKey = mvParam.getKey();
		        		
		        		List<String> mvValues = mvParam.getValue();
		        		
		        		if (mvValues != null && mvValues.size() >= 1)
		        		{
		        			mvValue = mvValues.get(0);
		        			
		        			params.put(mvKey, mvValue);
		        		}
		        	}
		        }
		        
		        //--------
		        if ( cRes )
		        {
		        	cResXml = this.cAmazonClientWorker.browseNodeLookupXml(params);
		        }
		        
		        //--------
		        cLogger.info("------------------");
		        
		        return cResXml;
	    	}
	    	catch( Exception e)
	    	{
	    		cLogger.error(cMethodName + "::Exception:" + e.getMessage());
	    		
	    		return ( cResXml = cMethodName + "::Error:" );
	    	}
	    }
}