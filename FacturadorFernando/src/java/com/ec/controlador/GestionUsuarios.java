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
import org.zkoss.zul.Messagebox;

/**
 *
 * @author gato
 */
public class GestionUsuarios {
    
    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    
    private List<Tipoambiente> listaTipoambientes = new ArrayList<Tipoambiente>();
    
    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private Boolean activo = Boolean.TRUE;
    
    private Boolean esVisisible = Boolean.FALSE;
    
    private String amCodigo = "2";
    private String nombreUsuario = "";
    
    public GestionUsuarios() {
        
        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema(), activo);
        
        consultarUsuarios();
    }

    /*ADMINISTRAR USUARIO*/
    private void cosultarUsuarios(String buscar) {
        listaUsuarios = servicioUsuario.FindALlUsuarioPorLikeNombre(buscar, credential.getUsuarioSistema(), activo);
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    @Command
    @NotifyChange("listaTipoambientes")
    public void consultarUsuariosPorCodigo() {
        consultarUsuarios();
    }

    @Command
    @NotifyChange("listaTipoambientes")
    public void desactivarUsuario(@BindingParam("valor") Tipoambiente tipoambiente) {
        if (Messagebox.show("El usuario se desactivará" + "\n Desea continuar?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION) == Messagebox.OK) {
            tipoambiente.setAmActivo(Boolean.FALSE);
            servicioTipoAmbiente.modificar(tipoambiente);
            consultarUsuarios();
        }
    }
    @Command
    @NotifyChange("listaTipoambientes")
    public void activarUsuario(@BindingParam("valor") Tipoambiente tipoambiente) {
        if (Messagebox.show("El usuario se activará" + "\n Desea continuar?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION) == Messagebox.OK) {
            tipoambiente.setAmActivo(Boolean.TRUE);
            servicioTipoAmbiente.modificar(tipoambiente);
            consultarUsuarios();
        }
    }
    
    private void consultarUsuarios() {
        listaTipoambientes = servicioTipoAmbiente.findALlTipoambientePorUsuarioAdm(nombreUsuario, amCodigo, activo);
    }

    //usuarios
    @Command
    @NotifyChange("listaUsuarios")
    public void agregarUsario() {
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/nuevo/usuario.zul", null, null);
        window.doModal();
        cosultarUsuarios("");
    }
    
    @Command
    @NotifyChange("listaUsuarios")
    public void modificarUsario(@BindingParam("valor") Usuario usuario) {
        final HashMap<String, Usuario> map = new HashMap<String, Usuario>();
        map.put("usuario", usuario);
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/nuevoadmin/usuario.zul", null, map);
        window.doModal();
        cosultarUsuarios("");
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
    
    public String getAmRuc() {
        return amRuc;
    }
    
    public void setAmRuc(String amRuc) {
        this.amRuc = amRuc;
    }
    
    public String getAmCodigo() {
        return amCodigo;
    }
    
    public void setAmCodigo(String amCodigo) {
        this.amCodigo = amCodigo;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public List<Tipoambiente> getListaTipoambientes() {
        return listaTipoambientes;
    }
    
    public void setListaTipoambientes(List<Tipoambiente> listaTipoambientes) {
        this.listaTipoambientes = listaTipoambientes;
    }
    
    public Tipoambiente getAmb() {
        return amb;
    }
    
    public void setAmb(Tipoambiente amb) {
        this.amb = amb;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
}
