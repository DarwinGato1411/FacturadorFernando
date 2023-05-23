/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador.superadmin;

import com.ec.entidad.Parametrizar;
import com.ec.entidad.VistaPlanEmpresa;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioParametrizar;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.vista.servicios.ServicioPlanEmpresa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

/**
 *
 * @author gato
 */
public class PlanEmpresaCtrl {

    private static String PATH_BASE = "";
    ServicioPlanEmpresa servicioPlanEmpresa = new ServicioPlanEmpresa();
    private List<VistaPlanEmpresa> listaPlanEmpresas = new ArrayList<>();
    private VistaPlanEmpresa vistaPlanEmpresa = new VistaPlanEmpresa();
    UserCredential credential = new UserCredential();

    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
    private Parametrizar parametrizar = null;

    //reporte
    public PlanEmpresaCtrl() {
         parametrizar = servicioParametrizar.FindALlParametrizar();
        consultaDatos();
    }

    private void consultaDatos() {
        
        listaPlanEmpresas = servicioPlanEmpresa.findAll();
        for (VistaPlanEmpresa listaPlanEmpresa : listaPlanEmpresas) {
            if (listaPlanEmpresa.getDetalleCobroPlanContratado().contains("DOCUMENTOS")) {
                listaPlanEmpresa.setTotal(parametrizar.getParDocContratado());
                 listaPlanEmpresa.setSaldo(parametrizar.getParDocContratado().subtract(listaPlanEmpresa.getDocumentos()));
            }else{
             listaPlanEmpresa.setTotal(BigDecimal.ZERO);
             listaPlanEmpresa.setSaldo(BigDecimal.ZERO);
            }
        }
        vistaPlanEmpresa = listaPlanEmpresas.get(0);
    }

//    @Command
//    @NotifyChange({"listaCabeceraCompras", "buscar"})
//    public void buscarPor() {
//
//    }
    public List<VistaPlanEmpresa> getListaPlanEmpresas() {
        return listaPlanEmpresas;
    }

    public void setListaPlanEmpresas(List<VistaPlanEmpresa> listaPlanEmpresas) {
        this.listaPlanEmpresas = listaPlanEmpresas;
    }

    public VistaPlanEmpresa getVistaPlanEmpresa() {
        return vistaPlanEmpresa;
    }

    public void setVistaPlanEmpresa(VistaPlanEmpresa vistaPlanEmpresa) {
        this.vistaPlanEmpresa = vistaPlanEmpresa;
    }

}
