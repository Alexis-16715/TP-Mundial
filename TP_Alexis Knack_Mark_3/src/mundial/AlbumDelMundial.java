package mundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlbumDelMundial implements IAlbumDelMundial {
	Fabrica fabrica = new Fabrica();
	
	//Esto seria las bases de datos para guardar los usuarios y los albumes. Se utiliza el DNI en los Integer
	Map<Integer, Usuario> usuarios = new HashMap <Integer, Usuario>();
	Map<Integer, Album> Albums = new HashMap <Integer, Album>();
	Map<Integer, AlbumTop10> AlbumsExtendidos = new HashMap <Integer, AlbumTop10>();
	Map<Integer, Integer> sorteoInstantaneo = new HashMap<>();
	Map<Integer, String> FiguritasConCodigoPromocional = new HashMap<>();
	//Aqui se terminaria las bases de datos
	
	String tradicional = "Tradicional";
	String extendido = "Extendido";
	String web = "Web";
	int cantidadFiguritasPorPaquete = 4;

	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		if (usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("Este ya esta registrado");
		}
		if(tipoAlbum != tradicional && tipoAlbum != extendido && tipoAlbum != web) {
			throw new IllegalArgumentException("Error, por favor selecione entre estos tres tipos de Albumes: Tradicional, Extendido o Web");
		}
		Map<Figurita, Integer> inventarioUsuario = new HashMap<>();
		///////////////////////////////////////////////////////
		Map<FiguritaTop10, Integer> inventarioUsuarioTop10 = new HashMap<>();
		//Lo no es la manera mas elegante pero lo que nesesito/
		///////////////////////////////////////////////////////
		if(tipoAlbum == tradicional) {
			Albums.put(dni, fabrica.crearAlbumTradicional());
			Usuario usuarioDelMundial = new Usuario(nombre, tipoAlbum, fabrica.getPremios()[0],inventarioUsuario, inventarioUsuarioTop10);
			usuarios.put(dni, usuarioDelMundial);
		}
		if(tipoAlbum == extendido) {
			Albums.put(dni, fabrica.crearAlbumTradicional());
			AlbumsExtendidos.put(dni, fabrica.crearAlbumExtendido());
			Usuario usuarioDelMundial = new Usuario(nombre, tipoAlbum, fabrica.getPremios()[1],inventarioUsuario, inventarioUsuarioTop10);
			usuarios.put(dni, usuarioDelMundial);
		}
		if(tipoAlbum == web) {
			Albums.put(dni, fabrica.crearAlbumWeb());
			Usuario usuarioDelMundial = new Usuario(nombre, tipoAlbum, fabrica.getPremios()[2],inventarioUsuario, inventarioUsuarioTop10);
			usuarios.put(dni, usuarioDelMundial);
		}
		return 0;
	}

	@Override
	public void comprarFiguritas(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Map<Figurita, Integer> LasFiguritasDelUsuario= new HashMap <>();
		List<Figurita> CreacionDelPaquete = new ArrayList <>();
		
		Usuario verUsuario= usuarios.get(dni);
		
		LasFiguritasDelUsuario = verUsuario.getInventarioUsuario();
		
		CreacionDelPaquete = fabrica.generarSobre(cantidadFiguritasPorPaquete);
		
		for(int i = 0; i < CreacionDelPaquete.size(); i++) {
			if(LasFiguritasDelUsuario.containsKey(CreacionDelPaquete.get(i))) {
				LasFiguritasDelUsuario.put(CreacionDelPaquete.get(i), LasFiguritasDelUsuario.get(CreacionDelPaquete.get(i)) + 1);
			} else {
				LasFiguritasDelUsuario.put(CreacionDelPaquete.get(i), 1);
			}
		}
		verUsuario.SetInventarioUsuario(LasFiguritasDelUsuario);

	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		if(usuarios.get(dni).getAlbum() != extendido) {
			throw new IllegalArgumentException("Usted tiene el Album " + usuarios.get(dni).getAlbum() + " ese album no se puede comprar estas figuritas");
		}
		Map<FiguritaTop10, Integer> LasFiguritasDelUsuario= new HashMap <FiguritaTop10, Integer>();
		List<FiguritaTop10> CreacionDelPaquete = new ArrayList <>();
		
		Usuario verUsuario= usuarios.get(dni);
		
		LasFiguritasDelUsuario = verUsuario.getInventarioUsuarioTop10();
		
		CreacionDelPaquete = fabrica.generarSobreTop10(cantidadFiguritasPorPaquete);
		
		for(int i = 0; i < CreacionDelPaquete.size(); i++) {
			if(LasFiguritasDelUsuario.containsKey(CreacionDelPaquete.get(i))) {
				LasFiguritasDelUsuario.put(CreacionDelPaquete.get(i), LasFiguritasDelUsuario.get(CreacionDelPaquete.get(i)) + 1);
			} else {
				LasFiguritasDelUsuario.put(CreacionDelPaquete.get(i), 1);
			}
		}
		verUsuario.SetInventarioUsuarioTop10(LasFiguritasDelUsuario);

	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		if(FiguritasConCodigoPromocional.containsKey(dni)) {
			throw new IllegalArgumentException("Ya se uso este codigo de Promocional");
		}
		if(usuarios.get(dni).getAlbum() != web) {
			throw new IllegalArgumentException("Usted tiene el Album " + usuarios.get(dni).getAlbum() + " ese album no puede utilizar para obtener el codigo Promocional");
		}
		FiguritasConCodigoPromocional.put(dni, usuarios.get(dni).getUsuario());
		comprarFiguritas(dni);

	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Album verAlbum = Albums.get(dni);
		Usuario verUsuario= usuarios.get(dni);
		
		////////////////////////////////////////////////////////
		Map<Figurita,Integer> LasFiguritasDelUsuario= new HashMap <Figurita,Integer>();
		LasFiguritasDelUsuario = verUsuario.getInventarioUsuario();
		Map<Figurita,Integer> FiguritaRestantes= new HashMap <Figurita,Integer>();
		/////Esto son los datos para las figuritas normales//////
		////////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////////
		List<String> MostarResultados= new ArrayList <>();
		/////////Esto solo se utiliza para el return////////////
		
		LasFiguritasDelUsuario.forEach((figurita, cantidad) -> {

			//Aqui comienza el if
			if(!verAlbum.getFigurita().containsKey(figurita.getId())) {
				verAlbum.getFigurita().put(figurita.getId(), figurita);
				verAlbum.SetFigurita(verAlbum.getFigurita());
				MostarResultados.add("Pais:" + figurita.getPais().toString() + " Jugador:" + figurita.getNombreDelJugador().toString());
				if(cantidad - 1 > 0) {
					FiguritaRestantes.put(figurita, cantidad - 1);
				}
			} else {
				FiguritaRestantes.put(figurita, cantidad);
			}
			//Aqui termina
		});
		verUsuario.SetInventarioUsuario(FiguritaRestantes);
		
		return MostarResultados;
	}

	@Override
	public boolean llenoAlbum(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Album verAlbum = Albums.get(dni);
		Usuario verUsuario= usuarios.get(dni);
		boolean llenoElAlbum = false;
		llenoElAlbum = llenoElAlbum || (verAlbum.getFigurita().size() == fabrica.getTamanoDelAlbum());
		if(verUsuario.getAlbum() == extendido) {
			AlbumTop10 verAlbumTop10 = AlbumsExtendidos.get(dni);
			llenoElAlbum = llenoElAlbum && verAlbumTop10.getFigurita().size() == fabrica.getTamanoDelAlbumExtendido();
		}
		return llenoElAlbum;
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		if(usuarios.get(dni).getAlbum() != tradicional) {
			throw new IllegalArgumentException("Usted tiene el Album " + usuarios.get(dni).getAlbum() + " ese album no puede utilizar el codigo Promocional");
		}
		if(sorteoInstantaneo.containsKey(dni)) {
			throw new IllegalArgumentException("Ya pediste el sorteo Instantaneo");
		}
		int Aleatorio = 0;
		Aleatorio = (int) (Math.random() * (1000));
		sorteoInstantaneo.put(dni, Aleatorio);
		return sorteoInstantaneo.get(dni).toString();
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Usuario verUsuario= usuarios.get(dni);
		Map<Figurita,Integer> LasFiguritasDelUsuario= new HashMap <>();
		LasFiguritasDelUsuario = verUsuario.getInventarioUsuario();
		
		int valor = 0;
		List<Integer> MostarResultados= new ArrayList <>();
		LasFiguritasDelUsuario.forEach((figurita, cantidad) -> {
			if(cantidad >= 1) {
				MostarResultados.add(figurita.getId());
			}
		});
		if(!MostarResultados.isEmpty()) {
			return MostarResultados.get(0);
		} 
		return -1;
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Usuario verUsuario= usuarios.get(dni);
		String tipoAlbum = verUsuario.getAlbum();
		
		Figurita cambiar = fabrica.getFigurita(codFigurita);
		usuarios.forEach((DNI, usuario) -> {
			//Aqui comienza el if
			if(tipoAlbum == usuario.getAlbum() && dni != DNI) {
//				Map<Figurita,Integer> LasFiguritasDelUsuario= new HashMap <>();
//				LasFiguritasDelUsuario = verUsuario.getInventarioUsuario();
				
				usuario.getInventarioUsuario().forEach((figurita, cantidad) -> {
					if(cantidad >= 1 && figurita.getValor() <= cambiar.getValor() && !verUsuario.getInventarioUsuario().containsKey(figurita)) {
						Map<Figurita,Integer> FiguritaUsuarioA= new HashMap <Figurita,Integer>();
						Map<Figurita,Integer> FiguritaUsuarioB= new HashMap <Figurita,Integer>();
						FiguritaUsuarioA = verUsuario.getInventarioUsuario();
						FiguritaUsuarioA.remove(cambiar);
						FiguritaUsuarioA.put(figurita, 1);
						verUsuario.SetInventarioUsuario(FiguritaUsuarioA);
						
						FiguritaUsuarioB = usuario.getInventarioUsuario();
						FiguritaUsuarioB.replace(figurita, cantidad, cantidad - 1);
					}
					
				});
			}
			//Aqui Termina
		});
		if(!verUsuario.getInventarioUsuario().containsKey(cambiar)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Usuario verUsuario= usuarios.get(dni);
		if(verUsuario.getInventarioUsuario().size() == 0) {
			return false;
		}
		
		int codigo = buscarFiguritaRepetida(dni);
		if(codigo == -1) {
			return false;
		}
		
		if(intercambiar(dni, codigo)) {
			return true;
		}

		return false;
	}

	@Override
	public String darNombre(int dni) {
		// TODO Auto-generated method stub
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		Usuario nombre= usuarios.get(dni);
		
		return nombre.getUsuario();
	}

	@Override
	public String darPremio(int dni) {
		if(!usuarios.containsKey(dni)) {
			throw new IllegalArgumentException("No esta registrado");
		}
		if(!llenoAlbum(dni)) {
			throw new IllegalArgumentException("No completo el Album");
		}
		Usuario verUsuario= usuarios.get(dni);
		return verUsuario.getPremio();
	}

	@Override
	public String listadoDeGanadores() {
		
		List<String> ganadadores = new ArrayList <String>();
		Albums.forEach((dni, album) -> {
			Usuario verUsuario= usuarios.get(dni);
			if(llenoAlbum(dni)) {
				ganadadores.add("DNI:" + dni.toString() +  " Nombre:" + verUsuario.getUsuario() + " y su premio:" + verUsuario.getPremio());
			}
		});
		if(ganadadores.size() > 0) {
			return ganadadores.toString();
		} else {
			return "";
		}
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		// TODO Auto-generated method stub
		List<String> participantes = new ArrayList <String>();
		Albums.forEach((dni, album) -> {
			Usuario verUsuario= usuarios.get(dni);
			List<String> contador = new ArrayList <String>();
			album.getFigurita().forEach((id, figurita) -> {
				if(figurita.getPais() == nombrePais) {
					contador.add(nombrePais);
				}
			});
			if(contador.size() == fabrica.getLugaresPorPais()) {
				participantes.add("DNI:"+ dni.toString() + " Nombre:" + verUsuario.getUsuario() + " y tipo de Album:" + verUsuario.getAlbum());
			}
		});
		
		return participantes;
	}
	
	@Override
	public String toString() {
		return usuarios.toString() + Albums.toString();
	}

}
