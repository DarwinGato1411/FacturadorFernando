/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.dao.DetalleFacturaDAO;
import com.ec.entidad.NumeroDocumentosEmitidos;
import com.ec.entidad.Usuario;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.vista.servicios.ServicioNumeroDocumentosEmitidos;
import java.util.HashMap;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author gato
 */
public class MenuToolbar {

    UserCredential credential = new UserCredential();
    ServicioNumeroDocumentosEmitidos servicioNumeroDocumentosEmitidos = new ServicioNumeroDocumentosEmitidos();

    String utilizados = "";
    String contratado = "";

    public MenuToolbar() {
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
        credential = cre;

        if (credential.getUsuarioSistema() != null) {
            if (credential.getUsuarioSistema().getUsuNivel() == 2) {
                NumeroDocumentosEmitidos emitidos = servicioNumeroDocumentosEmitidos.findByEmpresa(cre.getTipoambiente().getCodTipoambiente());

                Integer docEmitido = emitidos == null ? 0 : emitidos.getNumero().intValue();
                utilizados = "UTILIZADO: " + docEmitido;
                if (!cre.getUsuarioSistema().getUsuIlimitado()) {
                    Integer docContratado = cre.getUsuarioSistema().getUsuTotalContratado().intValue();
                    contratado = "CONTRATADO: " + docContratado;

                } else {
                    contratado = "CONTRATADO: ILIMITADO";
                }
            }
        }

    }

    @Command
    public void facturar(@BindingParam("valor") DetalleFacturaDAO valor) {
        Executions.sendRedirect("/venta/facturar.zul");
    }

    @Command
    public void nuevoCliente() {

        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/cliente.zul", null, null);
        window.doModal();

    }

    @Command
    public void nuevoProducto() {

        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/producto.zul", null, null);
        window.doModal();

    }

    @Command
    public void modificarUsuario() {
        final HashMap<String, Usuario> map = new HashMap<String, Usuario>();
        map.put("usuario", credential.getUsuarioSistema());
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/usuario.zul", null, map);
        window.doModal();

    }

    public String getUtilizados() {
        return utilizados;
    }

    public void setUtilizados(String utilizados) {
        this.utilizados = utilizados;
    }

    public String getContratado() {
        return contratado;
    }

    public void setContratado(String contratado) {
        this.contratado = contratado;
    }

}
