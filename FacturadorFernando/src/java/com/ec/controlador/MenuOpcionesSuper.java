/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

/**
 *
 * @author gato
 */
public class MenuOpcionesSuper extends SelectorComposer<Component> {

    
            
    UserCredential credential = new UserCredential();
    private String acceso = "";

    public MenuOpcionesSuper() {
        Session sess = Sessions.getCurrent();
        UserCredential cre = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
        credential = cre;
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        
    }

    @Listen("onClick = #menuPlanEmpresa")
    public void buttonConsultar() {
        Executions.sendRedirect("/superadmin/planempresa.zul");
    }
    @Listen("onClick = #menuparametrizar")
    public void menuparametrizar() {
        Executions.sendRedirect("/superadmin/parametrizar.zul");
    }

   
}
