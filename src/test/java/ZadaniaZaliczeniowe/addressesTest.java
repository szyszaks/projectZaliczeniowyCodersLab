package ZadaniaZaliczeniowe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/addresses.feature",
        plugin = {"pretty", "html:report/resultAddresses.html"})

public class addressesTest {
}


