package Resources;

public enum APIResource {
	

	
	AddPlace ("/maps/api/place/add/json"),
	GetPlace ("/maps/api/place/get/json"),
	UpdatePlace("/maps/api/place/update/json"),
	DeletePlace("/maps/api/place/delete/json");
	
	private String resource;
	APIResource (String resource)
	{
		this.resource=resource;
	}
	
	public String GetResource()
	{
		return resource;
	}

}
