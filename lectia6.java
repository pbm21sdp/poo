/* Consideram o colectie de greutati in cadrul careia elementele sunt retinute sub
forma unui tablou. Fiecare greutate are o anumita capacitate care poate fi obtinuta
apeland metoda public int capacitate() pe care o are fiecare greutate. Greutatile
pot fi de urmatoarele tipuri:
• simple, a caror capacitate este setata prin constructor
• duble, adica formate din 2 greutati ce sunt stocate in doua campuri de tip Greutate. Aceste greutati sunt setate 
prin constructor dar pot sa fie modificate pe parcursul existentei obiectelor de acest tip prin intermediul a doua metode 
accesor (public void setGreutate1(Greutate g), public void setGreutate2(Greutate g)). Capacitatea acestui tip de greutate 
e egala cu suma capacitatilor celor doua greutati continute. Capacitatea acestui tip de greutate nu va fi retinuta
intr-un atribut, ci va fi calculata de fiecare data cand unui obiect de acest tip i se va solicita serviciul capacitate().
• multiple, care reprezinta o insiruire de greutati simple, duble, si/sau eventual alte greutati multiple. Cu alte cuvinte, 
o greutate multipla reprezinta o insiruire de greutati. Capacitatea unei greutati de acest tip este egala cu suma
capacitatilor greutatilor componente. Componentele acestui tip de greutate se seteaza prin constructorul clasei, dar se poate alege 
si o alta modalitate de inserare a componentelor. Ca si in cazul clasei descrise anterior, capacitatea acestui tip de greutate nu va 
fi retinuta intr-un atribut, ci va fi calculata de fiecare data cand unui obiect de acest tip i se va solicita serviciul capacitate().
Sistemul mai cuprinde si clasa ColectieGreutati care contine un tablou de greutati (acestea reprezinta continutul efectiv al colectiei).
 Clasa ColectieGreutati va contine urmatoarele metode:
• public void adauga(Greutate g): are rolul de a adauga elemente in tabloul de greutati. Presupunem ca o colectie de greutati are 
o capacitate maxima de greutati care se seteaza prin intermediul constructorului.
• public double medie(): returneaza greutatea medie a colectiei (capacitate/numar
de greutati).
Se cere:
• diagrama UML pentru clasele prezentate mai sus.
• implementarea claselor prezentate in diagrama.
• o metoda main in care se va crea un obiect ColectieGreutati, cateva greutati simple, duble si multiple care vor fi adaugate colectiei 
de greutati. Se va afisa greutatea medie a colectiei. */

abstract class Greutate {
    public abstract int capacitate();
}

class Simple extends Greutate {
    private int capacitate;

    public Simple(int capacitate) {
        this.capacitate = capacitate;
    }

    public int capacitate() {
        return capacitate;
    }
}

class Duble extends Greutate {
    private Greutate greutate1;
    private Greutate greutate2;

    public Duble(Greutate greutate1, Greutate greutate2) {
        this.greutate1 = greutate1;
        this.greutate2 = greutate2;
    }

    public void setGreutate1(Greutate g) {
        this.greutate1 = g;
    }

    public void setGreutate2(Greutate g) {
        this.greutate2 = g;
    }

    public int capacitate() {
        return greutate1.capacitate() + greutate2.capacitate();
    }
}

class Multiple extends Greutate {
    private Greutate[] greutati;

    public Multiple(Greutate[] greutati) {
        this.greutati = greutati;
    }

    public int capacitate() {
        int suma = 0;
        for (int i = 0; i < greutati.length; i++) {
            if (greutati[i] != null) {
                suma += greutati[i].capacitate();
            }
        }
        return suma;
    }
}

class ColectieGreutati {
    private Greutate[] greutati;
    private int numarGreutati;
    private int capacitateMaxima;

    public ColectieGreutati(int capacitateMaxima) {
        this.capacitateMaxima = capacitateMaxima;
        this.greutati = new Greutate[capacitateMaxima];
        this.numarGreutati = 0;
    }

    public void adauga(Greutate g) {
        if (numarGreutati < capacitateMaxima) {
            greutati[numarGreutati++] = g;
        } else {
            System.out.println("Colectia este plina. Nu se poate adauga o noua greutate.");
        }
    }

    public double medie() {
        int suma = 0;
        int numarGreutatiNeNull = 0;

        for (int i = 0; i < numarGreutati; i++) {
            if (greutati[i] != null) {
                suma += greutati[i].capacitate();
                numarGreutatiNeNull++;
            }
        }

        if (numarGreutatiNeNull > 0) {
            return suma / numarGreutatiNeNull;
        } else {
            return 0; 
        }
    }

    public static void main(String[] args) {
        ColectieGreutati colectie = new ColectieGreutati(5);

        Greutate greutate1 = new Simple(10);
        Greutate greutate2 = new Simple(20);
        Greutate greutate3 = new Duble(greutate1, greutate2);
        Greutate greutate4 = new Multiple(new Greutate[]{greutate1, greutate3});

        colectie.adauga(greutate1);
        colectie.adauga(greutate2);
        colectie.adauga(greutate3);
        colectie.adauga(greutate4);

        System.out.println("Greutatea medie a colectiei: " + colectie.medie());
    }
}
