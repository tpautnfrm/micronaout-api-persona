package tpaPrueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.Flowable;
import tpaPrueba.ent.Localidad;

@MicronautTest
public class LocalidadControllerTest {

    @Inject
    @Client("/api/v1/localidades")
    RxHttpClient client;

    @Test
    void testLocalidad() {
        Localidad testSave = new Localidad();
        testSave.setDenominacion("Rodriguez 200");

        Flowable<HttpResponse<Localidad>> result = client.exchange(HttpRequest.POST("/saveLocalidad", testSave), Localidad.class);

        Localidad loc = result.blockingFirst().getBody().get();

        assertEquals("Rodriguez 200", loc.getDenominacion());
    }
}
