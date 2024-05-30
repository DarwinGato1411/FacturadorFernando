/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Producto;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.vista.servicios.ServicioSriCatastro;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.image.Image;
import org.zkoss.io.Files;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Darwin
 */
public class ConfiguracionMod extends SelectorComposer<Component> {

    @Wire
    Checkbox chkRM;
    @Wire
    Checkbox chkAR;
    @Wire
    Checkbox chkCE;
    @Wire
    Checkbox chkEX;

    @Wire
    private Window win1;

    @Wire
    private Window win2;

    @Wire("#win1 #colorMenu")
    private Menu colorMenu;

    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private Tipoambiente tipoambiente = new Tipoambiente();
    private String llevaContabilidad = "NO";
    private String codigoAmbiente = "1";
    private String amCodigo = "1";
    private String carpetaRaizSRI = "DOCUMENTOSRI";
    private String carpetaFirma = "FIRMA";
    private List<String> listaDicos = new ArrayList<String>();

    ServicioSriCatastro servicioSriCatastro = new ServicioSriCatastro();
    UserCredential credential = new UserCredential();
    private String amRuc = "";
    private String grabaICE = "";

    //subir imagen
    private String filePath;
    byte[] buffer = new byte[1024 * 1024];
    private AImage logotipo = null;
    private AImage color1 = null;
    private AImage color2 = null;
    private AImage color3 = null;

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("valor") Tipoambiente tipo,@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        amRuc = credential.getUsuarioSistema().getUsuRuc();
        tipoambiente = tipo;
        if (tipoambiente != null) {
            amCodigo = tipoambiente.getAmCodigo();
            if (tipoambiente.getLlevarContabilidad().equals("NO")) {
                llevaContabilidad = "NO";
            } else {
                llevaContabilidad = "SI";
            }
            grabaICE = tipoambiente.getAmGrabaIce() ? "S" : "N";

        }

