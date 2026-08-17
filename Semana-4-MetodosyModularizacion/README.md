# Tarea III — Sistema de Control de Parqueo

*Nombre:* Mynor Adolfo Girón Muralles  
*Carné:* 9941-25-25-8300

---

## Descripción breve
Desarrollé un programa en Java para controlar los cobros de un parqueo. Al iniciar, el sistema pide la cantidad de vehículos a ingresar y valida que no se ingresen valores negativos o texto. Luego, mediante un ciclo for, va solicitando los datos de cada vehículo (placa, tipo, hora/minuto de entrada y salida, y si perdió el ticket).

El programa calcula la tarifa correspondiente, aplica el 15% de descuento si el tiempo sobrepasa las 8 horas y cobra una multa de Q50 si perdieron el ticket. Al final muestra un comprobante por cada carro y un resumen general con los totales cobrados, conteo por tipo de vehículo y el pago más alto.

---

## Métodos creados y función de cada uno

* public static double obtenerTarifa(int tipoVehiculo)  
  Devuelve la tarifa por hora según la opción (Q5.00 para motocicleta, Q8.00 para auto y Q12.00 para pickup/camioneta).

* public static String obtenerNombreVehiculo(int tipoVehiculo)  
  Convierte el número del tipo de vehículo a texto para mostrarlo formateado en el comprobante.

* public static double calcularDescuento(double subtotal, int horas)  
  Verifica si las horas cobradas son mayores a 8 para aplicar el 15% de descuento sobre el subtotal.

* public static double calcularPago(int horas, double tarifa)  
  Calcula el monto final a pagar en caso de que el cliente *sí* conserve su ticket.

* public static double calcularPago(int horas, double tarifa, double recargo)  
  Calcula el pago cuando el cliente *perdió* el ticket, sumando el recargo de Q50 al cálculo base.

* public static void mostrarComprobante(...)  
  Procedimiento void encargado de imprimir la plantilla del recibo individual de cada vehículo.

* public static void mostrarResumenJornada(...)  
  Procedimiento void que imprime la liquidación final con la recaudación y estadísticas.

* public static int pedirNumero(Scanner tec, String txt, int min, int max)  
  Método auxiliar que utilicé para validar que las horas (0-23) y los minutos (0-59) estén en los rangos correctos.

* public static int calcularMinutosTotales(int h1, int m1, int h2, int m2)  
  Saca la diferencia de tiempo en minutos. Si la hora de salida es menor que la de entrada, le suma las 24 horas para tomar en cuenta el cambio de día (medianoche).

* public static int calcularHorasCobro(int minTotales)  
  Convierte los minutos transcurridos a horas completas utilizando Math.ceil para redondear cualquier fracción hacia arriba.

---

## Explicación de la sobrecarga

Apliqué la sobrecarga de métodos en calcularPago. Utilicé el mismo nombre de método pero cambiando la lista de parámetros según la condición del ticket:

1. calcularPago(int horas, double tarifa): Cuenta con 2 parámetros. Se invoca cuando el usuario responde 'N' a la pérdida del ticket.
2. calcularPago(int horas, double tarifa, double recargo): Cuenta con 3 parámetros. Se invoca cuando responde 'S', reutilizando el cálculo base y sumándole los Q50 de recargo.

---

## Casos de prueba utilizados

1. *Cobro normal:* Ingrese un automóvil (tipo 2) con 3 horas de parqueo y ticket presentado (N). Cobró exactamente Q24.00 sin descuentos.
2. *Descuento + Ticket perdido:* Ingresé una moto (tipo 1) con 10 horas y ticket perdido (S). Calculó el subtotal de Q50.00, restó el 15% (Q7.50) y sumó Q50.00 de recargo, dando un total de Q92.50.
3. *Cruce de medianoche (Reto):* Ingresé entrada a las 22:30 y salida a las 02:10 del día siguiente. El sistema reconoció las 3 horas con 40 minutos y redondeó el cobro a 4 horas completas.
4. *Validación de errores:* Ingresé letras en el menú de opciones, números negativos en la cantidad de vehículos y horas como "25". El programa desplegó el mensaje de error correspondiente y volvió a pedir el dato hasta ingresar uno correcto.

---

## Reto opcional

*Sí realicé el reto opcional.*  
El programa solicita horas y minutos de entrada y salida, valida los rangos (0 a 23 y 0 a 59), calcula correctamente los minutos aunque la salida sea al día siguiente y aproxima cualquier fracción de tiempo a la siguiente hora completa