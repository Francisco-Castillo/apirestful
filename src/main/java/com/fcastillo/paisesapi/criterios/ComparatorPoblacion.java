/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.criterios;

import com.fcastillo.paisesapi.Pais;
import java.util.Comparator;

/**
 *
 * @author fcastillo
 */
public class ComparatorPoblacion implements Comparator<Pais> {

    @Override
    public int compare(Pais o1, Pais o2) {
        int respuesta;
        if (o1.getPaisPoblacion() > o2.getPaisPoblacion()) {
            respuesta = 1;
        } else if (o1.getPaisPoblacion() < o2.getPaisPoblacion()) {
            respuesta = -1;
        } else {
            respuesta = 0;
        }
        return respuesta;
    }

}
