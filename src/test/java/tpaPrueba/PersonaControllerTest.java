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
import tpaPrueba.ent.Persona;

@MicronautTest
public class PersonaControllerTest {

    @Inject
    @Client("/api/v1/personas")
    RxHttpClient client;

    @Test
    void testPersona() {
        Persona testSave = new Persona();
        testSave.setNombre("TPA2020");
        testSave.setApellido("Apellido");
        testSave.setDni(123456789);

        Flowable<HttpResponse<Persona>> result = client.exchange(HttpRequest.POST("/savePersona", testSave), Persona.class);

        Persona pers = result.blockingFirst().getBody().get();

        assertEquals("TPA2020", pers.getNombre());
        assertEquals("Apellido", pers.getApellido());
        assertEquals(123456789, pers.getDni());
    }
}
