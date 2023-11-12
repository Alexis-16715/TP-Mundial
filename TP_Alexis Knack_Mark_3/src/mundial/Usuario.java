package mundial;

import java.util.List;
import java.util.Map;

public class Usuario {
	private String usuario;
	private String tipoAlbum;
	private String premio;
	private Map<Figurita, Integer> InventarioUsuario;
	private Map<FiguritaTop10, Integer> InventarioUsuarioTop10;
	// En este Map la Key es la key de los jugadores, y el valor es la cantidad de figuritas que tiene
	
	public Usuario (String usuario, String tipoAlbum, String premio, Map<Figurita, Integer> InventarioUsuario, Map<FiguritaTop10, Integer> InventarioUsuarioTop10) {
		this.usuario = usuario;
		this.tipoAlbum = tipoAlbum;
		this.premio = premio;
		this.InventarioUsuario = InventarioUsuario;
		this.InventarioUsuarioTop10 = InventarioUsuarioTop10;
	}
	public Usuario() {
	}
	public String getUsuario() {
		return usuario;
	}
	public void SetUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAlbum() {
		return tipoAlbum;
	}
	public void SetAlbum(String tipoAlbum) {
		this.tipoAlbum = tipoAlbum;
	}
	public String getPremio() {
		return premio;
	}
	public void SetPremio(String premio) {
		this.premio = premio;
	}
	public Map<Figurita, Integer> getInventarioUsuario() {
		return InventarioUsuario;
	}
	public void SetInventarioUsuario (Map<Figurita, Integer>InventarioUsuario) {
		this.InventarioUsuario = InventarioUsuario;
	}
	public Map<FiguritaTop10, Integer> getInventarioUsuarioTop10() {
		return InventarioUsuarioTop10;
	}
	public void SetInventarioUsuarioTop10 (Map<FiguritaTop10, Integer>InventarioUsuarioTop10) {
		this.InventarioUsuarioTop10 = InventarioUsuarioTop10;
	}
	@Override
	public String toString() {
		if(tipoAlbum == "Tradicional" || tipoAlbum == "Web") {
			return " Usuario: "+usuario +  ", Album " + tipoAlbum + ", inventario: figuritas normales " + InventarioUsuario.size();
		} else {
			return " Usuario: "+usuario +  ", Album " + tipoAlbum + ", inventario: figuritas normales " + InventarioUsuario.size() + " figuritas Top10 "+ InventarioUsuarioTop10.size();
		}
	}

}
