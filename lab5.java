import java.io.*;
import java.util.Random;

class Telefon {
    private String nume_proprietar;
    private String[] nume_apelanti;
    private int numar_apelanti;

    public Telefon(String nume_prop) {
	this.nume_proprietar = nume_prop;
	this.nume_apelanti = new String[100];
	this.numar_apelanti = 0;
    }

    public boolean apeleaza(Telefon telefonApelat) {
	if(numar_apelanti >= 100) {
	    return false;
	}
	telefonApelat.nume_apelanti[telefonApelat.numar_apelanti] = this.nume_proprietar;
	telefonApelat.numar_apelanti++;
	return true;
    }

    public int numarDeApeluri(String nume_pr_cautat) {
	int numarApeluri = 0, i;
	for(i = 0; i < numar_apelanti; i++) {
	    if(nume_apelanti[i] != null && nume_apelanti[i].equals(nume_pr_cautat)) {
		    numarApeluri++;
	    }
	}
	    return numarApeluri;
    }

    public String toString() {
	int i;
	String inceput = "Proprietar: " + this.nume_proprietar;
	if(numar_apelanti > 0) {
	    inceput += " Apelanti: ";
	}
	for(i = 0; i < numar_apelanti; i++) {
	    if(nume_apelanti[i] != null) {
		inceput += nume_apelanti[i].toString();
	    }
	    if(i < numar_apelanti - 1) {
		inceput += ", ";
	    }
	}
	return inceput;
    }
}

class Main {
    public static void main(String args[]) {
	int numar_telefoane = 0, i, numar_apeluri_efectuate = 0, numar_apel = 0;
	String nume_proprietar_cautat;
	
	try {
	    InputStreamReader tast = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(tast);
	    
	    System.out.println("Introduceti numarul de telefoane: ");
	    numar_telefoane = Integer.parseInt(br.readLine());

	    Telefon telefoane[] = new Telefon[numar_telefoane];

	    for(i = 0; i < numar_telefoane; i++) {
		System.out.println("Numele proprietarului pentru telefonul " + (i + 1) + ":");
		String nume_prop = br.readLine();
		telefoane[i] = new Telefon(nume_prop);
	    }

	    System.out.println("Introduceti numarul de apeluri efectuat: ");
	    numar_apeluri_efectuate = Integer.parseInt(br.readLine());

	    Random rand = new Random();

	    for(i = 0; i < numar_apeluri_efectuate; i++) {
		int x = rand.nextInt(numar_telefoane);
		int y;
		do {
		    y = rand.nextInt(numar_telefoane);
		} while(y == x);
		boolean apelReusit = telefoane[x].apeleaza(telefoane[y]);
		if(apelReusit) {
		    System.out.println(telefoane[x].toString());
		}
	    }

	    System.out.println("Introduceti numele proprietarului cautat: ");
	    nume_proprietar_cautat = br.readLine();

	    for(i = 0; i < numar_telefoane; i++) {
		Telefon telefon = telefoane[i];
		numar_apel = telefon.numarDeApeluri(nume_proprietar_cautat);
		System.out.println(telefon.toString() + " Numar de apeluri de la " + nume_proprietar_cautat + ": " +  numar_apel);
	    }
	    
	} catch(IOException e) {
	    System.out.println("Eroare la operatiile de intrare-iesire!");
	    System.exit(1);
	}
    }
}
