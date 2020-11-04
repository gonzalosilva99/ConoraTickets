# CoronaTickets

### Breve descripcion del proyecto

La plataforma coronaTickets.uy ofrece un servicio de gestión social de espectáculos
artísticos y culturales a través de Internet. Para utilizar las funcionalidades que brinda
la plataforma, los usuarios deberán registrarse.

### Tecnologias
* [Bootstrap](https://getbootstrap.com)
* [JQuery](https://jquery.com)
* [HTML5](https://es.wikipedia.org/wiki/HTML5)
* [Java](https://www.java.com/es/download/help/java8.html)
* [Apache Tomcat](http://tomcat.apache.org/)
* [Eclipse](https://www.eclipse.org/downloads/)


## Página web
Primero se debe crear un nuevo server con Tomcat con el puerto seteado en 8005 desde el IDE, en este caso Eclipse. Una vez creado, se debe sincronizar el servidor con "Client-Side", donde estan los datos de la aplicacion web. Luego, desde cualquier navegador se debe acceder a http://localhost:8005/
A continuacion se muestra la ventana principal con los espectaculos de la plataforma Twitter Live.
Arriba a la derecha se podrá iniciar sesion con algun  usuario ingresado o registrarse los datos de prueba y si la sesion está iniciada se podrá cerrar sesión, configurar el perfil e ir a información del perfil.
Para listar usuarios, espectaculos y/o paquetes basta con realizar una búsqueda, si la cadena a buscar es vacía se listarán todos.
En cualquier momento también se puede volver al home haciendo click logo de CoronaTickets.


### Prerequisitos
Se debe tener instalados los siguientes plugins en Eclipse 
* JUnit-Tools para verificación unitaria del código [5] (v. 1.1.0)
* Checkstyle Plug-in (v.8.35.0)
* PMD Eclipse Plug-in (v. 4.15.0)
* WindowBuilder [6] (v.1.9.3)
* Eclipse Tomcat Plug-in (v .9.1.4)

## Test y casos de prueba
http://localhost:8005/cargarcasosdeprueba



