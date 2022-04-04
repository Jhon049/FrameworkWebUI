package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsController {
    private WebAction webAction;
    public void setWebAction(WebAction webAction) {this.webAction = webAction;}

    public void enviarMensaje(){
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
        try{
            webAction.click(contactUsPage.getchooseList(),30,false);
            webAction.click(contactUsPage.getcustomerService(),30,false);
            webAction.sendText(contactUsPage.gettextArea(),"Message",30,false);
            webAction.click(contactUsPage.getsendButton(),30,false);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al enviar mensaje "+e);
        }
    }

    public String obtenerMensajeDeEnvioExitoso(){
        String mensaje = "";
        try{
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            mensaje = webAction.getText(contactUsPage.getSuccessText(),10,false);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al validar el envio del mensaje " + e);
        }
        return mensaje;
    }

    public void enviarMensajeInvalido(){
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
        try{
            webAction.click(contactUsPage.getchooseList(),30,false);
            webAction.click(contactUsPage.getcustomerService(),30,false);
            webAction.sendText(contactUsPage.gettextArea(),"Message",30,false);
            webAction.click(contactUsPage.getsendButton(),30,false);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al enviar mensaje invalido "+e);
        }
    }
    public String obtenerMensajeDeEnvioInvalido(){
        String mensaje = "";
        try{
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            mensaje = webAction.getText(contactUsPage.getErrorText(),10,false);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al validar el envio del mensaje invalido" + e);
        }
        return mensaje;
    }
}
