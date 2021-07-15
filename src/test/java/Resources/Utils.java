package Resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	static RequestSpecification req ;
	ResponseSpecification res;
	
	public RequestSpecification requestbuilder() throws IOException
	{

		if(req==null)
		{
		PrintStream log=new PrintStream(new File("logging.txt"));
		req=new RequestSpecBuilder().setBaseUri(GetGlobalData("baseURI")).addQueryParam("key", GetGlobalData("keyvalue"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
	}
	
	public static String GetGlobalData(String key) throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("/Users/thulasinathan/Desktop/Eclipse/Training/APIFrameWork/src/test/java/Resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public String GetResponseData(Response response, String key)
	{
		String resp=response.asString();
		JsonPath respo = new JsonPath(resp);
		return respo.get(key).toString();
		
	}

}
