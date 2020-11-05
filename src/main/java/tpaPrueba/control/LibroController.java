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
import tpaPrueba.ent.Libro;
import tpaPrueba.serv.LibroService;

@Controller("api/v1/libros")
public class LibroController {

    @Inject
    private LibroService libroService;

    @Get
    public HttpResponse<?> findAll(){
        try {
            return HttpResponse.status(HttpStatus.OK).body(libroService.getAll());
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/{id}")
    public HttpResponse<?> findOne(@Parameter Long id){
        try {
            return HttpResponse.status(HttpStatus.OK).body(libroService.findOne(id));
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/titulo/{filtro}")
    public HttpResponse<?> findLibroByTitulo(@Parameter String filtro){
        try{
            return HttpResponse.status(HttpStatus.OK).body(libroService.findTitulo(filtro));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/genero/{filtro}")
    public HttpResponse<?> findLibroByGenero(@Parameter String filtro){
        try{
            return HttpResponse.status(HttpStatus.OK).body(libroService.findGenero(filtro));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Post("/saveLibro")
    public HttpResponse<?> saveOrUpdate(@Body Libro entity) {
        try{
            return HttpResponse.status(HttpStatus.OK).body(libroService.saveOrUpdate(entity));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }


    }

    @Delete("delete/{id}")
    public HttpResponse<?> delete(Long id) {
        try {
            libroService.deleteLibro(id);
            return HttpResponse.status(HttpStatus.OK);
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }


}
