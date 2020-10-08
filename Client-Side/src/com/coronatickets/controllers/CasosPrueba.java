package com.coronatickets.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controladores.Fabrica;
import DataTypes.TipoRegistro;
import Interfaces.ICategoria;
import Interfaces.IPaquete;
import Interfaces.IPlataforma;
import Interfaces.IUsuario;



public class CasosPrueba extends HttpServlet {
	   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter writer = response.getWriter();
        writer.println("La hora es: " + new Date().toString() + " PRUEBA12");
    	try {
    		Fabrica fab = Fabrica.getInstancia();
			IUsuario iusuario = fab.getIUsuario();
			IPlataforma iplataforma = fab.getIPlataforma();
			ICategoria icategoria = fab.getICategoria();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaNac;
			// ESPECTADORES (Nickname, Nombre, Apellido, Email, Fecha_Nac)
			fechaNac = formato.parse("31/12/1971");
			iusuario.confirmarAltaEspectador("eleven11", "Eleven", "Ten", "eleven11@gmail.com", fechaNac, "", "lkj34df");
			fechaNac = formato.parse("15/11/1983");
			iusuario.confirmarAltaEspectador("costas", "Gerardo", "Costas", "gcostas@gmail.com", fechaNac, "", "poke579");
			fechaNac = formato.parse("15/4/1990");
			iusuario.confirmarAltaEspectador("waston", "Emma", "Watson", "e.watson@gmail.com", fechaNac, "https://bit.ly/3jrashA", "mkji648");
			fechaNac = formato.parse("15/5/1959");
			iusuario.confirmarAltaEspectador("house", "Gregory", "House", "greghouse@gmail.com", fechaNac, "https://bit.ly/3ng8YZE", "fcku0123");
			fechaNac = formato.parse("28/01/1950");
			iusuario.confirmarAltaEspectador("sergiop", "Sergio", "Puglia", "puglia@alpanpan.com.uy", fechaNac, "https://bit.ly/2EViUGV", "vbmn4r");
			fechaNac = formato.parse("17/03/1976");
			iusuario.confirmarAltaEspectador("chino", "Alvaro", "Recoba", "chino@trico.com.uy", fechaNac, "https://bit.ly/3cTJWuX", "ncnl123");
			fechaNac = formato.parse("14/02/1955");
			iusuario.confirmarAltaEspectador("tonyp", "Antonio", "Pacheco", "eltony@manya.com.uy", fechaNac, "https://bit.ly/3cS2bkh", "mny101");
			fechaNac = formato.parse("23/02/1927");
			iusuario.confirmarAltaEspectador("lachiqui", "Mirtha", "Legrand", "lachiqui@hotmail.com.ar", fechaNac, "", "1o1vbm");
			fechaNac = formato.parse("08/05/1937");
			iusuario.confirmarAltaEspectador("cbochinche", "Cacho", "Bochinche", "cbochinche@vera.com.uy", fechaNac, "", "ultraton01");
			
			//Cargar Artista
			fechaNac = formato.parse("1/1/1977");
			iusuario.confirmarAltaArtista("vpeople", "Village" , "People" , "vpeople@tuta.io" , fechaNac, "https://bit.ly/36uctpI", "asdfg456", "Village People es una innovadora formación musical\n" + 
					"de estilo disco de finales de los años 70. Fue famosa\n" + 
					"tanto por sus peculiares disfraces, como por sus\n" + 
					"canciones pegadizas, con letras sugerentes y llenas de\n" + 
					"dobles sentidos." , "Grupo americano del disco creado\n" + 
							"por Jacques Morali y Henry Belolo\n" + 
							"en 1977. Según Marjorie Burgess,\n" + 
							"todo comenzó cuando Morali fue a\n" + 
							"un bar gay de Nueva York una\n" + 
							"noche y notó al bailarín Felipe Rose\n" + 
							"vestido como un nativo americano.", "http://www.officialvillag/");
			fechaNac = formato.parse("14/6/1980");
			iusuario.confirmarAltaArtista("dmode", "Depeche" , "Mode" , "dmode@tuta.io" , fechaNac, "https://bit.ly/2GB7vME", "123rtgfdv", "Depeche Mode es un grupo inglés de música\n" + 
					"electrónica formado en Basildon, Essex, en 1980 por\n" + 
					"Vicent Clarke y Andrew John Fletcher, a los que se\n" + 
					"unieron Martin Lee Gore y poco después David Gahan.\n" + 
					"Actualmente se le considera como grupo de música\n" + 
					"alternativa." , "", "http://www.depechemod/");
			fechaNac = formato.parse("22/6/1953");
			iusuario.confirmarAltaArtista("clauper", "Cyndi" , "Lauper" , "clauper@hotmail.com" , fechaNac, "https://bit.ly/34zFWvV", "poiuy086", "Cynthia Ann Stephanie Lauper, conocida simplemente\n" + 
					"como Cyndi Lauper, es una cantautora, actriz y\n" + 
					"empresaria estadounidense. Después de participar en\n" + 
					"el grupo musical, Blue Angel, en 1983 firmó con\n" + 
					"Portrait Records (filial de Epic Records) y lanzó su\n" + 
					"exitoso álbum debut She's So Unusual a finales de ese\n" + 
					"mismo año. Siguió lanzando una serie de álbumes en\n" + 
					"los que encontró una inmensa popularidad, superando\n" + 
					"los límites de contenido de las letras de sus canciones." , "Cynthia Ann Stephanie Lauper\n" + 
							"(Brooklyn, Nueva York; 22 de junio\n" + 
							"de 1953). ", "cyndilauper.com");
			fechaNac = formato.parse("23/9/1949");
			iusuario.confirmarAltaArtista("bruceTheBoss", "Bruce" , "Springsteen" , "bruceTheBoss@gmail.com" , fechaNac, "https://bit.ly/34hFwde", "GTO468", "Bruce Frederick Joseph Springsteen (Long Branch,\n" + 
					"Nueva Jersey, 23 de septiembre de 1949), más conocido\n" + 
					"como Bruce Springsteen, es un cantante, músico y\n" + 
					"compositor estadounidense. " , "naci blabla", "brucespringsteen.n\n" + 
							"et");
			fechaNac = formato.parse("1/1/1998");
			iusuario.confirmarAltaArtista("tripleNelson", "La Triple" , "Nelson" , "tripleNelson@tuta.io" , fechaNac, "https://bit.ly/2Geps4a", "HGF135", "La Triple Nelson es un grupo de rock uruguayo\n" + 
					"formado en enero de 1998 e integrado inicialmente por\n" + 
					"Christian Cary (guitarra y voz), Fernando \"Paco\" Pintos\n" + 
					"(bajo y coros) y Rubén Otonello (actualmente su nuevo\n" + 
					"baterista es Rafael Ugo)." , "naci blabla", "http://www.latriplenelso/");
			fechaNac = formato.parse("14/2/1987");
			iusuario.confirmarAltaArtista("la_ley", "La" , "Ley" , "la_ley@tuta.io" , fechaNac, "https://bit.ly/33oXxqQ", "lkj65D", "La Ley fue una banda chilena de rock formada en 1987\n" + 
					"por iniciativa del tecladista y guitarrista. En un\n" + 
					"principio, La Ley tenía la aspiración de ser un grupo de\n" + 
					"música tecno. Este disco resulta ser un éxito de ventas\n" + 
					"y reciben una invitación al Festival Internacional de\n" + 
					"Viña del Mar de febrero de 1994." , "naci blabla", "http://www.lasleyesdene/");
			fechaNac = formato.parse("13/8/1981");
			iusuario.confirmarAltaArtista("lospimpi", "Pimpinela" , "Pimpinela" , "lospimpi@gmail.com" , fechaNac, "https://bit.ly/30t4tRI", "jhvf395", "Pimpinela es un dúo musical argentino compuesto por\n" + 
					"los hermanos Lucía Galán y Joaquín Galán. Pimpinela\n" + 
					"ha editado veinticuatro discos" , "naci blabla", "http://www.pimpinela.n/");
			fechaNac = formato.parse("5/3/1940");
			iusuario.confirmarAltaArtista("dyangounchained", "Dyango" , "Ango" , "dyangounchained@gmail.com" , fechaNac, "https://bit.ly/3jwA8JS", "ijngr024", "José Gómez Romero, conocido artísticamente como\n" + 
					"Dyango es un cantante español de música romántica." , "naci blabla", "");
			fechaNac = formato.parse("17/7/1952");
			iusuario.confirmarAltaArtista("alcides", "Alcides" , "Violeta" , "alceides@tuta.io" , fechaNac, "https://bit.ly/3nnpAiu", "987mnbgh", "Su carrera comienza en 1976 cuando forma la banda\n" + 
					"Los Playeros junto a su hermano Víctor. Al poco\n" + 
					"tiempo se mudan a San Luis donde comienzan a\n" + 
					"hacerse conocidos en la escena musical. Su éxito a nivel\n" + 
					"nacional llega a comienzos de los años 1990 cuando\n" + 
					"desembarca en Buenos Aires y graba el éxito \"Violeta\",\n" + 
					"originalmente compuesta e interpretada en 1985 por el\n" + 
					"músico brasileño Luiz Caldas bajo el título «Fricote»." , "naci blabla", "");
			
			//SEGUIDORES
			iusuario.SeguirUsuario("vpeople", "bruceTheBoss");
			iusuario.SeguirUsuario("dmode", "clauper");
			iusuario.SeguirUsuario("dmode", "bruceTheBoss");
			iusuario.SeguirUsuario("clauper", "vpeople");
			iusuario.SeguirUsuario("clauper", "dmode");
			iusuario.SeguirUsuario("clauper", "dyangounchained");
			iusuario.SeguirUsuario("bruceTheBoss", "vpeople");
			iusuario.SeguirUsuario("bruceTheBoss", "dmode");
			iusuario.SeguirUsuario("bruceTheBoss", "clauper");
			iusuario.SeguirUsuario("bruceTheBoss", "house");
			iusuario.SeguirUsuario("tripleNelson", "clauper");
			iusuario.SeguirUsuario("tripleNelson", "la_ley");
			iusuario.SeguirUsuario("tripleNelson", "waston");
			iusuario.SeguirUsuario("la_ley", "dmode");
			iusuario.SeguirUsuario("la_ley", "lospimpi");
			iusuario.SeguirUsuario("la_ley", "waston");
			iusuario.SeguirUsuario("lospimpi", "dmode");
			iusuario.SeguirUsuario("lospimpi", "dyangounchained");
			iusuario.SeguirUsuario("lospimpi", "alcides");
			iusuario.SeguirUsuario("dyangounchained", "tripleNelson");
			iusuario.SeguirUsuario("dyangounchained", "lospimpi");
			iusuario.SeguirUsuario("alcides", "lospimpi");
			iusuario.SeguirUsuario("alcides", "sergiop");
			iusuario.SeguirUsuario("eleven11", "lospimpi");
			iusuario.SeguirUsuario("eleven11", "dyangounchained");
			iusuario.SeguirUsuario("eleven11", "waston");
			iusuario.SeguirUsuario("eleven11", "chino");
			iusuario.SeguirUsuario("eleven11", "tonyp");
			iusuario.SeguirUsuario("costas", "vpeople");
			iusuario.SeguirUsuario("costas", "dmode");
			iusuario.SeguirUsuario("costas", "clauper");
			iusuario.SeguirUsuario("costas", "bruceTheBoss");
			iusuario.SeguirUsuario("costas", "tripleNelson");
			iusuario.SeguirUsuario("costas", "la_ley");
			iusuario.SeguirUsuario("costas", "lospimpi");
			iusuario.SeguirUsuario("costas", "dyangounchained");
			iusuario.SeguirUsuario("costas", "alcides");
			iusuario.SeguirUsuario("waston", "dmode");
			iusuario.SeguirUsuario("waston", "clauper");
			iusuario.SeguirUsuario("waston", "bruceTheBoss");
			iusuario.SeguirUsuario("waston", "house");
			iusuario.SeguirUsuario("house", "bruceTheBoss");
			iusuario.SeguirUsuario("house", "la_ley");
			iusuario.SeguirUsuario("house", "dyangounchained");
			iusuario.SeguirUsuario("sergiop", "vpeople");
			iusuario.SeguirUsuario("sergiop", "la_ley");
			iusuario.SeguirUsuario("sergiop", "lospimpi");
			iusuario.SeguirUsuario("sergiop", "chino");
			iusuario.SeguirUsuario("sergiop", "tonyp");
			iusuario.SeguirUsuario("sergiop", "lachiqui");
			iusuario.SeguirUsuario("chino", "alcides");
			iusuario.SeguirUsuario("chino", "sergiop");
			iusuario.SeguirUsuario("tonyp", "alcides");
			iusuario.SeguirUsuario("tonyp", "sergiop");
			iusuario.SeguirUsuario("lachiqui", "lospimpi");
			iusuario.SeguirUsuario("lachiqui", "alcides");
			iusuario.SeguirUsuario("cbochinche", "la_ley");
			iusuario.SeguirUsuario("cbochinche", "lospimpi");
			iusuario.SeguirUsuario("cbochinche", "alcides");
			iusuario.SeguirUsuario("cbochinche", "tonyp");
			iusuario.SeguirUsuario("cbochinche", "chino");
			iusuario.SeguirUsuario("cbochinche", "lachiqui");
			
			
			
			
			// PLATAFORMAS (Nombre, Descripcion, URL)
						iplataforma.AltaPlataforma("Instagram Live", "Funcionalidad de la red social Instagram, con la que\n" + 
								"los usuarios pueden transmitir vídeos en vivo.", "https://www.instagram.com/liveoficial");
						iplataforma.AltaPlataforma("Facebook Watch","Servicio de video bajo demanda operado por\n" + 
								"Facebook.","https://www.facebook.com/watch/");
						iplataforma.AltaPlataforma("Twitter Live","Aplicación de Twitter para la transmisión de video\n" + 
								"en directo (streaming).","https://twitter.com/");
						iplataforma.AltaPlataforma("Youtube","Sitio web de origen estadounidense dedicado a\n" + 
								"compartir videos.","https://www.youtube.com/");
					
			//Alta  Categorias
			icategoria.AltaCategoria("Bandas Latinas");
			icategoria.AltaCategoria("Solistas");
			icategoria.AltaCategoria("Rock en Ingles");
			icategoria.AltaCategoria("Musica Tropical");
						
						
			// ESPECTACULOS (nombrePlataforma, nickArtista, nomEspectaculo, descripcion, minEsp, maxEsp, URL, costo, fecha, duracion)
			Date fechaAltaEspectaculo;
			Set<String> cat = new HashSet<String>();
			
			fechaAltaEspectaculo = formato.parse("31/03/2020");				
			cat.add("Rock en Ingles");
			iplataforma.altaEspectaculo("Instagram Live","vpeople","Los Village Volvieron","Espectáculo de retorno de los Village People.",10,800,"https://www.instagram.com/realvillagepeople/",550,fechaAltaEspectaculo,90, "", cat);
			iplataforma.AceptarEspectaculo("Los Village Volvieron");
			
			fechaAltaEspectaculo = formato.parse("20/04/2020");
			cat.add("Rock en Ingles");
			iplataforma.altaEspectaculo("Facebook Watch","dmode","Global Spirit","Espectáculo donde se presenta el álbum Spirit.",30,1300,"https://es-la.facebook.com/depechemode/",750,fechaAltaEspectaculo,120, "", cat);
			iplataforma.AceptarEspectaculo("Global Spirit");
			
			fechaAltaEspectaculo = formato.parse("30/05/2020");
			cat.add("Solistas");
			iplataforma.altaEspectaculo("Twitter Live","clauper","Memphis Blues World","Espectáculo promoviendo álbum Memphis Blues.",5,1000,"https://twitter.com/cyndilauper",800,fechaAltaEspectaculo,110, "", cat);
			iplataforma.AceptarEspectaculo("Memphis Blues World");
			
			fechaAltaEspectaculo = formato.parse("07/06/2020");
			cat.add("Rock en Ingles");
			iplataforma.altaEspectaculo("Youtube","bruceTheBoss","Springsteen on Broadway","Springsteen tocando guitarra o piano y relatando anécdotas recogidas en su autobiografía de 2016, Born to Run.",100,1500,"https://www.youtube.com/BruceSpringsteen",980,fechaAltaEspectaculo,100, "", cat);
			iplataforma.AceptarEspectaculo("Springsteen on Broadway");
			
			fechaAltaEspectaculo = formato.parse("08/07/2020");
			cat.add("Bandas Latinas");
			iplataforma.altaEspectaculo("Twitter Live","lospimpi","Bien de Familia","El dúo estará presentando sus más sonados éxitos y también nuevas canciones.",10,500,"https://twitter.com/PimpinelaNet",500,fechaAltaEspectaculo,150, "", cat);
			iplataforma.AceptarEspectaculo("Bien de Familia");
			
			fechaAltaEspectaculo = formato.parse("31/07/2020");
			cat.add("Musica Tropical");
			iplataforma.altaEspectaculo("Twitter Live","alcides","30 años","Espectáculo conmemorando los 30 años de Violeta.",30,150,"https://twitter.com/alcides_shows",450,fechaAltaEspectaculo,80, "", cat);
			iplataforma.AceptarEspectaculo("30 años");
			
			fechaAltaEspectaculo = formato.parse("09/01/2020");
			cat.add("Solistas");
			iplataforma.altaEspectaculo("Youtube","dyangounchained","Grandes Exitos 2020","Espectaculo de gira con los temas de siempre",5,1000,"https://www.youtube.com/c/dyangooficial",550,fechaAltaEspectaculo,120, "", cat);
			iplataforma.RechazarEspectaculo("Grandes Exitos 2020");
			
			fechaAltaEspectaculo = formato.parse("20/05/2020");
			cat.add("Bandas Latinas");
			iplataforma.altaEspectaculo("Instagram Live","tripleNelson","Llego a Casa","Primer Espectaculo con transmision por streaming",100,1500,"https://www.instagram.com/latriplenelson/",400,fechaAltaEspectaculo,100, "", cat);
			
			//FUNCIONES (nombrePlataforma, nombreEspectaculo, nombre, inicio, artistas, alta)
			SimpleDateFormat FormatoInicio = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fechaAltaFuncion;
			Date fechaInicioFuncion;
			Set<String> artistas = new HashSet<String>();
			
			//F1
			artistas.add("dmode"); 
			artistas.add("clauper"); 
			fechaInicioFuncion = FormatoInicio.parse("2020-04-15 15:30:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-03-31 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Instagram Live","Los Village Volvieron", "Los Village Volvieron - 1", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F2
			artistas.clear();
			artistas.add("bruceTheBoss");
			fechaInicioFuncion = FormatoInicio.parse("2020-05-01 17:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-03-31 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "Los Village Volvieron - 2", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F3
			artistas.clear();
			artistas.add("bruceTheBoss");
			artistas.add("clauper");
			fechaInicioFuncion = FormatoInicio.parse("2020-06-01 18:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-03-31 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "Los Village Volvieron - 3", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F4
			artistas.clear();
			artistas.add("vpeople");
			fechaInicioFuncion = FormatoInicio.parse("2020-06-10 19:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-04-20 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Facebook Watch", "Global Spirit", "Global Spirit (I)", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F5
			artistas.clear();
			artistas.add("clauper");
			artistas.add("bruceTheBoss");
			fechaInicioFuncion = FormatoInicio.parse("2020-07-10 20:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-04-20 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Facebook Watch", "Global Spirit", "Global Spirit (II)", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F6
			artistas.clear();
			artistas.add("lospimpi");
			fechaInicioFuncion = FormatoInicio.parse("2020-08-10 17:45:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-05-30 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Facebook Watch", "Global Spirit", "Global Spirit (III)", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
			
			//F7
			artistas.clear();
			artistas.add("bruceTheBoss");
			fechaInicioFuncion = FormatoInicio.parse("2020-8-15 17:45:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-05-30 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Memphis Blues World", "Memphis Blues World - A", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F8
			artistas.clear();
			artistas.add("bruceTheBoss");
			artistas.add("dmode");
			fechaInicioFuncion = FormatoInicio.parse("2020-8-31 19:30:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-05-30 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Memphis Blues World", "Memphis Blues World - B", fechaInicioFuncion, artistas, fechaAltaFuncion, "");

			//F9
			artistas.clear();
			artistas.add("lospimpi");
			artistas.add("bruceTheBoss");
			fechaInicioFuncion = FormatoInicio.parse("2020-9-30 20:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-05-30 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Memphis Blues World", "Memphis Blues World - C", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F10
			artistas.clear();
			artistas.add("dmode");
			artistas.add("tripleNelson");
			fechaInicioFuncion = FormatoInicio.parse("2020-9-1 19:30:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-06-07 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Youtube","Springsteen on Broadway", "Springsteen on Broadway - i", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F11
			artistas.clear();
			artistas.add("tripleNelson");
			artistas.add("la_ley");
			fechaInicioFuncion = FormatoInicio.parse("2020-9-30 17:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-06-07 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Youtube","Springsteen on Broadway", "Springsteen on Broadway - ii", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F12
			artistas.clear();
			artistas.add("la_ley");
			fechaInicioFuncion = FormatoInicio.parse("2020-10-15 20:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-06-07 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Youtube","Springsteen on Broadway", "Springsteen on Broadway - iii", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F17
			artistas.clear();
			artistas.add("lospimpi");
			artistas.add("dyangounchained");
			fechaInicioFuncion = FormatoInicio.parse("2020-10-01 19:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-07-31 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","30 años", "30 años - 2", fechaInicioFuncion, artistas, fechaAltaFuncion, "");	
		
			//F16
			artistas.clear();
			artistas.add("dyangounchained");
			fechaInicioFuncion = FormatoInicio.parse("2020-09-01 21:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-07-31 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","30 años", "30 años - 1", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F15
			artistas.clear();
			fechaInicioFuncion = FormatoInicio.parse("2020-11-25 17:45:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-07-08 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Bien de Familia", "Bien de Familia - C", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F14
			artistas.clear();
			artistas.add("tripleNelson");
			fechaInicioFuncion = FormatoInicio.parse("2020-10-25 18:30:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-07-08 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Bien de Familia", "Bien de Familia - B", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
			
			//F13
			artistas.clear();
			artistas.add("alcides");
			fechaInicioFuncion = FormatoInicio.parse("2020-09-25 19:00:00");
			fechaAltaFuncion = FormatoInicio.parse("2020-07-08 00:00:00");
			iplataforma.ConfirmarAltaFuncionEspectaculo("Twitter Live","Bien de Familia", "Bien de Familia - A", fechaInicioFuncion, artistas, fechaAltaFuncion, "");
	
			//Cargar Paquetes
			IPaquete ipaquete= fab.getIPaquete();
			
			Date inicio = formato.parse("01/05/2020");
			Date fin = formato.parse("31/07/2020");
			Date alta = formato.parse("30/4/2020");
			ipaquete.ConfirmarAltaPaquete("Paquete de Bandas", "Paquete de bandas musicales" , inicio, fin, 20.0, alta, "https://bit.ly/3l9Vihe");
			

			inicio = formato.parse("01/08/2020");
			fin = formato.parse("30/09/2020");
			alta = formato.parse("15/7/2020");
			ipaquete.ConfirmarAltaPaquete("Paquete Solistas", "Paquete de solistas." , inicio, fin, 30.0, alta, "https://bit.ly/2HSF4e0");
			
			inicio = formato.parse("15/08/2020");
			fin = formato.parse("15/11/2020");
			alta = formato.parse("1/8/2020");
			ipaquete.ConfirmarAltaPaquete("Paquete Latino", "Paquete de espectáculos latinos." , inicio, fin, 15.0, alta, "https://bit.ly/2HSF4e0/3ndBhIw");

			

			//REGISTRO A FUNCIONES(NombrePlataforma, NombreEspectaculo, Nickname, NombreFuncion, Fecha, TipoRegistro, IntRegistro1, IntRegistro2, IntRegistro3, NombrePaquete, Costo)
			//TipoRegistro: Tipo_1 : No importa lo que vaya en IntRegistros ni en NombrePaquete, costo del espectaculo.
			//TipoRegisto: Tipo_2 : No importa lo que vaya en Paquete, y costo 0.
			formato = new SimpleDateFormat("dd/MM/yyyy");
			Date FechaRegistro;
			
			//R1
			FechaRegistro = formato.parse("09/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "costas", "Los Village Volvieron - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R2
			FechaRegistro = formato.parse("10/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "sergiop", "Los Village Volvieron - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R3
			FechaRegistro = formato.parse("12/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "chino", "Los Village Volvieron - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R4
			FechaRegistro = formato.parse("15/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "chino", "Los Village Volvieron - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R5
			FechaRegistro = formato.parse("20/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "tonyp", "Los Village Volvieron - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R6
			FechaRegistro = formato.parse("25/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "costas", "Los Village Volvieron - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R7
			FechaRegistro = formato.parse("28/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "lachiqui", "Los Village Volvieron - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R8
			FechaRegistro = formato.parse("16/04/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "cbochinche", "Los Village Volvieron - 3", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R9
			FechaRegistro = formato.parse("15/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "costas", "Los Village Volvieron - 3", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R10
			FechaRegistro = formato.parse("20/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Instagram Live", "Los Village Volvieron", "lachiqui", "Los Village Volvieron - 3", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 550.0);
			
			//R11
			FechaRegistro = formato.parse("05/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "eleven11", "Global Spirit (I)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			
			//R12
			FechaRegistro = formato.parse("10/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "waston", "Global Spirit (I)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R13
			FechaRegistro = formato.parse("15/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "sergiop", "Global Spirit (I)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R14
			FechaRegistro = formato.parse("20/05/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "tonyp", "Global Spirit (I)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R15
			FechaRegistro = formato.parse("08/06/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "house", "Global Spirit (II)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R16
			FechaRegistro = formato.parse("13/06/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "waston", "Global Spirit (II)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R17
			FechaRegistro = formato.parse("25/06/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "lachiqui", "Global Spirit (II)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R18
			FechaRegistro = formato.parse("05/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "cbochinche", "Global Spirit (III)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R19
			FechaRegistro = formato.parse("11/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "sergiop", "Global Spirit (III)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			//R20
			FechaRegistro = formato.parse("18/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Facebook Watch", "Global Spirit", "chino", "Global Spirit (III)", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 750.0);
			
			//R21
			FechaRegistro = formato.parse("19/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "lachiqui", "Memphis Blues World - A", FechaRegistro, TipoRegistro.Tipo_2, 1, 2, 3, "", 0.0);
			
			//R22
			FechaRegistro = formato.parse("17/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "eleven11", "Memphis Blues World - B", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 800.0);
			
			//R23
			FechaRegistro = formato.parse("20/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "house", "Memphis Blues World - B", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 800.0);
			//R24
			FechaRegistro = formato.parse("23/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "chino", "Memphis Blues World - B", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 800.0);
			
			//R25
			FechaRegistro = formato.parse("15/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "costas", "Memphis Blues World - C", FechaRegistro, TipoRegistro.Tipo_2, 1, 2, 3, "", 0.0);
			
			
			//R26
			FechaRegistro = formato.parse("26/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Memphis Blues World", "waston", "Memphis Blues World - C", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 800.0);
			
			//R27
			FechaRegistro = formato.parse("19/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "chino", "Springsteen on Broadway - i", FechaRegistro, TipoRegistro.Tipo_2, 1, 2, 3, "", 0.0);
			
			
			//R28
			FechaRegistro = formato.parse("19/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "tonyp", "Springsteen on Broadway - i", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R29
			FechaRegistro = formato.parse("19/07/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "lachiqui", "Springsteen on Broadway - i", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R30
			FechaRegistro = formato.parse("01/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "sergiop", "Springsteen on Broadway - ii", FechaRegistro, TipoRegistro.Tipo_2, 1, 2, 3, "", 0.0);
			
			//R31
			FechaRegistro = formato.parse("30/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "house", "Springsteen on Broadway - ii", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R32
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "eleven11", "Springsteen on Broadway - ii", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R33
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "costas", "Springsteen on Broadway - iii", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R34
			FechaRegistro = formato.parse("01/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "waston", "Springsteen on Broadway - iii", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R35
			FechaRegistro = formato.parse("05/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Youtube", "Springsteen on Broadway", "sergiop", "Springsteen on Broadway - iii", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 980.0);
			
			//R36
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Bien de Familia", "house", "Bien de Familia - A", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 500.0);
			
			//R37
			FechaRegistro = formato.parse("03/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Bien de Familia", "cbochinche", "Bien de Familia - A", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 500.0);
			
			//R38
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Bien de Familia", "eleven11", "Bien de Familia - B", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 500.0);
			
			//R39
			FechaRegistro = formato.parse("06/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Bien de Familia", "cbochinche", "Bien de Familia - B", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 500.0);
			
			//R40
			FechaRegistro = formato.parse("01/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "Bien de Familia", "costas", "Bien de Familia - C", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 500.0);
			
			//R41
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "sergiop", "30 años - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//R42
			FechaRegistro = formato.parse("20/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "eleven11", "30 años - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//R43
			FechaRegistro = formato.parse("31/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "tonyp", "30 años - 1", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//R44
			FechaRegistro = formato.parse("16/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "chino", "30 años - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//R45
			FechaRegistro = formato.parse("20/08/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "tonyp", "30 años - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//R46
			FechaRegistro = formato.parse("02/09/2020");
			iusuario.confirmarRegistroFuncionEspectaculo("Twitter Live", "30 años", "costas", "30 años - 2", FechaRegistro, TipoRegistro.Tipo_1, 0, 0, 0, "", 450.0);
			
			//Espectaculos que integran paquetes
			
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete de Bandas","Instagram Live", "Los Village Volvieron");
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete de Bandas","Facebook Watch", "Global Spirit");
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete Solistas","Twitter Live", "Memphis Blues World");
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete Solistas","Youtube", "Springsteen on Broadway");
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete Latino","Twitter Live", "Bien de Familia");
			ipaquete.ConfirmarAgregarEspectaculoPaquete("Paquete Latino","Twitter Live", "30 años");
    		
			writer.println("DATOS CARGADOS");
    	}
    		catch(Exception e) {}
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	
    /*static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws UsuarioNoEncontrado
	{
		return GestorUsuario.getInstance().buscarUsuario(
				(String) request.getSession().getAttribute("usuario_logueado")
			);
	}*/

     /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}