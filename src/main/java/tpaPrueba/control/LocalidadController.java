package tpaPrueba.control;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import tpaPrueba.ent.Localidad;
import tpaPrueba.serv.LocalidadServiceImpl;

@Controller("api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {

	@Override
	@Get("/")
	public HttpResponse<?> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Get("/paged")
	@Override
	public HttpResponse<?> getAll(@Body Pageable pageable) {
		// TODO Auto-generated method stub
		return super.getAll(pageable);
	}

	@Get("/{id}")
	@Override
	public HttpResponse<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return super.getOne(id);
	}

	@Override
	@Post("/")
	public HttpResponse<?> save(@Body Localidad entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	@Override
	@Put("/{id}")
	public HttpResponse<?> update(@PathVariable Long id, Localidad entity) {
		// TODO Auto-generated method stub
		return super.update(id, entity);
	}

	@Override
	@Delete("/{id}")
	public HttpResponse<?> delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

}
