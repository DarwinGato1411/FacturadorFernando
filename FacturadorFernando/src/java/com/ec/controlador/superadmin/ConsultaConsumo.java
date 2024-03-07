/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador.superadmin;

import com.ec.controlador.superadmin.entidad.ConsumoClientes;
import com.ec.controlador.superadmin.servicio.ServicioConsumoCliente;
import com.ec.entidad.Guiaremision;
import com.ec.entidad.NotaCreditoDebito;
import com.ec.entidad.Parametrizar;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.HelperPersistencia;
import com.ec.servicio.ServicioParametrizar;
import com.ec.servicio.ServicioTipoAmbiente;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author gato
 */
public class ConsultaConsumo {

    /*RUTAS PARA LOS ARCHIVPOS XML SRI*/
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    ServicioConsumoCliente servicioConsumoCliente = new ServicioConsumoCliente();

    private List<ConsumoClientes> listaClienteses = new ArrayList<ConsumoClientes>();
    //reporte

    Connection con = null;
    AMedia fileContent = null;

    private String buscar = "";

    UserCredential credential = new UserCredential();

    private ConsumoClientes consumoIlimitado;
    private ConsumoClientes consumoDocumentos;

    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
    private Parametrizar parametrizar = null;
    private BigDecimal recargar = BigDecimal.ZERO;
    private BigDecimal saldoDocumentos = BigDecimal.ZERO;
    private Boolean pintar = Boolean.FALSE;

    public ConsultaConsumo() {

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
        parametrizar = servicioParametrizar.FindALlParametrizar();
        consultarConsumo();
    }

    private void consultarConsumo() {
        listaClienteses = servicioConsumoCliente.findAll();
        for (ConsumoClientes item : listaClienteses) {
            if (item.getDetalleCobroPlanContratado().contains("ILIMIT")) {
                consumoIlimitado = item;
            } else {
                consumoDocumentos = item;
            }
           
        }
     saldoDocumentos = parametrizar.getParContratado().subtract(BigDecimal.valueOf(consumoDocumentos.getDocumentos().doubleValue()));
     pintar=saldoDocumentos.doubleValue()<0?Boolean.TRUE:Boolean.FALSE;
    }

    @Command
    @NotifyChange({"consumoIlimitado", "consumoDocumentos", "parametrizar", "recargar"})
    public void recargar() {
        try {
            if (recargar.intValue() > 0) {
                BigDecimal totalDocum = parametrizar.getParContratado() != null ? parametrizar.getParContratado().add(recargar) : BigDecimal.ZERO.add(recargar);
                if (totalDocum.doubleValue() >= consumoDocumentos.getDocumentos().doubleValue()) {
                    parametrizar.setParBloqueoSistema(Boolean.FALSE);
                }
                parametrizar.setParContratado(totalDocum);
                servicioParametrizar.modificar(parametrizar);

                consultarConsumo();
                recargar = BigDecimal.ZERO;
                Clients.showNotification("Recarga correcta ", Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 3000, true);
            } else {
                Clients.showNotification("Debe ingresar un valor mayora cero", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 3000, true);
            }
        } catch (Exception e) {
            Clients.showNotification("Ocurrio un error al recargar", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 3000, true);
        }
    }

    public List<ConsumoClientes> getListaClienteses() {
        return listaClienteses;
    }

