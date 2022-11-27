package it.its.bean;

public abstract class ElementoMultimediale extends ElementoGenerico{
	String titolo;
	int durata;
	
	public ElementoMultimediale(String titolo, int durata) {
		this.titolo = titolo;
		this.durata = durata;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	public abstract void play();
	 
	

}
