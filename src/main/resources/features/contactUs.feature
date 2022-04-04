# language: es
@FeatureName:ContactUs
Característica: enviar mensaje
  Como cliente
  Deseo enviar un mensaje a Customer Service
  para dar a conocer mis comentarios

  @ScenarioName:EnviarMensaje
  Escenario: EnviarMensaje
    Dado que el cliente registrado se encuentra en el Home
    Cuando el cliente ingrese un mensaje en Contact Us
    Entonces como resultado el sistema indicara que el mensaje se envio con exito

  @ScenarioName:EnviarMensajeSinEmail
  Escenario: EnviarMensajeSinEmail
    Dado que el usuario no registrado se encuentra en el Home
    Cuando el usuario ingrese un mensaje en Contact Us
    Entonces como resultado el sistema indicara direccion de email invalida