package tpaPrueba.control;


import javax.inject.Inject;

import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import tpaPrueba.ent.Base;
import tpaPrueba.serv.BaseServiseImpl;




public abstract class BaseControllerImpl<E extends Base, S extends BaseServiseImpl<E, Long>> implements BaseController<E, Long> {

    @Inject
    protected S servicio;

//    private final S servicio;
//
//    @Inject
//    public BaseControllerImpl( S service) {
//        this.servicio = service;
//    }
    
//    protected S servicio;
//
//    public BaseControllerImpl(S service){
//        this.servicio=service;
//    }
    
    
    @Override
    @Get("/")
    public HttpResponse<?> getAll(){
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.findall());
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Get("/paged")
    public HttpResponse<?> getAll(Pageable pageable){
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.findall(pageable));
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Get("/{id}")
    public HttpResponse<?> getOne(@PathVariable Long id){
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.findById(id));
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Post("")
    public HttpResponse<?> save(@Body E entity){
        try {
            return HttpResponse.status(HttpStatus.OK).body(
                    servicio.save(entity)
            );
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Put("/{id}")
    public HttpResponse<?> update(@PathVariable Long id, @Body E entity){
        try {
            return HttpResponse.status(HttpStatus.OK).body(servicio.update(id, entity));
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }

    @Delete("/{id}")
    public HttpResponse<?> delete(@PathVariable Long id){
        try {
            return HttpResponse.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }catch (Exception e){
            return HttpResponse.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
        }
    }
}
