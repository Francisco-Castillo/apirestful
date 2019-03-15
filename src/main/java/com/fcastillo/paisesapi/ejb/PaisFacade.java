/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.Pais;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author fcastillo
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {

    @PersistenceContext(unitName = "com.fcastillo_paisesAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    @Override
    public List<Pais> findByParameters(Integer offset, Integer limit) {
        String consulta;
        List<Pais> lstPaises = null;
        try {
            consulta = "FROM Pais p";
            Query q = em.createQuery(consulta);
            if (offset != null) {
                q.setFirstResult(offset);
            }

            if (limit != null) {
                q.setMaxResults(limit);
            }
            lstPaises = q.getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lstPaises;
    }

    @Override
    public List<Pais> findByNameLike(String nombre) {
        nombre = nombre.trim();
        StringTokenizer st = new StringTokenizer(nombre);
        String texto="";
        while(st.hasMoreTokens()){
            if (!texto.equals("")) {
                  texto+="%";
            }
            texto += " "+st.nextToken();
        }
        nombre = "%" +texto.trim() + "%";
        Query query = em.createQuery("SELECT a FROM Pais a WHERE CONCAT (lower(a.paisNombreLargo),' ',lower(a.paisNombreCorto)) like ?1");
        query.setParameter(1, nombre);
        return query.getResultList();
    }

}
