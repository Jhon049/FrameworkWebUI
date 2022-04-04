package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ContactUsPage;
import co.com.client.webproject.test.page.MyAccountPage;
import co.com.client.webproject.test.page.WomenPage;
import co.com.client.webproject.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import co.com.client.webproject.test.data.objects.TestInfo;

public class MyAccountWebController{
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());
            usuario = webAction.getText(myAccountPage.getCustomerName(), 2, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }
        return usuario;
    }

    public void seccionWomen() {
        try {
            WomenPage womenPage = new WomenPage(webAction.getDriver());
            webAction.click(womenPage.getwomenButton(),10,false);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al ingresar a la seccion Women "+e);
        }
    }

    public void seccionContactUs(String estado){
        if(estado == "exitoso") {
            try {
                ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
                webAction.click(contactUsPage.getContactUsButton(), 10, false);
            } catch (WebActionsException e) {
                Report.reportFailure("Ocurrio un error al ingresar a la seccion Contact Us " + e);
            }
        }
        else{
            try{
                ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
                webAction.click(contactUsPage.getContactUsSecondButton(),10,false);
            } catch (WebActionsException e) {
                Report.reportFailure("Ocurrio un error al ingresar a la seccion Contact Us "+e);
            }
        }
    }
}
