/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.ejb;

import com.fcastillo.paisesapi.Provincia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author fcastillo
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> implements ProvinciaFacadeLocal {

    @PersistenceContext(unitName = "com.fcastillo_paisesAPI_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }

    @Override
    public List<Provincia> getList(int id, int limit, int offset, String search) {
        int pageNumber = offset;
        int pageSize = limit;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(Provincia.class)));
        Long count = em.createQuery(countQuery).getSingleResult();

        CriteriaQuery<Provincia> criteriaQuery = cb.createQuery(Provincia.class);
        Root<Provincia> from = criteriaQuery.from(Provincia.class);
        CriteriaQuery<Provincia> select = criteriaQuery.select(from);

        TypedQuery<Provincia> tq = em.createQuery(select);
        while (pageNumber < count.intValue()) {
            tq.setFirstResult(pageNumber - 1);
            tq.setMaxResults(pageSize);
            pageNumber += pageSize;

        }
        return tq.getResultList();
    }

}
