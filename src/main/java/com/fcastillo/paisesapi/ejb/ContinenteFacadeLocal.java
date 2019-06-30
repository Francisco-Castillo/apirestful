
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.Continente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fcastillo
 */
@Local
public interface ContinenteFacadeLocal {

    void create(Continente continente);

    void edit(Continente continente);

    void remove(Continente continente);

    Continente find(Object id);

    List<Continente> findAll();

    List<Continente> findRange(int[] range);

    int count();

    List<Continente> findByParameters(Integer offset, Integer limit);

    boolean exists(int idContinente);

}
