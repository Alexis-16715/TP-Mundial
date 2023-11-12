package mundial;

public class Figurita {
	private String NombreDelJugador;
	private String Pais;
	private int Posicion;
	private int valor;
	private int id;
	
	public Figurita (String NombreDelJugador, String Pais, int Posicion , int valor, int id) {
		
		this.NombreDelJugador = NombreDelJugador;
		this.Pais = Pais;
		this.Posicion= Posicion;
		this.valor= valor;
		this.id= id;
		
	}
	public Figurita() {
		
	}
	
	public String getNombreDelJugador() {
		return NombreDelJugador;
	}
	public void SetNombreDelJugador(String NombreDelJugador) {
		this.NombreDelJugador = NombreDelJugador;
	}
	public String getPais() {
		return Pais;
	}
	public void SetPais(String Pais) {
		this.Pais = Pais;
	}
	public int getPosicion() {
		return Posicion;
	}
	public void SetPosicion(int Posicion) {
		this.Posicion = Posicion;
	}
	public int getValor() {
		return valor;
	}
	public void SetValor(int valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void SetId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Jugador " + NombreDelJugador + " Pais:" + Pais + " su posicion: " + Posicion + " y su valor: " + valor;
	}

}
