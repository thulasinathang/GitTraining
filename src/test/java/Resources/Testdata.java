package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Locate;

public class Testdata {

	public AddPlace RequestSpecification(String name, String address, String language)
	{
		AddPlace ad= new AddPlace();	
		Locate lo=new Locate();
			
		

		ad.setAccuracy(50);
		ad.setName(name);
		ad.setPhone_number("+1 905-598-4263");
		ad.setAddress(address);
		List<String> type  = new ArrayList<String>();
		type.add("shoe shop");
		type.add("bata");
		ad.setTypes(type);
		ad.setWebsite("www.thulasi.com");
		ad.setLanguage(language);
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		ad.setLocation(lo);
		return ad;
	}
	
	public String DeletePlacePayload(String PlaceID)
	{
		return "{\n" + 
				"    \"place_id\":\""+PlaceID+"\"\n" + 
				"}";
	}
	
	public String UpdatePlacePayload(String PlaceID, String address)
	{
		return "{\"place_id\":\""+PlaceID+"\",\n" + 
				"\"address\":\""+address+"\",\n" + 
				"\"key\":\"qaclick123\"\n" + 
				"}";
	}
	
}
