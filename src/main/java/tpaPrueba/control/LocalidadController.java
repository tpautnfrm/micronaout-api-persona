package tpaPrueba.control;

import javax.inject.Inject;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import tpaPrueba.ent.Localidad;
import tpaPrueba.serv.AutorService;
import tpaPrueba.serv.LocalidadServiceImpl;

@Controller("api/v1/localidades")
@Introspected
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {

	@Inject
	private AutorService autorService;

	@Get("/blaa")
	public HttpResponse<?> findAlla() {
		try {
			return HttpResponse.status(HttpStatus.OK).body(autorService.getAll());
		} catch (Exception ex) {
			return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
		}
	}

	
	@Get("/blaaa")
	public HttpResponse<?> getAllab() {
		try {
			return HttpResponse.status(HttpStatus.OK).body(servicio.findall());
		} catch (Exception e) {
			return HttpResponse.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	
	@Get("/test")
	public HttpResponse<?> getAllTest() {
		return super.getAll();
	}

}
