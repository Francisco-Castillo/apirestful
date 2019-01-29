/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.Continente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fcastillo
 */
@Stateless
public class ContinenteFacade extends AbstractFacade<Continente> implements ContinenteFacadeLocal {

    @PersistenceContext(unitName = "com.fcastillo_paisesAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContinenteFacade() {
        super(Continente.class);
    }

    @Override
    public List<Continente> findByParameters(Integer offset, Integer limit) {
       String consulta;
        List<Continente> lstContinente = null;
        try {
            consulta = "FROM Continente p";
            Query q = em.createQuery(consulta);
            if (offset != null) {
                q.setFirstResult(offset);
            }

            if (limit != null) {
                q.setMaxResults(limit);
            }
            lstContinente = q.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lstContinente;
    }
    
}
