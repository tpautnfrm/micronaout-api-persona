package tpaPrueba.repos;

import io.micronaut.data.annotation.Repository;
import tpaPrueba.ent.Localidad;


@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{
}
