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
import tpaPrueba.ent.Autor;
import tpaPrueba.serv.AutorService;

@Controller("api/v1/autores")
public class AutorController {

    @Inject
    private AutorService autorService;

    @Get
    public HttpResponse<?> findAll(){
        try {
            return HttpResponse.status(HttpStatus.OK).body(autorService.getAll());
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/{id}")
    public HttpResponse<?> findOne(@Parameter Long id){
        try {
            return HttpResponse.status(HttpStatus.OK).body(autorService.findOne(id));
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Post("/saveAutor")
    public HttpResponse<?> saveOrUpdate(@Body Autor entity) {
        try{
            return HttpResponse.status(HttpStatus.OK).body(autorService.saveOrUpdate(entity));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }


    }

    @Delete("delete/{id}")
    public HttpResponse<?> delete(Long id) {
        try {
            autorService.deleteAutor(id);
            return HttpResponse.status(HttpStatus.OK);
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
