package co.com.sofka.runner.services.soap.tempConvert.FahrenheitToCelsius.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/soap/tempConvert/fahrenheitTocelsius/fahrenheitTocelsius.feature"},
        glue = {"co.com.sofka.stepdefinition.services.soap.tempConvert.fahrenheitToCelsius"}
)

public class FahrenheitToCelsiusCucumber {


}
