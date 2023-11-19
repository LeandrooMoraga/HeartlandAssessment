package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features/",

        glue = "steps",

        dryRun = false,

        tags = "",

        monochrome = true,

        // reports after running test case is completed
        plugin = {"pretty","html:target/cucumber.html"}
)
public class mainRunner {


}


