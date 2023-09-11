package basic.testcase;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import utility.RestFrameworkLogger;

public class SampleLoggingGenerator {
	
	@Test
	public void REST_TEST01() {
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("REST_TEST01");
		RestFrameworkLogger.info("Creating REST Assured Object");
		RestFrameworkLogger.info("Excel sheet opened");
		RestFrameworkLogger.info("New Object initiated");
		RestFrameworkLogger.info("Test case closed");
		RestFrameworkLogger.endestCase("REST_TEST01");
		
	}
	@Test
	public void REST_TEST02() {
		PropertyConfigurator.configure("log4j.properties");
		RestFrameworkLogger.startTestCase("REST_TEST02");
		RestFrameworkLogger.info("Creating REST Assured Object");
		RestFrameworkLogger.info("Excel sheet opened");
		RestFrameworkLogger.info("New Object initiated");
		RestFrameworkLogger.info("Test case closed");
		RestFrameworkLogger.endestCase("REST_TEST02");
		
	}

}
