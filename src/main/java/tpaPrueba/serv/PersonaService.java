package tpaPrueba.serv;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import tpaPrueba.ent.Persona;
import tpaPrueba.repos.PersonaRepository;

@Singleton
public class PersonaService {

    @Inject
    private PersonaRepository personaRepository;

    public Iterable<Persona> getAll(){
        return personaRepository.findAll();
    }

    public Optional<Persona> findOne(Long id){
        return personaRepository.findById(id);
    }

    public Iterable<Persona> getByNombreOrApellido(String nombre, String apellido){
        return personaRepository.findByNombreContainsOrApellidoContains(nombre, apellido);
    }

    public Persona saveOrUpdate(Persona entity){
        Persona personaSaved = null;

        if (entity.getId()!=null && personaRepository.existsById(entity.getId())) {
            personaSaved = personaRepository.update(entity);
        } else {
            personaSaved = personaRepository.save(entity);
        }

        return personaSaved; }

    public void deletePersona(Long id){
        personaRepository.deleteById(id);

    }
}
