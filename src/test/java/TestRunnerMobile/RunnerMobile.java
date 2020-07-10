package TestRunnerMobile;


import org.testng.annotations.*;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "./src/test/resources", glue = {"StepDefinitionsMobile"}
        , plugin = {"pretty","html:target/cucumber-report-html","json:target/cucumber.json" }
        , tags = {"@TC_02-Menu"}) // or
																													// condition

public class RunnerMobile {

	private TestNGCucumberRunner testNGCucumberRunner;


	@BeforeClass(alwaysRun = true)
	// @Parameters("browserName")
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "feature")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}

	@DataProvider // (parallel=true)
	public Object[][] feature() {

		return testNGCucumberRunner.provideScenarios();

	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}

}
