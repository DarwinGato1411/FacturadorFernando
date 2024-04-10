/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.controlador.superadmin.entidad.ConsumoClientes;
import com.ec.controlador.superadmin.servicio.ServicioConsumoClientes;
import com.ec.entidad.NumeroDocumentosEmitidos;
import com.ec.entidad.Parametrizar;
import com.ec.seguridad.AutentificadorLogeo;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.GrupoUsuarioEnum;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioParametrizar;
import com.ec.vista.servicios.ServicioNumeroDocumentosEmitidos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class LoginController extends SelectorComposer<Component> {

    /**
     *
     */
    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
    ServicioNumeroDocumentosEmitidos servicioNumeroDocumentosEmitidos = new ServicioNumeroDocumentosEmitidos();
    private static final long serialVersionUID = 1L;
    @Wire
    Textbox account;
    @Wire
    Textbox password;
    @Wire
    Label message;

    Integer numeroDocumentos = 0;

    ServicioConsumoClientes servicioConsumoCliente = new ServicioConsumoClientes();
    private List<ConsumoClientes> listaClienteses = new ArrayList<ConsumoClientes>();
    private ConsumoClientes consumoDocumentos;

    public void LoginController() {

    }

    @Listen("onClick=#buttonEntrar; onOK=#loginWin")
    public void doLogin() {
        Date actual = new Date();
        Date caduca = new Date();
        listaClienteses = servicioConsumoCliente.findAll();
        for (ConsumoClientes item : listaClienteses) {
            if (item.getDetalleCobroPlanContratado().contains("ILIMIT")) {

            } else {
                consumoDocumentos = item;
            }
        }

        boolean bloquear = false;

        Parametrizar cantidadContratada = servicioParametrizar.FindALlParametrizar();
        if (cantidadContratada.getParContratado().intValue() <= consumoDocumentos.getDocumentos().intValue() || cantidadContratada.getParBloqueoSistema()) {
            bloquear = Boolean.TRUE;
        } else {
            bloquear = Boolean.FALSE;
        }

        AutentificadorLogeo servicioAuth = new AutentificadorLogeo();
        if (servicioAuth.login(account.getValue(), password.getValue())) {
            Session sess = Sessions.getCurrent();
            UserCredential cre = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
            if (cre.getUsuarioSistema().getUsuLogin().toUpperCase().contains("SUPER")) {
                Executions.sendRedirect("/superadmin/consumo.zul");
            }

            if (cre.getNivelUsuario().intValue() == GrupoUsuarioEnum.USUARIO.getCodigo()) {
                NumeroDocumentosEmitidos emitidos = servicioNumeroDocumentosEmitidos.findByEmpresa(cre.getTipoambiente().getCodTipoambiente());

                numeroDocumentos = emitidos == null ? 0 : emitidos.getNumero().intValue();

                if (cre.getUsuarioSistema().getUsuIlimitado()) {
                    if (bloquear) {
                        Clients.showNotification("<div style:'width=200px;'>El sistema se encuentra inactivo<br/> Por favor verifique con el proveedor</div>",
                                Clients.NOTIFICATION_TYPE_ERROR, null, "top_left", 30000, true);
                        return;
                    }
                    if (cre.getUsuarioSistema().getUsuFechaPago().after(actual)) {
                        Executions.sendRedirect("/venta/facturar.zul");
                    } else {
                        Clients.showNotification("<div style:'width=200px;'>Su plan ilimitado no ha sido<br/> renovado contactese con el administrador.</div>",
                                Clients.NOTIFICATION_TYPE_ERROR, null, "top_left", 3000, true);
                    }

                } else {
                    if (bloquear) {
                        Clients.showNotification("<div style:'width=200px;'>El sistema se encuentra inactivo<br/> Por favor verifique con el proveedor</div>",
                                Clients.NOTIFICATION_TYPE_ERROR, null, "top_left", 3000, true);
                        return;
                    }
                    if (cre.getUsuarioSistema().getUsuTotalContratado() > numeroDocumentos) {
                        Executions.sendRedirect("/venta/facturar.zul");

                    } else {
                        Clients.showNotification("<div style:'width=200px;'>El número de documentos emitidos<br/> supera al número de documentos contratado.</div>",
                                Clients.NOTIFICATION_TYPE_ERROR, null, "top_left", 3000, true);

                    }

                }

            } else if (cre.getNivelUsuario().intValue() == GrupoUsuarioEnum.ADMINISTRADOR.getCodigo()) {

                Executions.sendRedirect("/administrar/consumo.zul");

            } else if (cre.getNivelUsuario().intValue() == GrupoUsuarioEnum.SUPERADMIN.getCodigo()) {

                Executions.sendRedirect("/superadmin/consumo.zul");

            }

        } else {
            Clients.showNotification("<div  style='width:200px;'>Usuario o Contraseña incorrecto.<br/>Contáctese con el administrador.</div>",
                    Clients.NOTIFICATION_TYPE_ERROR, null, "top_left", 3000, true);
        }

    }

    @Listen("onClick= #linkOlvideContrasena")
    public void linkOlvideContrasena() {
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/olvidemiclave.zul", null, null);
        window.doModal();
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
    }

    @Listen("onClick = #buttonConsultar")
    public void buttonConsultar() {
        Executions.sendRedirect("/consultas.zul");
    }

    @Listen("onClick = #btnRegistra")
    public void btnRegistra() {
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/registrousuario.zul", null, null);
        window.doModal();

    }
}
