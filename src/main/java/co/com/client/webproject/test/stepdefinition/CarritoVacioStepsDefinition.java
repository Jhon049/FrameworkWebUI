package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
import co.com.client.webproject.test.controllers.WomenPageController;
import co.com.client.webproject.test.controllers.ShoppingPageController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CarritoVacioStepsDefinition extends Setup{

    private WebAction webAction;
    WomenPageController womenPageController;
    ShoppingPageController shoppingPageController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente registrado se encuentra en linea")
    public void queElClienteRegistradoSeEncuentraEnLinea(){
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

    @Cuando("el cliente añada un producto y lo elimine en el proceso de pago")
    public void elClienteAñadaUnProductoYLoElimineEnElProcesoDePago(){
        womenPageController = new WomenPageController();
        womenPageController.setWebAction(webAction);
        womenPageController.agregarAlCarrito();

        shoppingPageController = new ShoppingPageController();
        shoppingPageController.setWebAction(webAction);
        shoppingPageController.vaciarCarrito();
    }

    @Entonces("como resultado el sistema indicara que el carro esta vacio y no permitira continuar")
    public void comoResultadoElSistemaIndicaraQueElCarroEstaVacioYNoPermitiraContinuar(){

        String mensajeVacio = shoppingPageController.obtenerMensajeDeCarritoVacio();
        Assert
                .Hard
                .thatString(mensajeVacio)
                .isEqualTo("Your shopping cart is empty.");
    }

    @After
    public void cerrarDriver(){
        webAction.closeBrowser();
    }
}
