Feature: Verify the PlaceAPI functionalities


@Addplace
Scenario Outline: Adding the place using AddPlace API

Given User send Payload with "<name>" "<address>" "<language>"
When User hit "AddPlace" API with "post" request
Then the API call got success with statucode 200
And verify the "status" in response body is "OK"
And verify the "scope" in response body is "APP"
And verify the PlaceID created maps "<name>" using "GetPlace"

Examples:

	|name   | address   | language|
	|Thulasi| Lisa	    | tamil	  |
#	|Swathi | Thiruvarur| english |

@UpdatePlace
Scenario Outline: Updating the place using updateplace API

Given User update the payload with "<address>"
When User hit "UpdatePlace" API with "put" request
Then the API call got success with statucode 200
And verify the "msg" in response body is "Address successfully updated"

Examples:

	|address|
	|chennai mugappair|

@DeletePlace
Scenario: Verify the delete place API is working


Given delete place api payload
When User hit "DeletePlace" API with "post" request
Then the API call got success with statucode 200
And verify the "status" in response body is "OK"