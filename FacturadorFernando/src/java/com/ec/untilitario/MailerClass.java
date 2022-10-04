/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.untilitario;

import com.ec.entidad.Tipoambiente;
import com.ec.servicio.ServicioTipoAmbiente;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeUtility;

/**
 * Clase que permite el envio de e-mails utilizando el API javamail.
 *
 */
public class MailerClass {

    private Tipoambiente amb = new Tipoambiente();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    public String getConfiguracionCorreo(String categoria) {

        return null;
    }

    class SmtpAuthenticator extends Authenticator {

        public SmtpAuthenticator() {

            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
//            amb = servicioTipoAmbiente.FindALlTipoambiente();
            String username = amb.getAmUsuarioSmpt().trim();
            String password = amb.getAmPassword().trim();
            return new PasswordAuthentication(username, password);

        }
    }

    //envio de mail simple
//    
//      m.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(address));
    public boolean sendMailSimple(String address,
            String[] attachFiles, String asuntoInf, String acceso,
            String numeroDocumento, BigDecimal valorTotal, String cliente, Tipoambiente ambiente)
            throws java.rmi.RemoteException {

        try {

            amb = ambiente;

//            String asunto = asuntoInf;
//              String host = "mail.deckxel.com";
//            String port = "26";
//            String protocol = "smtp";
//            String usuarioSmpt = "defact@deckxel.com";
//            String password = "Dereckandre02!";
            String asunto = asuntoInf;
            String host = amb.getAmHost();
            String port = amb.getAmPort();
            String protocol = amb.getAmProtocol();
            String usuarioSmpt = amb.getAmUsuarioSmpt().trim();
            String password = amb.getAmPassword().trim();

            // Propiedades de la conexión
            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.user", usuarioSmpt);
            properties.setProperty("mail.smtp.password", password);
            properties.setProperty("mail.smtp.port", port);
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.debug", "false");
            // Setup Port
            properties.put("mail.smtp.ssl.trust", host);
            SmtpAuthenticator auth = new SmtpAuthenticator();
            // Get the default Session object.
            Session session = Session.getInstance(properties, auth);
            MimeMessage m = new MimeMessage(session);
            String nickFrom = MimeUtility.encodeText(amb.getAmNombreComercial());
//            String nickTo = MimeUtility.encodeText(amb.getAmNombreComercial());
            Address addressfrom = new InternetAddress(usuarioSmpt, nickFrom);

            m.setFrom(addressfrom);

            BodyPart texto = new MimeBodyPart();
            String HTMLENVIO = "<body>\n"
                    + "    <img alt=\"logo\" style=\"height:100px;margin:auto;display:block\"\n"
                    + "        src=\"https://southcentralus1-mediap.svc.ms/transform/thumbnail?provider=spo&inputFormat=png&cs=fFNQTw&docid=https%3A%2F%2Futneduec-my.sharepoint.com%3A443%2F_api%2Fv2.0%2Fdrives%2Fb!gqNSjMxCKUqlSIcNlH_W3qK_bUSzQ8NDmhYRqMNUsxrc3kSHbZELQb_5zsOXXWVq%2Fitems%2F01MOQ3UUF44JVILFUMZZBKFB2372QBQQ7T%3Fversion%3DPublished&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJub25lIn0.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDAvdXRuZWR1ZWMtbXkuc2hhcmVwb2ludC5jb21AOGRiZTE0NjktYzc5Yy00ZTIxLTlkNDMtY2E2NWQ5ZTljNDc1IiwiaXNzIjoiMDAwMDAwMDMtMDAwMC0wZmYxLWNlMDAtMDAwMDAwMDAwMDAwIiwibmJmIjoiMTY2NDg3NDAwMCIsImV4cCI6IjE2NjQ4OTU2MDAiLCJlbmRwb2ludHVybCI6IlZiSHFaUU5tdzY1c3NlL281N2JlaGV0NmxtcUczUzUyUnNXdmtjSGN4K2M9IiwiZW5kcG9pbnR1cmxMZW5ndGgiOiIxMTgiLCJpc2xvb3BiYWNrIjoiVHJ1ZSIsInZlciI6Imhhc2hlZHByb29mdG9rZW4iLCJzaXRlaWQiOiJPR00xTW1Fek9ESXROREpqWXkwMFlUSTVMV0UxTkRndE9EY3daRGswTjJaa05tUmwiLCJzaWduaW5fc3RhdGUiOiJbXCJrbXNpXCJdIiwibmFtZWlkIjoiMCMuZnxtZW1iZXJzaGlwfHBqbWFsdGVhQHV0bi5lZHUuZWMiLCJuaWkiOiJtaWNyb3NvZnQuc2hhcmVwb2ludCIsImlzdXNlciI6InRydWUiLCJjYWNoZWtleSI6IjBoLmZ8bWVtYmVyc2hpcHwxMDAzMDAwMDliNmMwMDdmQGxpdmUuY29tIiwic2lkIjoiYTgyNzNkMjMtNzQ4Ny00YmQyLThkZTUtOTIzM2E4NTE1NTUyIiwidHQiOiIwIiwidXNlUGVyc2lzdGVudENvb2tpZSI6IjMiLCJpcGFkZHIiOiIxNzcuNTMuMjEzLjM1In0.WlNTOUsrSXBIY0trRlJwS1Z3VU5CNkRsWHlmOUsvWEdET2tzL28wNWw4UT0&cTag=%22c%3A%7B856AE2BC-8C96-42CE-A287-5BFEA01843F3%7D%2C1%22&encodeFailures=1&width=664&height=376&srcWidth=664&srcHeight=376\" />\n"
                    + "    <div style=\"height: 10px;background:#fbc620;\"></div>\n"
                    + "    <p style=\"margin-bottom: 0;\">Documento electrónico</p>\n"
                    + "    <p style=\"margin-bottom: 0;\">Estimado (a) "+ cliente +",</p>\n"
                    + "    <p>Gracias por seleccionar FACTURAS.EC, Nos complace informar que su documento se ha generado correctamente:</p>\n"
                    + "    <div style=\"height: 10px;background:#ffe79e;\"></div>\n"
                    + "    <p style=\"margin-bottom: 0;\"><strong>Número de documento:</strong>"+ numeroDocumento +" </p>\n"
                    + "    <p style=\"margin-bottom: 0;\"><strong>Clave de acceso:</strong>"+acceso+"</p>\n"
                    + "    <p style=\"margin-bottom: 0;\"><strong>Valor total:</strong>"+ ArchivoUtils.redondearDecimales(valorTotal, 2) +"</p>\n"
                    + "\n"
                    + "    <br>\n"
                    + "    <div style=\"height: 10px;background:#ffe79e;\"></div>\n"
                    + "    <p style=\"margin-bottom: 0;\">Sus archivos PDF y XML se enviaron de forma adjunta, por favor reviselos</p>\n"
                    + "    <p>Si tiene cualquier duda o pregunta nos puede escribir al mail <a>send@facturas.ec</a> o llámenos al\n"
                    + "        0992553708.</p>\n"
                    + "    <p>Saludos Cordiales,\n"
                    + "        <br>\n"
                    + "        Patrick Arch\n"
                    + "        <br>\n"
                    + "        Director\n"
                    + "    </p>\n"
                    + "\n"
                    + "    <div style=\"display: grid;\">\n"
                    + "        <div style=\"width: auto;margin:auto;\">\n"
                    + "            <p style=\"text-align: center;\">FACTURAS.EC\n"
                    + "                <br>\n"
                    + "                QUITO - ECUADOR\n"
                    + "            </p>\n"
                    + "        </div>\n"
                    + "    </div>\n"
                    + "\n"
                    + "    <div style=\"height: 10px;background:black;\"></div>\n"
                    + "\n"
                    + "    \n"
                    + "</body>";

            texto.setContent(HTMLENVIO, "text/html");

            MimeMultipart multiParte = new MimeMultipart();
            // inicio adjunto
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPartDoc = new MimeBodyPart();
                    try {
                        if (!filePath.equals("")) {
                            attachPartDoc.attachFile(filePath);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    multiParte.addBodyPart(attachPartDoc);
                }
            }
            m.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(address));
            multiParte.addBodyPart(texto);

//            m.setRecipients(Message.RecipientType.TO, addresTto);
//            m.setRecipients(Message.RecipientType.BCC, from);
            m.setSubject(asunto);
            m.setSentDate(new java.util.Date());
//             m.setContent(dirDatos, "text/plain");
            m.setContent(multiParte);

            Transport t = session.getTransport(protocol);
//             t.connect();
            t.connect(host, usuarioSmpt, password);
            t.send(m);
            t.close();
            return true;
        } catch (javax.mail.MessagingException e) {
            System.out.println("error" + e);
            e.printStackTrace();

            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MailerClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
