package it.its.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.its.Crud;

public class Logic {
	Scanner sc = new Scanner(System.in);

	public List<String> createElementoMultimediale() {
		List<String> list = new ArrayList<String>();
		System.out.println("Inserisci titolo");
		list.add(sc.next());
		sc.nextLine();
		System.out.println("Inserisci duarata");
		list.add(sc.next());
		sc.nextLine();
		System.out.println("Inserisci volume");
		list.add(sc.next());
		return list;
	}

	public Audio createAudio() {
		List<String> list = createElementoMultimediale();
		return new Audio(list.get(0), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
	}

	public Filmato createFilmato() {
		List<String> list = createElementoMultimediale();
		System.out.println("Inserisci luminosità");
		int luminosità = sc.nextInt();
		sc.nextLine();
		return new Filmato(list.get(0), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)), luminosità);
	}

	public Immagine createImmagine() {
		System.out.println("Inserisci titolo");
		String titolo = sc.next();
		sc.nextLine();
		System.out.println("Inserisci lumonosità");
		int luminosità = sc.nextInt();
		sc.nextLine();
		return new Immagine(titolo, luminosità);
	}

	public Object creazioneElemento(int n) {
		System.out.println("L'elemento multimediale " + (n + 1) + " e' un ? \n1)Filmato \n2)Audio \n3)Immagine");
		int risposta = sc.nextInt();
		switch (risposta) {
		case 1:
			Filmato filmato = createFilmato();
			return filmato;

		case 2:
			Audio audio = createAudio();
			return audio;

		case 3:
			Immagine immagine = createImmagine();
			return immagine;
		}
		return null;
	}

	public List<String> checkList(List<Object> list) {
		List<String> listaItem = new ArrayList<String>();
		for (Object obj : list) {
			if (obj.getClass() == Filmato.class) {
				Filmato filmato = (Filmato) obj;
				listaItem.add("Filmato " + filmato.titolo);
			} else if (obj.getClass() == Audio.class) {
				Audio audio = (Audio) obj;
				listaItem.add("Audio " + audio.titolo);
			} else {
				Immagine immagine = (Immagine) obj;

				listaItem.add("Immagine " + immagine.titolo);
			}
		}
		return listaItem;

	}

	public void firstMenu() {
		System.out.println("Benvenuto al lettore multimediale JDBC!");
		int ciclo = 1;
		do {
			System.out.println("\nSeleziona la tua operazione: "
					+ "\n1) riproduci nuovi elementi \n2) selezionane uno dal database \n3) crea tabelle per il db (effettuabile solo al primo avvio dell'applicazione)"
					+ "\nNOTA: se e' il primo avvio dell'applicazione, creare prima il db e successivamente inserire gli elementi multimediali.");
			int risposta = sc.nextInt();
			switch (risposta) {
			case 1:
				main();
				break;
			case 2:
				System.out.println("\nSTAMPA ELEMENTI PRESENTI NEL DB: \n");
				Crud.readAll();
				System.out.println("\nInserire l'id dell'elemento selezionato");
				int id = sc.nextInt();
				switcMenu(Crud.getById(id));
				break;
			case 3:
				Crud.createTable();
				break;
			}
			System.out.println(
					"\nPer effettuare un altra riproduzione digita qualsiasi numero, per uscire invece digita 0");
			ciclo = sc.nextInt();
		} while (ciclo != 0);

	}

	public void main() {

		System.out.println("Lettore multimediale quanti elementi vuoi riprodurre?");
		List<Object> list = new ArrayList<Object>();
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			list.add(creazioneElemento(i));
		}
		int count = 1;
		do {
			List<String> listItem = checkList(list);
			System.out.println("Seleziona un elemento ");
			for (String a : listItem) {
				System.out.println(listItem.indexOf(a) + ") " + a);

			}
			int risposta = sc.nextInt();
			sc.nextLine();
			switcMenu(list.get(risposta));
			System.out.println(
					"\nPer effettuare un altra riproduzione digita qualsiasi numero, per uscire invece digita 0");
			count = sc.nextInt();
			sc.nextLine();
		} while (count != 0);
	}

	public void switcMenu(Object obj) {
		if (obj.getClass() == Filmato.class) {
			// Switch Menu file filmato
			Filmato filmato = (Filmato) obj;
			int ciclo = 0;
			do {
				System.out.println(
						"\nOperazioni: \n1)aumento volume \n2)abbassamento volume \n3)aumento luminosità \n4)abbassamento luminosità \n5)aggiungi al db \n6)riproduci elemento \n7)esci");
				int risposta = sc.nextInt();
				sc.nextLine();
				switch (risposta) {
				case 1:
					System.out.println("di quanto vuoi aumentare il volume? ");

					filmato.louder(sc.nextInt());
					sc.nextLine();
					break;
				case 2:
					System.out.println("di quanto vuoi abbassare il volume? ");
					filmato.weaker(sc.nextInt());
					sc.nextLine();
					break;
				case 3:
					System.out.println("di quanto vuoi aumentare la luminosità? ");
					filmato.brighter(sc.nextInt());
					sc.nextLine();
					break;
				case 4:
					System.out.println("di quanto vuoi abbassare la luminosità? ");
					filmato.darker(sc.nextInt());
					sc.nextLine();
					break;
				case 5:
					Crud.insertMultimedia(filmato);
					break;
				case 6:
					System.out.println("RIPRODUZIONE ELEMENTO \n");
					filmato.play();
					break;
				case 7:
					System.out.println("Uscita in corso...");
					ciclo = 1;
					break;
				}

			} while (ciclo == 0);

		} else if (obj.getClass() == Audio.class) {
			// Switch menu file audio
			Audio audio = (Audio) obj;
			int ciclo = 0;
			do {
				System.out.println(
						"\nOperazioni: \n1)aumento volume \n2)abbassamento volume \n3)aggiungi al db \n4)riproduci elemento \n5)esci");
				int risposta = sc.nextInt();
				sc.nextLine();
				switch (risposta) {
				case 1:
					System.out.println("di quanto vuoi aumentare il volume? ");
					audio.louder(sc.nextInt());
					sc.nextLine();
					break;
				case 2:
					System.out.println("di quanto vuoi abbassare il volume? ");
					audio.weaker(sc.nextInt());
					sc.nextLine();
					break;
				case 3:
					Crud.insertMultimedia(audio);
					break;
				case 4:
					System.out.println("RIPRODUZIONE ELEMENTO \n");
					audio.play();
					break;
				case 5:
					System.out.println("Uscita in corso...");
					ciclo = 1;
					break;
				}
			} while (ciclo == 0);
		} else {
			// Switch menu file immagine
			Immagine immagine = (Immagine) obj;
			int ciclo = 0;
			do {
				System.out.println(
						"\nOperazioni: \n1)aumento luminosità \n2)abbassamento luminosità  \n2)aggiungi al db \n4)riproduci elemento \n5)esci");
				int risposta = sc.nextInt();
				sc.nextLine();

				switch (risposta) {
				case 1:
					System.out.println("di quanto vuoi aumentare la luminosità? ");
					immagine.brighter(sc.nextInt());
					sc.nextLine();
					break;
				case 2:
					System.out.println("di quanto vuoi abbassare la luminosità? ");
					immagine.darker(sc.nextInt());
					sc.nextLine();
				case 3:
					Crud.insertMultimedia(immagine);
					break;
				case 4:
					System.out.println("RIPRODUZIONE ELEMENTO \n");
					immagine.Show();
					break;
				case 5:
					System.out.println("Uscita in corso...");
					ciclo = 1;
					break;

				}
			} while (ciclo == 0);
		}
	}
}
