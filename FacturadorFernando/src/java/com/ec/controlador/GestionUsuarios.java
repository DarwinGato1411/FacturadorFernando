/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author gato
 */
public class GestionUsuarios {

    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private List<Tipoambiente> listaTipoAmbiente = new ArrayList<Tipoambiente>();

    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";

    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    private Boolean esVisisible = Boolean.FALSE;
    
    private String nombreUsuario = " ";
    private String amCodigo = "2";

    public GestionUsuarios() {

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());

       consultarUsuarios();
    }

//    private void consultarUsuarios(){
//        listaTipoAmbiente =servicioTipoAmbiente.findALlTipoambientePorUsuarioAdm(amRuc, amRuc)
//    }
    @Command
    @NotifyChange("listaTipoAmbiente")
    public void consultarUsuarioPorCodigo() {
        consultarUsuarios();
    }

    private void consultarUsuarios() {
        listaTipoAmbiente = servicioTipoAmbiente.findALlTipoambientePorUsuarioAdm(nombreUsuario, amCodigo);
    }

    /*ADMINISTRAR USUARIO*/
    private void cosultarUsuarios() {
        listaUsuarios = servicioUsuario.FindALlUsuarioPorLikeNombre(nombreUsuario, credential.getUsuarioSistema());
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    //usuarios
    @Command
    @NotifyChange("listaUsuarios")
    public void agregarUsario() {
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevo/usuario.zul", null, null);
        window.doModal();
        cosultarUsuarios();
    }

    @Command
    @NotifyChange("listaUsuarios")
    public void modificarUsario(@BindingParam("valor") Usuario usuario) {
        final HashMap<String, Usuario> map = new HashMap<String, Usuario>();
        map.put("usuario", usuario);
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                "/nuevoadmin/usuario.zul", null, map);
        window.doModal();
        cosultarUsuarios();
    }

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public Boolean getEsVisisible() {
        return credential.getUsuarioSistema().getUsuNivel() == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setEsVisisible(Boolean esVisisible) {
        this.esVisisible = esVisisible;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<Tipoambiente> getListaTipoAmbiente() {
        return listaTipoAmbiente;
    }

    public void setListaTipoAmbiente(List<Tipoambiente> listaTipoAmbiente) {
        this.listaTipoAmbiente = listaTipoAmbiente;
    }

    public String getAmCodigo() {
        return amCodigo;
    }

    public void setAmCodigo(String amCodigo) {
        this.amCodigo = amCodigo;
    }
    
    
}
