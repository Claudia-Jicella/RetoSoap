package co.com.sofka.stepdefinition.services.soap.tempConvert.celsiusToFahrenheit;

import co.com.sofka.models.TempConvertC;
import co.com.sofka.models.TempConvertE;
import co.com.sofka.stepdefinition.ServiceSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static co.com.sofka.questions.RestumSoapServiceResponse.resturnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.FileUtilities.readFile;
import static co.com.sofka.utils.service.soap.TempConvert.CelsiusToFahrenheit.Patch.CONVERT;
import static co.com.sofka.utils.service.soap.TempConvert.CelsiusToFahrenheit.Response.CONVERT_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class CelsiusToFahrenheitStepDefinition extends ServiceSetup {

    private static final Logger LOGGER = Logger.getLogger(CelsiusToFahrenheitStepDefinition.class);

    private TempConvertC tempConvertC;

    //Escenario Congelacion
    @Given("que el usuario necesita saber el punto de congelacion del agua en grados Fahrenheit")
    public void queElUsuarioNecesitaSaberElPuntoDeCongelacionDelAguaEnGradosFahrenheit() {

        try {
            super.setup();
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(), exception);
        }


    }

    @When("el usuario digite {int} grados celsius y ejecute el calculo de conversión de temperatura")
    public void elUsuarioDigiteGradosCelsiusYEjecuteElCalculoDeConversionDeTemperatura(Integer conversionA) {

        try {
            tempConvertC = new TempConvertC();
            tempConvertC.setA(conversionA);
            actor.attemptsTo(
                    doPost()
                            .withTheResource(RESOURCE)
                            .andTheHeaders(super.headers())
                            .andTheBodyRequest(bodyRequestC())
            );
        }catch (Exception exception){
            LOGGER.warn(exception.getMessage(), exception);
        }


    }

    @Then("el usuario debera obtener como resultado {int} grados")
    public void elUsuarioDeberaObtenerComoResultadoGrados(Integer resultadoC) {
        tempConvertC.setOutcome(resultadoC);

        try{
            actor.should(
                    seeThatResponse("El código de rspuesta HTTP debe ser: ",
                            response -> response.statusCode(HttpStatus.SC_OK)),
                    seeThat("El resultado de la conversion debe ser: ",
                            resturnSoapServiceResponse(),
                            containsString(bodyResponseC()))
                    );

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage(), exception);
        }

    }

    private TempConvertC tempConvertC(){
        return tempConvertC;
    }

    private String bodyRequestC(){
        return String.format(readFile(CONVERT.getValue()), tempConvertC().getA());


    }
    private String bodyResponseC(){
        return String.format(CONVERT_RESPONSE.getValue(), tempConvertC().getOutcome());

    }


    private TempConvertE tempConvertE;

    //Escenario Ebullicion
    @Given("que el usuario quiere conocer punto de ebullición en grados Fahrenheit")
    public void queElUsuarioQuiereConocerPuntoDeEbullicionEnGradosFahrenheit() {
        super.setup();
    }

    @When("el usuario ingrese {int} grados celsius")
    public void elUsuarioIngreseGradosCelsius(Integer conversionB) {
        tempConvertE = new TempConvertE();
        tempConvertE.setE(conversionB);
        
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequestE())
        );

    }

    @Then("obtendra como resultado {int} grados Fahrenheit")
    public void obtendraComoResultadoGradosFahrenheit(Integer resultadoE) {

        tempConvertE.setOutcomeE(resultadoE);
        actor.should(
                seeThatResponse("El código de rspuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la conversion debe ser: ",
                        resturnSoapServiceResponse(),
                        containsString(bodyResponseE()))

        );

    }

    private TempConvertE tempConvertE() {
        return tempConvertE;
    }

    private String bodyRequestE (){
        return String.format(readFile(CONVERT.getValue()), tempConvertE().getE());

    }

    private String bodyResponseE (){
        return String.format(CONVERT_RESPONSE.getValue(), tempConvertE().getOutcomeE());

    }
}
