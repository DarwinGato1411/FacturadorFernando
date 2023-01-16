/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Guiaremision;
import com.ec.servicio.ServicioGuia;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class CambioEstadoGuia {

    @Wire
    Window windowEstFact;
    private Guiaremision entidad;
    private String estado;
    private String descripcionAnula;
    ServicioGuia servicioRetencionCompra = new ServicioGuia();

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("valor") Guiaremision valor, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        this.entidad = valor;
        estado = valor.getFacEstado()!= null ? valor.getFacEstado() : "";
    }

    @Command
    public void guardar() {

//            facturar.setEstadosri(estado);
//            facturar.setMensajesri(descripcionAnula);
        servicioRetencionCompra.modificar(entidad);

        Clients.showNotification("Guardado correctamente",
                    Clients.NOTIFICATION_TYPE_INFO, null, "end_center", 1000, true);
        windowEstFact.detach();
//        } else {
//            Clients.showNotification("Verifique el estado de la factura",
//                    Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 3000, true);
//            windowEstFact.detach();
//        }

    }

    public Guiaremision getEntidad() {
        return entidad;
    }

    public void setEntidad(Guiaremision entidad) {
        this.entidad = entidad;
    }

 
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcionAnula() {
        return descripcionAnula;
    }

    public void setDescripcionAnula(String descripcionAnula) {
        this.descripcionAnula = descripcionAnula;
    }

}