package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
import co.com.client.webproject.test.controllers.WomenPageController;
import co.com.client.webproject.test.controllers.ShoppingPageController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.model.Customer;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.actions.WebAction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CarritoStepsDefinition extends Setup{

    private WebAction webAction;
    private Customer customer;
    WomenPageController womenPageController;
    ShoppingPageController shoppingPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente registrado se encuentra en la pagina")
    public void queElClienteRegistradoSeEncuentraEnLaPagina(){
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        myAccountWebController.seccionWomen();
    }

    @Cuando("el cliente añada un producto y finalice la compra")
    public void elClienteAñadaUnProductoYFinaliceLaCompra(){
        womenPageController = new WomenPageController();
        womenPageController.setWebAction(webAction);
        womenPageController.agregarAlCarrito();

        shoppingPageController = new ShoppingPageController();
        shoppingPageController.setWebAction(webAction);
        shoppingPageController.realizarCompra();
    }

    @Entonces("como resultado el sistema indicara que la orden está completa")
    public void comoResultadoElSistemaIndicaraQueLaOrdenEstáCompleta(){
        String mensaje = shoppingPageController.obtenerMensajeDeCarrito();
        Assert
                .Hard
                .thatString(mensaje)
                .isEqualTo("Your order on My Store is complete.");
    }

    @After
    public void cerrarDriver(){
        webAction.closeBrowser();
    }
}
