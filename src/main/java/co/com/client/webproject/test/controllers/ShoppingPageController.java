package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ShoppingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

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
            webAction.click(shoppingPage.getconfirmButton(),30,false);
        }catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al realizar pago "+e);
        }
    }

    public String obtenerMensajeDeCarrito(){
        String mensaje = "";
        try{
            ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());
            mensaje = webAction.getText(shoppingPage.gettextSuccess(),30,false);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al validar la compra " + e);
        }
        return mensaje;
    }

    public void vaciarCarrito(){
        ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());
        try{
            webAction.click(shoppingPage.getdeleteButton(), 30, false);
        }catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al eliminar el articulo "+e);
        }
    }

    public String obtenerMensajeDeCarritoVacio(){
        String mensaje = "";
        try{
            ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());
            System.out.println("******** Estoy buscando el mensaje ************");
            mensaje = webAction.getText(shoppingPage.getemptyMessage(),60,true);
            System.out.println("Aqui está el mensaje: " + mensaje);
        }catch(WebActionsException e){
            Report.reportFailure("Ocurrió un error al validar carrito vacio " + e);
        }
        return mensaje;
    }
}
