package co.com.client.webproject.test.controllers.openwebpage;

import co.com.client.webproject.test.page.ShoppingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ShoppingPageController {

    private WebAction webAction;
    public void setWebAction(WebAction webAction) {this.webAction = webAction;}

    public void realizarCompra(){
        ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());

        try{
            webAction.click(shoppingPage.getproceed2(), 60, false);
            webAction.click(shoppingPage.getproceed3(), 60, false);
            webAction.clickNotVisible(shoppingPage.getcheckbox(), 60, false);
            webAction.click(shoppingPage.getproceed4(), 60, false);
            webAction.click(shoppingPage.getpayButton(), 60, false);
        }catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al realizar pago "+e);
        }
    }
}
