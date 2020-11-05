package tpaPrueba.repos;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import tpaPrueba.ent.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro,Long> {

    @Executable
    Iterable<Libro> findByGeneroContains(String genero);

    @Executable
    Iterable<Libro> findByTituloContains(String titulo);


}
