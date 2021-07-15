package StepDefenitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	StepDefinition m= new StepDefinition();
	
	@Before("@DeletePlace")

	
	public void Beforemethod() throws IOException
	{
		
		if(StepDefinition.placeid==null)
		{
		m.user_send_payload_with("Swathi", "Thiruvarur", "english");
		m.user_hit_api_with_request("AddPlace", "post");
		m.verify_the_place_id_created_maps_using("Swathi", "GetPlace");
		}
	}
	
	@Before("@UpdatePlace")
	public void BeforeUpdatemethod() throws IOException
	{
		
		if(StepDefinition.placeid==null)
		{
		m.user_send_payload_with("Swathi", "Thiruvarur", "english");
		m.user_hit_api_with_request("AddPlace", "post");
		m.verify_the_place_id_created_maps_using("Swathi", "GetPlace");
		}
	}

}
