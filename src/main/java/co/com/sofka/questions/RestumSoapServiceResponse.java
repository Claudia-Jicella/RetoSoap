package co.com.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.nio.charset.StandardCharsets;

public class RestumSoapServiceResponse implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String response = new String(LastResponse.received().answeredBy(actor).asByteArray(), StandardCharsets.UTF_8);
        System.out.printf(response);
        return response;
    }
    
    public static RestumSoapServiceResponse resturnSoapServiceResponse(){
        return new RestumSoapServiceResponse();
    }

}
