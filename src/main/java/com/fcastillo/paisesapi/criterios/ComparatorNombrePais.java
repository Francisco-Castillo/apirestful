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
public class ComparatorNombrePais implements Comparator<Pais> {

    @Override
    public int compare(Pais o1, Pais o2) {
        return o1.getPaisNombreCorto().compareTo(o2.getPaisNombreCorto());
    }

}
