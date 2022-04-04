# language: es
  @FeatureName:CarritoCompras
  Característica: realizar compra
    Como cliente
    Deseo realizar una compra en linea
    para optimizar tiempo

  @ScenarioName:RealizarCompraPorCarrito
  Escenario: Realizar compra por carrito
    Dado que el cliente registrado se encuentra en la pagina
    Cuando el cliente añada un producto y finalice la compra
    Entonces como resultado el sistema indicara que la orden está completa

    @ScenarioName:RealizarCompraCarritoVacio
    Escenario: Realizar compra con carrito vacio
      Dado que el cliente registrado se encuentra en linea
      Cuando el cliente añada un producto y lo elimine en el proceso de pago
      Entonces como resultado el sistema indicara que el carro esta vacio y no permitira continuar