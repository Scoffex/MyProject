package it.its.bean;

public class Immagine extends ElementoGenerico implements ILuminosit�{

	String titolo;
	int luminosit�;
	
	public Immagine(String titolo, int luminosit�) {
		this.titolo = titolo;
		this.luminosit� = luminosit�;
	}

	
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getLuminosit�() {
		return luminosit�;
	}


	public void setLuminosit�(int luminosit�) {
		this.luminosit� = luminosit�;
	}


	public void Show() {
		System.out.println(titolo + "*".repeat(this.luminosit�));
		
	}

	@Override
	public void darker(int n) {
		this.luminosit� = reduce(luminosit�, n, "Luminosit�");
		
	}

	@Override
	public void brighter(int n) {
		this.luminosit� = aumento(luminosit�, n, "Luminosit�");
		
	}

}
