# Practica4-PAT

Esta práctica mejora la práctica anterior (LLamada a la API de la NASA) para que levante un servidor de Spring Boot donde se llevará a cabo toda la lógica de llamada a la API.

El servidor esta levantado en el puerto 8888 (http://localhost:8888) y utiliza el Actuator "Health" para comprobar el estado de dicho servidor. Accediendo a http://localhost:8888/health se podrá visualizar el estado de este por un mensaje de texto. 

La aplicación contiene 3 controllers:

## APOD
Este controler maneja la llamada a la API de la NASA APOD para obtener la imágen del día asi como su descripción y ponerlas de fondo de pantalla. En la clase DailyIMGImpl se encuentra toda la lógica de llamada a la API. En JavaScript se ha realizado un GET.

## MarsRober Images
Desde JavaScript se realiza un POST al servidor en el que se envían los datos de la fecha y la cámara del Mars Rober seleccionadas para realizar la llamada a la API con dichos parámetros, se hace uso de la clase IMGGallery para manejarlos en JAVA. El servidor repsonde con un JSON con todos los datos, el cual es tratado en JavaScript.

## HealthCheck
Como se ha mencionado anteriormente, se puede comprobar el estado del servidor en este controlador.

Adicionalmente, se han dispuesto Loggers por toda la aplicación para llevar un seguimiento detallado de todos los procesos internos que se llevan a cabo en cada uno de las llamadas.
