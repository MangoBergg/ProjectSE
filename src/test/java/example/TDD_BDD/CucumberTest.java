package example.TDD_BDD;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

// The following code is reused from the example project on Learn

@RunWith(Cucumber.class)
@CucumberOptions(plugin="summary"
		 ,features={"features"}
		 ,snippets = SnippetType.CAMELCASE
		 ,publish= false
		 )
public class CucumberTest {
}