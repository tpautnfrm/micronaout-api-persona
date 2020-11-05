package tpaPrueba.serv;


import javax.inject.Singleton;

import io.micronaut.core.annotation.Introspected;
import tpaPrueba.ent.Localidad;
import tpaPrueba.repos.BaseRepository;

@Singleton() 
@Introspected
public class LocalidadServiceImpl extends BaseServiseImpl<Localidad, Long> implements LocalidadService {

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}