    public void setListaClienteses(List<ConsumoClientes> listaClienteses) {
        this.listaClienteses = listaClienteses;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public ConsumoClientes getConsumoIlimitado() {
        return consumoIlimitado;
    }

    public void setConsumoIlimitado(ConsumoClientes consumoIlimitado) {
        this.consumoIlimitado = consumoIlimitado;
    }

    public ConsumoClientes getConsumoDocumentos() {
        return consumoDocumentos;
    }

    public void setConsumoDocumentos(ConsumoClientes consumoDocumentos) {
        this.consumoDocumentos = consumoDocumentos;
    }

    public Parametrizar getParametrizar() {
        return parametrizar;
    }

    public void setParametrizar(Parametrizar parametrizar) {
        this.parametrizar = parametrizar;
    }

    @Command
    public void reporteNotaVenta(@BindingParam("valor") Guiaremision valor) throws JRException, IOException, NamingException, SQLException {
        reporteGeneral(valor.getFacNumero(), "GUIA");
    }

    public void reporteGeneral(Integer numeroFactura, String tipo) throws JRException, IOException, NamingException, SQLException {

        EntityManager emf = HelperPersistencia.getEMF();

        try {
            emf.getTransaction().begin();
            con = emf.unwrap(Connection.class);

            String reportFile = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/reportes");
            String reportPath = "";
            if (tipo.equals("COMP")) {
                reportPath = reportFile + File.separator + "puntoventa.jasper";
            } else if (tipo.equals("FACT")) {
                reportPath = reportFile + File.separator + "factura.jasper";
            } else if (tipo.equals("GUIA")) {
                reportPath = reportFile + File.separator + "guia.jasper";
            }

            Map<String, Object> parametros = new HashMap<String, Object>();

            //  parametros.put("codUsuario", String.valueOf(credentialLog.getAdUsuario().getCodigoUsuario()));
            parametros.put("numfactura", numeroFactura);

            if (con != null) {
                System.out.println("Conexión Realizada Correctamenteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            }
            FileInputStream is = null;
            is = new FileInputStream(reportPath);

            byte[] buf = JasperRunManager.runReportToPdf(is, parametros, con);
            InputStream mediais = new ByteArrayInputStream(buf);
            AMedia amedia = new AMedia("Reporte", "pdf", "application/pdf", mediais);
            fileContent = amedia;
            final HashMap<String, AMedia> map = new HashMap<String, AMedia>();
//para pasar al visor
            map.put("pdf", fileContent);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/venta/contenedorReporte.zul", null, map);
            window.doModal();
        } catch (Exception e) {
            System.out.println("ERROR EL PRESENTAR EL REPORTE " + e.getMessage());
        } finally {
            if (con != null) {
                con.close();
            }
            if (emf != null) {
                emf.getTransaction().commit();
            }

        }

    }

    @Command
    public void reporteGeneral(@BindingParam("valor") NotaCreditoDebito valor) throws JRException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NamingException {
        EntityManager emf = HelperPersistencia.getEMF();

        try {
            emf.getTransaction().begin();
            con = emf.unwrap(Connection.class);

            //  con = emf.unwrap(Connection.class);
            String reportFile = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/reportes");
            String reportPath = "";
//                con = ConexionReportes.Conexion.conexion();

//                    reportPath = reportFile + File.separator + "puntoventa.jasper";
            reportPath = reportFile + File.separator + "notacr.jasper";

            Map<String, Object> parametros = new HashMap<String, Object>();

            //  parametros.put("codUsuario", String.valueOf(credentialLog.getAdUsuario().getCodigoUsuario()));
            parametros.put("numfactura", valor.getFacNumero());

            if (con != null) {
                System.out.println("Conexión Realizada Correctamenteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            }
            FileInputStream is = null;
            is = new FileInputStream(reportPath);

            byte[] buf = JasperRunManager.runReportToPdf(is, parametros, con);
            InputStream mediais = new ByteArrayInputStream(buf);
            AMedia amedia = new AMedia("Reporte", "pdf", "application/pdf", mediais);
            fileContent = amedia;
            final HashMap<String, AMedia> map = new HashMap<String, AMedia>();
//para pasar al visor
            map.put("pdf", fileContent);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/venta/contenedorReporte.zul", null, map);
            window.doModal();
            con.close();

        } catch (Exception e) {
            System.out.println("Error en generar el reporte " + e.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
                System.out.println("cerro entity");
            }
        }

    }

    public BigDecimal getRecargar() {
        return recargar;
    }

    public void setRecargar(BigDecimal recargar) {
        this.recargar = recargar;
    }

    public BigDecimal getSaldoDocumentos() {
        return saldoDocumentos;
    }

    public void setSaldoDocumentos(BigDecimal saldoDocumentos) {
        this.saldoDocumentos = saldoDocumentos;
    }

    public Boolean getPintar() {
        return pintar;
    }

    public void setPintar(Boolean pintar) {
        this.pintar = pintar;
    }

}