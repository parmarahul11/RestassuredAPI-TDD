package com.requestresponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestFrameworkLogger;

public class BaseClass {
	public static Response getRequest(String requestURI) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Get Request URI is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestFrameworkLogger.info("Get Request Response is - " + response.getBody().asString());
		return response;
	}
	
	
	
	public static Response postRequest(String requestURI, String requestPayload) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Post Request URI is - " + requestURI);
		RestFrameworkLogger.info("Post Request Payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		RestFrameworkLogger.info("Post Request Response is - " + response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayload, String bearer_token) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Post Request URI is - " + requestURI);
		RestFrameworkLogger.info("Post Request Payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.post(requestURI);
		RestFrameworkLogger.info("Post Request Response is - " + response.getBody().asString());
		return response;
	}
	
	
	public static Response putRequest(String requestURI, String requestPayload) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Put Request URI is - " + requestURI);
		RestFrameworkLogger.info("Put Request Payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		RestFrameworkLogger.info("Put Request Response is - " + response.getBody().asString());
		return response;
	}
	
	
	public static Response deleteRequest(String requestURI) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Delete Request URI is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestFrameworkLogger.info("Delete Request Response Status Code is - " + response.getStatusCode());
		return response;
	} 
	
	public static Response deleteRequest(String requestURI, String bearer_token) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Delete Request URI is - " + requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearer_token);
		Response response = requestSpecification.delete(requestURI);
		RestFrameworkLogger.info("Delete Request Response Status Code is - " + response.getStatusCode());
		return response;
	} 
	
	public static Response deleteRequestWithPayload(String requestURI, String requestPayload) {
		RestFrameworkLogger.initLogger();
		RestFrameworkLogger.info("Delete Request URI is - " + requestURI);
		RestFrameworkLogger.info("Delete Request Payload is - " + requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestFrameworkLogger.info("Delete Request Response Status Code is - " + response.getStatusCode());
		return response;
	}

}
