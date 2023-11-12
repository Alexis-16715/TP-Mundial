package mundial;

public class FiguritaTop10 {
	private String NombreDelJugador;
	private String SedeDelMundialYAno;
	private String pais;
	private int posicion;
	private int id;
	
	public FiguritaTop10 (String NombreDelJugador, String SedeDelMundialYAno, String pais,int posicion , int id) {
		
		this.NombreDelJugador = NombreDelJugador;
		this.SedeDelMundialYAno = SedeDelMundialYAno;
		this.pais = pais;
		this.posicion= posicion;
		this.id= id;
		
	}
	public FiguritaTop10() {
		
	}
	
	public String getNombreDelJugador() {
		return NombreDelJugador;
	}
	public void SetNombreDelJugador(String NombreDelJugador) {
		this.NombreDelJugador = NombreDelJugador;
	}
	public String getSedeDelMundialYAno() {
		return SedeDelMundialYAno;
	}
	public void SetSedeDelMundialYAno(String SedeDelMundialYAno) {
		this.SedeDelMundialYAno = SedeDelMundialYAno;
	}
	
	public String getPais() {
		return pais;
	}
	public void SetPais(String pais) {
		this.pais = pais;
	}
	
	public int getPosicion() {
		return posicion;
	}
	public void SetPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getId() {
		return id;
	}
	public void SetId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Jugador " + NombreDelJugador + " Sede del Mundial y Ano:" + SedeDelMundialYAno + " su posicion " + posicion + " y su pais" + pais;
	}

}
