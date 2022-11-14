package it.its.bean;

public class Audio extends ElementoMultimediale implements IVolume{

	int volume;

	public Audio(String titolo, int durata, int volume) {
		super(titolo, durata);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.durata; i++) {
			System.out.println(titolo + "!".repeat(this.volume));
		}

	}

	@Override
	public void weaker(int n) {
		this.volume = reduce(volume, n, "Volume");
	}

	@Override
	public void louder(int n) {
		this.volume = aumento(volume, n, "Volume");

	}

}
