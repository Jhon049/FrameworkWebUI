package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.ContactUsController;
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

public class ContactUsInvalidoStepsDefinition extends Setup{
    private WebAction webAction;
    ContactUsController contactUsController;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el usuario no registrado se encuentra en el Home")
    public void queElUsuarioNoRegistradoSeEncuentraEnElHome(){
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        MyAccountWebController myAccountWebController = new MyAccountWebController();
        myAccountWebController.setWebAction(webAction);
        String estado = "invalido";
        myAccountWebController.seccionContactUs(estado);
    }

    @Cuando("el usuario ingrese un mensaje en Contact Us")
    public void elUsuarioIngreseUnMensajeEnContactUs(){
        contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.enviarMensajeInvalido();
    }

    @Entonces("como resultado el sistema indicara direccion de email invalida")
    public void comoResultadoElSistemaIndicaraDireccionDeEmailInvalida(){
        String mensaje = contactUsController.obtenerMensajeDeEnvioInvalido();
        Assert
                .Hard
                .thatString(mensaje)
                .isEqualTo("Invalid email address.");
    }

    @After
    public void cerrarDriver(){
        webAction.closeBrowser();
    }
}
