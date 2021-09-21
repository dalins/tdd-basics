package cucumber;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Cucumber Suite")
@IncludeEngines("cucumber")
@SelectClasspathResource("cucumber")
public class CucumberSuiteTest
{

}
