package runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.AllureReportManager;

@Test(retryAnalyzer = utils.RetryAnalyzer.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {
        		 "pretty",                                 
        	        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", 
        	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        dryRun = false
)
//@Listeners(utils.ExtentReportManager.class)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void beforeSuite() {
		AllureReportManager.cleanAllureResults();
	}
	@AfterSuite
	public void afterSuite() {
		AllureReportManager.openAllureReport();
	}
}
