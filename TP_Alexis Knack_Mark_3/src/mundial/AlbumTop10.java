package mundial;

import java.util.Map;

public class AlbumTop10 {
private Map<Integer, FiguritaTop10> Figurita;
	
	public AlbumTop10 (Map<Integer, FiguritaTop10> Figurita) {
		
		this.Figurita = Figurita;
		
	}
	
	public AlbumTop10() {
		
	}
	
	public Map<Integer, FiguritaTop10> getFigurita() {
		
		return Figurita;
		
	}
	
	public void SetFigurita(Map<Integer, FiguritaTop10> Figurita) {
		
		this.Figurita = Figurita;
		
	}
	
	@Override
	public String toString() {
		return " "+ Figurita;
	}

}
