package co.com.client.webproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/crearNuevaCuenta.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition"},
        tags = "",
        publish = true
)
public class CrearNuevaCuentaTestRunner {
}
