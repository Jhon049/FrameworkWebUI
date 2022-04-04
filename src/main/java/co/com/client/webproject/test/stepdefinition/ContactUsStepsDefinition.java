package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.ContactUsController;
import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.LoginPageController;
import co.com.client.webproject.test.controllers.MyAccountWebController;
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

public class ContactUsStepsDefinition extends Setup{
    private WebAction webAction;
    ContactUsController contactUsController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente registrado se encuentra en el Home")
    public void queElClienteRegistradoSeEncuentraEnElHome(){
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
        String estado = "exitoso";
        myAccountWebController.seccionContactUs(estado);
    }

    @Cuando("el cliente ingrese un mensaje en Contact Us")
    public void elClienteIngreseUnMensajeEnContactUs(){
        contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.enviarMensaje();
    }

    @Entonces("como resultado el sistema indicara que el mensaje se envio con exito")
    public void comoResultadoElSistemaIndicaraQueElMensajeSeEnvioConExito(){
        String mensaje = contactUsController.obtenerMensajeDeEnvioExitoso();
        Assert
                .Hard
                .thatString(mensaje)
                .isEqualTo("Your message has been successfully sent to our team.");
    }

    @After
    public void cerrarDriver(){
        webAction.closeBrowser();
    }
}
