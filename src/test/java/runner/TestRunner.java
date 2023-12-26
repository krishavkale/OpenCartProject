package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
    (
    		features=".//FeatureFiles/OpenCartLogin.feature",
    		dryRun=false,
    		monochrome=true,
            glue={"stepDefination","application.webdriver"},
            plugin= {"pretty","html:Reports/AutomationCucumberReport.html"}
    )

public class TestRunner {

}
