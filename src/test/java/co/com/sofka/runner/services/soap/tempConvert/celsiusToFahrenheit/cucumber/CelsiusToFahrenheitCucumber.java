package co.com.sofka.runner.services.soap.tempConvert.celsiusToFahrenheit.cucumber;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/soap/tempConvert/celsiusToFahrenheit/celsiusToFahrenheit.feature"},
        glue = {"co.com.sofka.stepdefinition.services.soap.tempConvert.celsiusToFahrenheit"}
)


public class CelsiusToFahrenheitCucumber {


}
