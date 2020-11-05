package tpaPrueba.control;

import javax.inject.Inject;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import tpaPrueba.ent.Persona;
import tpaPrueba.serv.PersonaService;


@Controller("api/v1/personas")
public class PersonaController {

    @Inject
    private PersonaService personaService;

    @Get
    public HttpResponse<?> findAll(){
        try {
            return HttpResponse.status(HttpStatus.OK).body(personaService.getAll());
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/{id}")
    public HttpResponse<?> findOne(@Parameter Long id){
        try {
            return HttpResponse.status(HttpStatus.OK).body(personaService.findOne(id));
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/search")
    public HttpResponse<?> findPersonaByNombreOrApellido(@QueryValue String filtro){
        try{
             return HttpResponse.status(HttpStatus.OK).body(personaService.getByNombreOrApellido(filtro,filtro));
    }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Post("/savePersona")
    public HttpResponse<?> saveOrUpdate(@Body Persona entity) {
        try{
            return HttpResponse.status(HttpStatus.OK).body(personaService.saveOrUpdate(entity));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }


    }

    @Delete("delete/{id}")
    public HttpResponse<?> delete(Long id) {
        try {
            personaService.deletePersona(id);
            return HttpResponse.status(HttpStatus.OK);
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
