package tpaPrueba.repos;

import java.io.Serializable;

import io.micronaut.data.jpa.repository.JpaRepository;
import tpaPrueba.ent.Base;


public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {
	
	
	
}
