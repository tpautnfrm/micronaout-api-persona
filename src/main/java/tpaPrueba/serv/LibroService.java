package tpaPrueba.serv;


import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import tpaPrueba.ent.Libro;
import tpaPrueba.repos.LibroRepository;

@Singleton
public class LibroService{
    @Inject
    LibroRepository libroRepository;

    public Iterable<Libro> getAll(){
        return libroRepository.findAll();
    }

    public Optional<Libro> findOne(Long id){
        return libroRepository.findById(id);
    }

    public Iterable<Libro> findTitulo(String titulo){
        return libroRepository.findByTituloContains(titulo);
    }

    public Iterable<Libro> findGenero(String genero){
        return libroRepository.findByGeneroContains(genero);
    }

    public Libro saveOrUpdate(Libro entity){
        Libro libroSaved = null;

        if (entity.getId() != null && libroRepository.existsById(entity.getId())) {
            libroSaved = libroRepository.update(entity);
        } else {
            libroSaved = libroRepository.save(entity);
        }

        return libroSaved;
    }

    public void deleteLibro(Long id){
        libroRepository.deleteById(id);

    }
}
