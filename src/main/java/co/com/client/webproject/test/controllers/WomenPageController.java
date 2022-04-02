package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.WomenPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class WomenPageController {

    private WebAction webAction;
    public void setWebAction(WebAction webAction) {this.webAction = webAction;}

    public void agregarAlCarrito(){
        WomenPage womenPage = new WomenPage(webAction.getDriver());
        try {
            webAction.moveTo(womenPage.getproductImage(), 60, true);
            webAction.click(womenPage.getaddToCartButton(),60,true);
            webAction.click(womenPage.getproceed1(), 60, true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al agregar el producto al carro "+e);
        }
    }
}
