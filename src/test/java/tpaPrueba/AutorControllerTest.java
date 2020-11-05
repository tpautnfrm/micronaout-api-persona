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
import tpaPrueba.ent.Autor;

@MicronautTest
public class AutorControllerTest {

    @Inject
    @Client("/api/v1/autores")
    RxHttpClient client;

    @Test
    void testAutor(){
        Autor testSave = new Autor();
        testSave.setNombre("Peter");
        testSave.setApellido("Pan");
        testSave.setBiografia("Peter Pan es un eterno nino que vive en el pais de Nunca Jamas y desde alli nos cuenta maravillosas historias.");

        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.POST("/saveAutor", testSave), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals("Peter", autor.getNombre());
        assertEquals("Pan", autor.getApellido());
        assertEquals("Peter Pan es un eterno nino que vive en el pais de Nunca Jamas y desde alli nos cuenta maravillosas historias.", autor.getBiografia());

    }

}
