/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.vista.servicios;

import com.ec.entidad.VistaPlanEmpresa;
import com.ec.servicio.HelperPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author gato
 */
public class ServicioPlanEmpresa {

    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<VistaPlanEmpresa> findAll() {

        List<VistaPlanEmpresa> listaCantVentProductoss = new ArrayList<VistaPlanEmpresa>();
        try {
            em = HelperPersistencia.getEMF();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM VistaPlanEmpresa a");
            listaCantVentProductoss = (List<VistaPlanEmpresa>) query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en lsa consulta CantVentProductos " + e.getMessage());
        } finally {
            em.close();
        }

        return listaCantVentProductoss;
    }

}
