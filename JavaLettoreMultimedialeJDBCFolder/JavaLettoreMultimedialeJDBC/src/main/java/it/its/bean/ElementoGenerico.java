package it.its.bean;

public class ElementoGenerico {

	public int reduce(int elem, int n, String nome) {
		if(elem>n) {
			elem-= n;
		System.out.println(nome + " diminuito");
		}else {
		System.out.println(nome + " più basso del valore inserito");
		}
		return elem;
	}
	
	public int aumento(int elem, int n, String nome) {
		elem += n;
		System.out.println(nome + " aumentato");
		return elem;
	}
}
