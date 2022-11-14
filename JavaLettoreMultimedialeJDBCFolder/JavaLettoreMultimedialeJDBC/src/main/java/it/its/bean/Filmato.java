package it.its.bean;

public class Filmato extends ElementoMultimediale implements ILuminosità, IVolume{

	int volume;
	int luminosità;
	
	public Filmato(String titolo, int durata, int volume, int luminosità) {
		super(titolo, durata);
		this.volume = volume;
		this.luminosità = luminosità;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getLuminosità() {
		return luminosità;
	}

	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.durata; i++) {
			System.out.println(titolo + "!".repeat(this.volume) + "*".repeat(this.luminosità));
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
		this.luminosità = reduce(this.luminosità, n, "Luminosità");
		
	}

	@Override
	public void brighter(int n) {
		this.luminosità = aumento(this.luminosità, n, "Luminosità");
	}
	
	
	

}
