package com.pe.colegio.nsr.managedbean;

import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@ManagedBean(name = "correo")
@SessionScoped
public class correoBean {

    private Properties props;
    private String from;
    private String name;
    private String subject;
    private String message;

    @PostConstruct
    public void configuration() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean envioMail() {
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("demojava3@gmail.com", "Pass@word1");
                        }
                    });


            Message message = new MimeMessage(session);
            //Se define quién es el emisor del e-mail
            message.setFrom(new InternetAddress(this.from));
            //Se definen el o los destinatarios
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("demopruebajava@gmail.com"));
            //Se defina el asunto del e-mail
            message.setSubject(this.subject);

            //Se seteo el mensaje del e-mail
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Sr.(a) " + this.name + " con correo " + this.from + " le a enviado el siguiente mensaje.<br/>" + this.message, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            return false;
        }
    }

    public void enviar() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (envioMail()) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "El mensaje fue enviado satisfactoriamente.");
            limpiar();
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El mensaje no fue enviado. ¡Vuelva a Intentarlo!");
        }

        context.addMessage(null, msg);
    }

    public void limpiar() {
        setFrom("");
        setName("");
        setSubject("");
        setMessage("");
    }
}
