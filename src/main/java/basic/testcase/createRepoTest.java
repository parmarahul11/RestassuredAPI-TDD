package basic.testcase;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.requestresponse.BaseClass;

import io.restassured.response.Response;
import resources.pojoClasses.createRepoPOJO;
import utility.*;

public class createRepoTest {

	Response response;
	ObjectMapper objectMapper;
	String endPoint = createURL.getBaseURI("/user/repos");
	String bearer_token = authTokenGenerator.getBearerToken();
	public String repoID;

	@Test
	public void createRepositoryTestcase() throws IOException {
		RestFrameworkLogger.initLogger();

		RestFrameworkLogger.startTestCase("createRepositoryTestcase");
		RestFrameworkLogger.info("Step 1 : Generating Payload String");

		String request_Payload = payloadGenerator.generatePayload("createRepo.json");

		// BaseClass.postRequest(endPoint, request_Payload, bearer_token);
		RestFrameworkLogger.info("Step 2 : Executing Create Repo Call");
		response = BaseClass.postRequest(endPoint, request_Payload, bearer_token);
		String responseString = response.getBody().asString();

		// System.out.println("********** Request Response For TestCase 1**********");
		// System.out.println(responseString);
		RestFrameworkLogger.info("Step 3 : Validating Reposetory Name");
		Assert.assertEquals(commonUtillFunctions.geConvertedResponseKeyValue(responseString, "name"),
				commonUtillFunctions.geConvertedResponseKeyValue(request_Payload, "name"));
		RestFrameworkLogger.info("Step 4 : Validating Reposetory Description");
		Assert.assertEquals(commonUtillFunctions.geConvertedResponseKeyValue(responseString, "description"),
				commonUtillFunctions.geConvertedResponseKeyValue(request_Payload, "description"));

		RestFrameworkLogger.endestCase("createRepositoryTestcase");
	}

	@Test(priority = 1)
	public void createRepoTestcase() throws JsonProcessingException {

		RestFrameworkLogger.initLogger();

		RestFrameworkLogger.startTestCase("createRepoTestcase");
		RestFrameworkLogger.info("Step 1 : Generating Payload String with POJO");

		createRepoPOJO requestPayLoad = new createRepoPOJO();
		requestPayLoad.setName("REST-API-Assured2");
		requestPayLoad.setDescription("Create Reposatries via POJO Class");

		objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayLoad);
		RestFrameworkLogger.info("Step 2 : Executing Create Repo Call with POJO");

		response = BaseClass.postRequest(endPoint, payload, bearer_token);
		String responseString = response.getBody().asString();
		RestFrameworkLogger.info("Step 3 : Validating Reposetory Name");
		Assert.assertEquals(requestPayLoad.getName(),
				commonUtillFunctions.geConvertedResponseKeyValue(responseString, "name"));
		RestFrameworkLogger.info("Step 4 : Validating Reposetory Description");

		Assert.assertEquals(requestPayLoad.getDescription(),
				commonUtillFunctions.geConvertedResponseKeyValue(responseString, "description"));

		RestFrameworkLogger.endestCase("createRepoTestcase");
		// System.out.println("********** Request Response For TestCase 2**********");
		// System.out.println(responseString);

	}

	@Test(priority = 2)
	public void deleteRepo() throws IOException {
		RestFrameworkLogger.startTestCase("deleteRepo");
		RestFrameworkLogger.info("Step 1 : Generating Payload String");

		String request_Payload = payloadGenerator.generatePayload("createRepo.json");

		String deleteEndPoint = createURL.getBaseURI("/repos/parmarahul11/")
				+ commonUtillFunctions.geConvertedResponseKeyValue(request_Payload, "name");
		// System.out.println("My EndPoint is: " +deleteEndPoint);
		RestFrameworkLogger.info("Step 2 : Executing Delete Repo Call");

		response = BaseClass.deleteRequest(deleteEndPoint, bearer_token);
		RestFrameworkLogger.info("Step 3 : Validating Delete Repo Call");
		Assert.assertEquals(commonUtillFunctions.getStatusCode(response), 204);
		RestFrameworkLogger.endestCase("deleteRepo");

	}

	@Test(priority = 3)
	public void deleteRepoWithPOJO() throws IOException {
		RestFrameworkLogger.startTestCase("deleteRepoWithPOJO");
		RestFrameworkLogger.info("Step 1 : Generating Payload String");

		createRepoPOJO requestPayLoad = new createRepoPOJO();
		requestPayLoad.setName("REST-API-Assured2");
		requestPayLoad.setDescription("Delete Reposatries via POJO Class");

		objectMapper = new ObjectMapper();
		String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayLoad);

		RestFrameworkLogger.info("Request Payload is - " + payload);

		String deleteEndPoint = createURL.getBaseURI("/repos/parmarahul11/") + requestPayLoad.getName();
		RestFrameworkLogger.info("Step 2 : Executing Delete Repo Call");
		RestFrameworkLogger.info(deleteEndPoint);
		response = BaseClass.deleteRequest(deleteEndPoint, bearer_token);
		RestFrameworkLogger.info("Step 3 : Validating Delete Repo Call");
		Assert.assertEquals(commonUtillFunctions.getStatusCode(response), 204);
		RestFrameworkLogger.info(commonUtillFunctions.getStatusMessage(response));
		RestFrameworkLogger.endestCase("deleteRepoWithPOJO");

	}
}
