package mundial;

import java.util.Map;


public class Album {
private Map<Integer, Figurita> Figurita;
	
	public Album (Map<Integer, Figurita> Figurita) {
		
		this.Figurita = Figurita;
		
	}
	
	public Album() {
		
	}
	
	public Map<Integer, Figurita> getFigurita() {
		
		return Figurita;
		
	}
	
	public void SetFigurita(Map<Integer, Figurita> Figurita) {
		
		this.Figurita = Figurita;
		
	}
	
	@Override
	public String toString() {
		return " lleva completado: " + Figurita.size();
	}
}
