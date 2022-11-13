package it.its.bean;

public class Filmato extends ElementoMultimediale implements ILuminosit�, IVolume{

	int volume;
	int luminosit�;
	
	public Filmato(String titolo, int durata, int volume, int luminosit�) {
		super(titolo, durata);
		this.volume = volume;
		this.luminosit� = luminosit�;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getLuminosit�() {
		return luminosit�;
	}

	public void setLuminosit�(int luminosit�) {
		this.luminosit� = luminosit�;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.durata; i++) {
			System.out.println(titolo + "!".repeat(this.volume) + "*".repeat(this.luminosit�));
		}
	}

	@Override
	public void weaker(int n) {
		// TODO Auto-generated method stub
		this.volume = reduce(volume, n, "Volume");
		
	}

	@Override
	public void louder(int n) {
		// TODO Auto-generated method stub
		this.volume = aumento(this.volume, n, "Volume");
	}
	
	@Override
	public void darker(int n) {
		this.luminosit� = reduce(this.luminosit�, n, "Luminosit�");
		
	}

	@Override
	public void brighter(int n) {
		this.luminosit� = aumento(this.luminosit�, n, "Luminosit�");
	}
	
	
	

}
