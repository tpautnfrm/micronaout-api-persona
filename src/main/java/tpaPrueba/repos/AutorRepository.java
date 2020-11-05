package tpaPrueba.repos;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import tpaPrueba.ent.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor,Long> {
}
