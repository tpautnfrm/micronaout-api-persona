package tpaPrueba.control;


import java.io.Serializable;

import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import tpaPrueba.ent.Base;

public interface BaseController<E extends Base, ID extends Serializable> {
	HttpResponse<?> getAll();
	HttpResponse<?> getAll(Pageable pageable);
	HttpResponse<?> getOne(@PathVariable ID id);
	HttpResponse<?> save(@Body E entity);
	HttpResponse<?> update(@PathVariable ID id, @Body E entity);
	HttpResponse<?> delete(@PathVariable ID id);
}
