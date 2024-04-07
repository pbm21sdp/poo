class Remorca {
    private int cutii;
    private String nr_inmatriculare;
    private int nr_roti;
    private String tip;
    public static int cut = 10;

    public Remorca(int cutii, String nr_inmat) {
	this.cutii = cutii;
	this.nr_inmatriculare = nr_inmat;
	this.nr_roti = 4;
	this.tip = "normala";
    }

    public Remorca(String nr_in) {
	this.nr_inmatriculare = nr_in;
	this.cutii = cut + 1;
	cut = this.cutii;
    }

    public int getNumarCutii() {
	return this.cutii;
    }

    public String getNumarInmatriculare() {
	return this.nr_inmatriculare;
    }

    public String toString1() {
	return "Remorca " + "Numar cutii: " + this.cutii + " Numar inmatriculare: " + this.nr_inmatriculare + " Numar roti: " + this.nr_roti + " Tip: " + this.tip;
    }

    public String toString() {
	return "R" + "(" + this.nr_inmatriculare + ", " + this.cutii + ")";
    }
    
}

class Tir {
    private Remorca[] t;
    private int numarRemorci;

    public Tir(int nr) {
	t = new Remorca[nr];
	numarRemorci = 0;
    }

    public boolean adaugaRemorca(int cutii, String nr_inm) {
	if(numarRemorci < t.length) {
		t[numarRemorci] = new Remorca(cutii, nr_inm);
		numarRemorci++;
		return true;
	}
	else {
	    return false;
	}
    }

    public boolean adaugaRemorca(Remorca r) {
	if(numarRemorci < t.length) {
	    t[numarRemorci] = r;
	    numarRemorci++;
	    return true;
	}
	else {
	    return false;
	}
    }

        public Remorca stergeRemorca(String numar_inmatriculare) {
	    for(int i  = 0; i < numarRemorci; i++) {
		if(t[i].getNumarInmatriculare() == numar_inmatriculare) {
		    Remorca rStearsa = t[i];
		    for(int j = i; j < numarRemorci - 1; j++) {
			t[j] = t[j+1];
		    }
		    t[numarRemorci - 1] = null;
		    numarRemorci--;
		    return rStearsa;
		}
	    }
	    return null;
	} 
	

    public boolean equals(Object o) {
	if(o instanceof Tir) {
	    int cutiiTir1 = 0;
	    int cutiiTir2 = 0;

	    for(int i = 0; i < numarRemorci; i++) {
		cutiiTir1 = cutiiTir1 + t[i].getNumarCutii();
	    }
	    for(int j = 0; j < ((Tir)o).numarRemorci; j++) {
		cutiiTir2 = cutiiTir2 + ((Tir)o).t[j].getNumarCutii();
	    }
	    return (cutiiTir1 == cutiiTir2);
	}
	else {
	    return false;
	}
}
    
        public String toString() {
	String rezultat = "T -> ";
	for(int i = 0; i < numarRemorci; i++) {
	    rezultat += t[i].toString();
	    if(i < numarRemorci - 1) {
		rezultat += " -> ";
	    }
	}
	return rezultat;
	}
}

class Main {
    public static void main(String args[]) {
	Remorca r1 = new Remorca(12, "NBM");
	Remorca r2 = new Remorca(18, "HEP");
	Remorca r3 = new Remorca("Z");
	String s1 = r1.toString1();
	String s2 = r2.toString1();
	System.out.println(r1);
	System.out.println(r2);
	System.out.println(s1);
	System.out.println(s2);

	Tir tir1 = new Tir(5);
	tir1.adaugaRemorca(15, "BRIANA");
	tir1.adaugaRemorca(18, "B");
	tir1.adaugaRemorca(r3);
	System.out.println(tir1.toString());

	Tir tir2 = new Tir(5);
	tir2.adaugaRemorca(17, "A");
	tir2.adaugaRemorca(19, "C");
	tir2.adaugaRemorca(20, "D");
	System.out.println(tir2.toString());

	Tir tir3 = new Tir(5);
	tir3.adaugaRemorca(15, "X");
	tir3.adaugaRemorca(18, "F");
	System.out.println(tir3.toString());

	System.out.println("Sunt tirurile egale?");
	System.out.println(tir1.equals(tir2));

	System.out.println("Sunt tirurile egale?");
	System.out.println(tir1.equals(tir3));

	Remorca rSt = tir1.stergeRemorca("B");
	if(rSt != null) {
	    System.out.println("Remorca care a fost stearsa este: " + rSt.toString());
	}
	System.out.println(tir1.toString());
	
    }
}

