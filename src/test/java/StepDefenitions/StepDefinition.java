package StepDefenitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import static org.junit.Assert.*;

import Resources.APIResource;
import Resources.Testdata;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class StepDefinition extends Utils{
	

	ResponseSpecification res;
	RequestSpecification request;
	Response response;

	Testdata test=new Testdata();
	static String placeid;

	@Given("User send Payload with {string} {string} {string}")
	public void user_send_payload_with(String name, String address, String language) throws IOException {


		request=given().spec(requestbuilder()).body(test.RequestSpecification(name, address ,language));

	}

	@When("User hit {string} API with {string} request")
	public void user_hit_api_with_request(String resource, String method) {
		
		APIResource ress=APIResource.valueOf(resource);

		if (method.equalsIgnoreCase("POST"))
		response=request.when().post(ress.GetResource());
		else if (method.equalsIgnoreCase("GET"))
		response=request.when().get(ress.GetResource());
		else if (method.equalsIgnoreCase("PUT"))
		response=request.when().put(ress.GetResource());

	}
	@Then("the API call got success with statucode {int}")
	public void the_api_call_got_success_with_statucode(Integer int1) {
		res=new ResponseSpecBuilder().expectStatusCode(200).build();
		assertEquals(response.getStatusCode(), 200);
		
	}
	@Then("verify the {string} in response body is {string}")
	public void verify_the_in_response_body_is(String KeyValue, String value) {
		
		assertEquals(GetResponseData(response, KeyValue), value);
		
		
	}
	
	@Then("verify the PlaceID created maps {string} using {string}")
	public void verify_the_place_id_created_maps_using(String ExpectedName, String Resource) throws IOException {

		placeid=GetResponseData(response, "place_id");
		request=given().spec(requestbuilder()).queryParam("place_id", placeid);
		user_hit_api_with_request(Resource,  "GET");
		assertEquals(GetResponseData(response, "name"), ExpectedName);
				
	}

	@Given("delete place api payload")
	public void delete_place_api_payload() throws IOException {

		request=given().spec(requestbuilder()).body(test.DeletePlacePayload(placeid));
		
	}

	@Given("User update the payload with {string}")
	public void user_update_the_payload_with(String address) throws IOException {
		
		request=given().spec(requestbuilder()).body(test.UpdatePlacePayload(placeid, address));
		

	}












}
