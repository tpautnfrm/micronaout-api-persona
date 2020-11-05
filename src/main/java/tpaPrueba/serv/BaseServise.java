package tpaPrueba.serv;

import java.io.Serializable;
import java.util.List;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import tpaPrueba.ent.Base;

public interface BaseServise<E extends Base, ID extends Serializable> {
    List<E> findall() throws Exception;
    Page<E> findall(Pageable pageable) throws Exception;
    E findById(ID id) throws Exception;
    E save(E entity) throws Exception;
    E update(ID id, E entity) throws Exception;
    boolean delete(ID id) throws Exception;
}