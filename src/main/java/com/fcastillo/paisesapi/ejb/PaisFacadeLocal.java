/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.Pais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fcastillo
 */
@Local
public interface PaisFacadeLocal {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findRange(int[] range);

    int count();

    List<Pais> findByParameters(Integer offset, Integer limit);

    List<Pais> findByNameLike(String nombre);

    List<Pais> findByContinente(int idContinente);

    Long cantidadTotalDePaises();

}