        try {
            if (tipoambiente.getAm_DirImgPuntoVenta() != null) {
                logotipo = new AImage("fotoPedido", Imagen_A_Bytes(tipoambiente.getAm_DirImgPuntoVenta()));
            } else {
                logotipo = null;
            }
            if (tipoambiente.getAmColorPrincipal() != null) {
                color1 = new AImage("fotoPedido", Imagen_A_Bytes(tipoambiente.getAmColorPrincipal()));
            } else {
                color1 = null;
            }
            if (tipoambiente.getAmColorSecundario() != null) {
                color2 = new AImage("fotoPedido", Imagen_A_Bytes(tipoambiente.getAmColorSecundario()));
            } else {
                color2 = null;
            }
            if (tipoambiente.getAmColorAdicional() != null) {
                color3 = new AImage("fotoPedido", Imagen_A_Bytes(tipoambiente.getAmColorAdicional()));
            } else {
                color3 = null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("error imagen " + e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(NuevoProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

//          colorMenu.setContent("#color=" + "#029BCB");
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        colorMenu.setContent("#color=" + "#029BCB");
//        colorPicker.setColor("#029BCB");
    }

    public ConfiguracionMod() {
        listaDiscos();

        String sSistemaOperativo = System.getProperty("os.name");

        if (sSistemaOperativo.toLowerCase().contains("wind")) {
            tipoambiente.setAmUnidadDisco("D:\\");
        } else {
            tipoambiente.setAmUnidadDisco("/");
        }

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());


        /*LISTA LAS UNIDADES DEL DISCO PRESENTES EN EL SISTEMA OPERATIVO*/
    }

    @Command
    @NotifyChange({"tipoambiente"})
    public void buscarCatastro() {
        if (tipoambiente.getAmRuc() != null) {

            if (tipoambiente.getAmRuc().length() == 13) {
                tipoambiente.setAmMicroEmp(Boolean.FALSE);
                tipoambiente.setAmAgeRet(Boolean.FALSE);
                tipoambiente.setAmContrEsp(Boolean.FALSE);
                tipoambiente.setAmExp(Boolean.FALSE);
                chkRM.setChecked(Boolean.FALSE);
                chkAR.setChecked(Boolean.FALSE);
                chkCE.setChecked(Boolean.FALSE);
                chkEX.setChecked(Boolean.FALSE);
//                for (SriCatastro catastro : servicioSriCatastro.findCatastro(tipoambiente.getAmRuc())) {
//                    if (catastro.getSigla().equals("MC")) {
//                        tipoambiente.setAmMicroEmp(Boolean.TRUE);
//                        chkRM.setChecked(Boolean.TRUE);
//                    } else if (catastro.getSigla().equals("AR")) {
//                        tipoambiente.setAmAgeRet(Boolean.TRUE);
//                        chkAR.setChecked(Boolean.TRUE);
//                    } else if (catastro.getSigla().equals("CE")) {
//                        tipoambiente.setAmContrEsp(Boolean.TRUE);
//                        chkCE.setChecked(Boolean.TRUE);
//                    } else if (catastro.getSigla().equals("EX")) {
//                        tipoambiente.setAmExp(Boolean.TRUE);
//                        chkEX.setChecked(Boolean.FALSE);
//                    }
//                }

            }
        }

    }

    @Command
    @NotifyChange({"tipoambiente"})
    public void ambienteCodigo() {
        /*COLOCA EL ANTERIOR EN FALSO*/
        tipoambiente.setAmEstado(Boolean.FALSE);

        servicioTipoAmbiente.modificar(tipoambiente);
        tipoambiente = servicioTipoAmbiente.findByIdUsuario(tipoambiente, amCodigo);
        /*COLOCA EL NUEVO AMBIENTE EN ACTIVO*/
        tipoambiente.setAmEstado(Boolean.TRUE);
        servicioTipoAmbiente.modificar(tipoambiente);

    }
    //subir pdf
//    private String filePath;
//    byte[] buffer = new byte[1024 * 1024];

    @Command
    @NotifyChange({"fileContent", "tipoambiente"})
    public void subirFirma() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.util.media.AMedia) {
            String nombre = media.getName();

            if (!nombre.contains("p12")) {
                Clients.showNotification("Su firma electronica debe ser tipo archivo con extension .p12 ",
                        Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 3000, true);

                return;
            }
            if (media.getByteData().length > 10 * 1024 * 1024) {

                Clients.showNotification("El arhivo seleccionado sobrepasa el tamaño de 10Mb.\n Por favor seleccione un archivo más pequeño. ",
                        Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 3000, true);
                return;
            }
            filePath = tipoambiente.getAmDirBaseArchivos() + File.separator + tipoambiente.getAmFolderFirma() + File.separator;

            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filePath + media.getName()),
                    media.getStreamData());
            tipoambiente.setAmDirFirma(nombre);

        }
    }

    public void LeerExcel() {

    }
    //Imagen ruta 
    private String filePathImg;

    @Command
    @NotifyChange({"fileContent", "tipoambiente", "logotipo"})
    public void subirPathImagen() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.image.Image) {
            String nombre = media.getName();
            if (media instanceof Image) {

                if (media.getByteData().length > 10 * 1024 * 1024) {
                    Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 10Mb.\n Por favor seleccione un archivo más pequeño.", "Atención", Messagebox.OK, Messagebox.ERROR);

                    return;
                }
                filePathImg = tipoambiente.getAmDirBaseArchivos() + File.separator + tipoambiente.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathImg);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathImg + media.getName()),
                        media.getStreamData());
                tipoambiente.setAm_DirImgPuntoVenta(filePathImg + File.separator + nombre);
                logotipo = new AImage("fotoPedido", Imagen_A_Bytes(filePathImg + File.separator + media.getName()));
            }

        }
    }

    @Command
    @NotifyChange({"fileContent", "tipoambiente", "color1"})
    public void subirColor1() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.image.Image) {
            String nombre = media.getName();
            if (media instanceof Image) {

                if (media.getByteData().length > 10 * 1024 * 1024) {
                    Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 10Mb.\n Por favor seleccione un archivo más pequeño.", "Atención", Messagebox.OK, Messagebox.ERROR);

                    return;
                }
                filePathImg = tipoambiente.getAmDirBaseArchivos() + File.separator + tipoambiente.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathImg);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathImg + media.getName()),
                        media.getStreamData());
                tipoambiente.setAmColorPrincipal(filePathImg + File.separator + nombre);
                color1 = new AImage("fotoPedido", Imagen_A_Bytes(filePathImg + File.separator + media.getName()));
            }

        }
    }

    @Command
    @NotifyChange({"fileContent", "tipoambiente", "color2"})
    public void subirColor2() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.image.Image) {
            String nombre = media.getName();
            if (media instanceof Image) {

                if (media.getByteData().length > 10 * 1024 * 1024) {
                    Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 10Mb.\n Por favor seleccione un archivo más pequeño.", "Atención", Messagebox.OK, Messagebox.ERROR);

                    return;
                }
                filePathImg = tipoambiente.getAmDirBaseArchivos() + File.separator + tipoambiente.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathImg);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathImg + media.getName()),
                        media.getStreamData());
                tipoambiente.setAmColorSecundario(filePathImg + File.separator + nombre);
                color2 = new AImage("fotoPedido", Imagen_A_Bytes(filePathImg + File.separator + media.getName()));
            }

        }
    }

    @Command
    @NotifyChange({"fileContent", "tipoambiente", "color3"})
    public void subirColor3() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.image.Image) {
            String nombre = media.getName();
            if (media instanceof Image) {

                if (media.getByteData().length > 10 * 1024 * 1024) {
                    Messagebox.show("El arhivo seleccionado sobrepasa el tamaño de 10Mb.\n Por favor seleccione un archivo más pequeño.", "Atención", Messagebox.OK, Messagebox.ERROR);

                    return;
                }
                filePathImg = tipoambiente.getAmDirBaseArchivos() + File.separator + tipoambiente.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathImg);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathImg + media.getName()),
                        media.getStreamData());
                tipoambiente.setAmColorAdicional(filePathImg + File.separator + nombre);
                color3 = new AImage("fotoPedido", Imagen_A_Bytes(filePathImg + File.separator + media.getName()));
            }

        }
    }

    public byte[] Imagen_A_Bytes(String pathImagen) throws FileNotFoundException {
        String reportPath = "";
        reportPath = pathImagen;
        File file = new File(reportPath);

        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
//                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
        }

        byte[] bytes = bos.toByteArray();
        return bytes;
    }

    @Command
    @NotifyChange({"tipoambiente", "llevaContabilidad"})
    public void guardar() {
        tipoambiente.setLlevarContabilidad(llevaContabilidad);
        tipoambiente.setAmDirBaseArchivos(tipoambiente.getAmUnidadDisco() + File.separator + carpetaRaizSRI);
        tipoambiente.setAmDirReportes("REPORTES");
        tipoambiente.setAmGenerados("GENERADOS");
        tipoambiente.setAmDirXml("XML");
        tipoambiente.setAmFirmados("FIRMADOS");
        tipoambiente.setAmTrasmitidos("TRASMITIDOS");
        tipoambiente.setAmDevueltos("DEVUELTOS");
        tipoambiente.setAmAutorizados("AUTORIZADOS");
        tipoambiente.setAmNoAutorizados("NOAUTORIZADOS");
        tipoambiente.setAmTipoEmision("1");
        tipoambiente.setAmEnviocliente("ENVIARCLIENTE");
        tipoambiente.setAmGrabaIce(grabaICE.equals("S") ? Boolean.TRUE : Boolean.FALSE);
        servicioTipoAmbiente.modificar(tipoambiente);

        Clients.showNotification("Información registrada exitosamente",
                Clients.NOTIFICATION_TYPE_INFO, null, "end_center", 3000, true);

    }

    public Tipoambiente getTipoambiente() {
        return tipoambiente;
    }

    public void setTipoambiente(Tipoambiente tipoambiente) {
        this.tipoambiente = tipoambiente;
    }

    public String getLlevaContabilidad() {
        return llevaContabilidad;
    }

    public void setLlevaContabilidad(String llevaContabilidad) {
        this.llevaContabilidad = llevaContabilidad;
    }

    public String getCodigoAmbiente() {
        return codigoAmbiente;
    }

    public void setCodigoAmbiente(String codigoAmbiente) {
        this.codigoAmbiente = codigoAmbiente;
    }

    public String getCarpetaRaizSRI() {
        return carpetaRaizSRI;
    }

    public void setCarpetaRaizSRI(String carpetaRaizSRI) {
        this.carpetaRaizSRI = carpetaRaizSRI;
    }

    public List<String> getListaDicos() {
        return listaDicos;
    }

    public void setListaDicos(List<String> listaDicos) {
        this.listaDicos = listaDicos;
    }

    public String getAmCodifo() {
        return amCodigo;
    }

    public void setAmCodifo(String amCodifo) {
        this.amCodigo = amCodifo;
    }

    private void listaDiscos() {
        File[] files = File.listRoots();
        if (files != null) {
            for (File f : files) {
                listaDicos.add(f.getPath());

                System.out.println("getAbsolutePath " + f.getAbsolutePath());
                System.out.println("getPath " + f.getPath());
            }
        }

    }

    public String getGrabaICE() {
        return grabaICE;
    }

    public void setGrabaICE(String grabaICE) {
        this.grabaICE = grabaICE;
    }

    @Listen("onChange = #win1 #colorMenu")
    public void onLeftColorChanged(InputEvent event) {
        win1.setContentStyle("background-color: " + event.getValue());
    }

    public AImage getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(AImage logotipo) {
        this.logotipo = logotipo;
    }

    public AImage getColor1() {
        return color1;
    }

    public void setColor1(AImage color1) {
        this.color1 = color1;
    }

    public AImage getColor2() {
        return color2;
    }

    public void setColor2(AImage color2) {
        this.color2 = color2;
    }

    public AImage getColor3() {
        return color3;
    }

    public void setColor3(AImage color3) {
        this.color3 = color3;
    }

}
