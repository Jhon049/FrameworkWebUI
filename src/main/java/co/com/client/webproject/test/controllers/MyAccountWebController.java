package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.MyAccountPage;
import co.com.client.webproject.test.page.WomenPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class MyAccountWebController {
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
            webAction.click(womenPage.getwomenButton(),10,true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al ingresar a la seccion Women "+e);
        }
    }
}
