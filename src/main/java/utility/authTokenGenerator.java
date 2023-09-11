package utility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class authTokenGenerator {
 public final static String bearer_token ="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";
	 
 
	 public static String getBearerToken()
	 {
		 return bearer_token;
	 }
	 

}
