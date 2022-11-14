package it.its.bean;

public class Immagine extends ElementoGenerico implements ILuminosità{

	String titolo;
	int luminosità;
	
	public Immagine(String titolo, int luminosità) {
		this.titolo = titolo;
		this.luminosità = luminosità;
	}

	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getLuminosità() {
		return luminosità;
	}


	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}


	public void Show() {
		System.out.println(titolo + "*".repeat(this.luminosità));
		
	}

	@Override
	public void darker(int n) {
		this.luminosità = reduce(luminosità, n, "Luminosità");
		
	}

	@Override
	public void brighter(int n) {
		this.luminosità = aumento(luminosità, n, "Luminosità");
		
	}

}
