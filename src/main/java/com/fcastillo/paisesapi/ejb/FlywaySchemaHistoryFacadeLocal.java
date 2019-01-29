/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.FlywaySchemaHistory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fcastillo
 */
@Local
public interface FlywaySchemaHistoryFacadeLocal {

    void create(FlywaySchemaHistory flywaySchemaHistory);

    void edit(FlywaySchemaHistory flywaySchemaHistory);

    void remove(FlywaySchemaHistory flywaySchemaHistory);

    FlywaySchemaHistory find(Object id);

    List<FlywaySchemaHistory> findAll();

    List<FlywaySchemaHistory> findRange(int[] range);

    int count();
    
}
