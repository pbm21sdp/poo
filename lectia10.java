/* Sa se implementeze ierarhia de clase descrisa mai jos:
• Clasa Tip: reprezinta un tip de date abstract
– Date membru: nu are
– Metode membru
⇤ public String getTip(): returneaza numele clasei sub forma unui sir de
caractere precedat de sirul ”Tip: ”
⇤ public String toString(): afiseaza valoarea atributului incapsulat de
clasele derivate
Metoda getTip nu are initial nici o implementare.

• Clasa Intreg: reprezinta tipul de date intreg (mosteneste clasa Tip)
– Date membru: un atribut de tip int
– Metode membru
⇤ public String getTip()
⇤ public String toString()

• Clasa Sir: reprezinta tipul de date sir de caractere (mosteneste clasa Tip)
– Date membru: un atribut de tip String
– Metode membru
⇤ public String getTip()
⇤ public String toString() 

• Clasa Colectie: reprezinta tipul de date colectie de obiecte Tip
– Date membru: un atribut ce stocheaza elementele colectiei
– Metode membru
⇤ public String getTip()
⇤ public String toString()
⇤ o metoda care testeaza egalitatea dintre doua colectii din punct de
vedere al continutului elementelor. Doua colectii sunt considerate a fi
egale din punct de vedere al continutului daca ambele contin acelasi
numar de elemente iar elementele continute sunt egale, mai mult, ele
sunt stocate in aceeasi ordine.
⇤ o metoda pentru adaugarea de elemente in colectie
Acest tip de colectie trebuie implementat astfel incat o colectie sa poata contine
elemente de tip Colectie.

Exemple. Presupunem ca avem o colectie formata din urmatoarele elemente:
7, 4, Eu, 12. Apelul metodei toString trebuie sa furnizeze rezultatul (7, 4, Eu,
12).
Presupunem ca avem o colectie formata din urmatoarele elemente: 7, 4, Eu,
12 si colectia formata din elementele 2 si 8. Apelul metodei toString trebuie
sa furnizeze rezultatul (7, 4, Eu, 12, (2, 8)). Metoda toString din aceasta clasa
trebuie sa fie implementata urmarind urmatoarele cerinte
– folosirea operatorului instanceof e STRICT interzisa
– trebuie sa existe o variabila de tip Iterator in interiorul metodei
Se va scrie si o metoda main intr-o alta clasa in care se va crea o colectie de obiecte
Tip ce va avea cel putin un element de tip Colectie, dupa care aceasta se va afisa.
Se va testa si egalitatea elementelor dintre doua colectii.*/

import java.util.*;

abstract class Tip{
    public abstract String getTip();

    public abstract String toString();

    public abstract boolean equals();
}

class Intreg extends Tip{
    private int numar;

    public Intreg(int numar){
        this.numar = numar;
    }

    public String getTip(){
        return "Tip: Intreg";
    }
    
    public String toString(){
        return Integer.toString(numar);
    }

    public boolean equals(Object o){
        if(o.getTip() == this.getTip()){
            return (o.numar == this.numar);
        }
        else{
            return false;
        }
    }
}

class Sir extends Tip{
    private String cuvant;

    public Sir(String cuvant){
        this.cuvant = cuvant;
    }

    public String getTip(){
        return "Tip: String";
    }

    public String toString(){
        return cuvant;
    }

    public boolean equals(Object o){
        if(o.getTip() == this.getTip()){
            return (o.cuvant == this.cuvant);
        }
        else{
            return false;
        }
    }
}

class Colectie extends Tip{
    private ArrayList<Tip> elemente;

    public Colectie(){
        this.elemente = new ArrayList<Tip>();
    }

    public String getTip(){
        return "Tip: Colectie";
    }

    public String toString(){
        String rezultat = "(";

        Iterator<Tip> iterator = elemente.iterator();
        while (iterator.hasNext()) {
            Tip elem = iterator.next();
            rezultat = rezultat + elem.toString();

            if (iterator.hasNext()) {
                rezultat = rezultat + ", ";
            }
        }

        rezultat = rezultat + ")";
        return rezultat;
    }

    public void add(Tip element){
        elemente.add(element);
    }

    public boolean equals(Colectie altaColectie){
        if(altaColectie.getTip() == this.getTip()){
            return (altaColectie.elemente == this.elemente);
        }
        else{
            return false;
        }
    }
}

class Main{
    public static void main(String args[]){
        Intreg intreg = new Intreg(7);
        Sir sir = new Sir("Eu");

        Colectie colectie1 = new Colectie();
        colectie1.add(intreg);
        colectie1.add(new Intreg(4));
        colectie1.add(sir);
        colectie1.add(new Intreg(12));

        Colectie colectie2 = new Colectie();
        colectie2.add(new Intreg(2));
        colectie2.add(new Intreg(8));

        Colectie colectie3 = new Colectie();
        colectie3.add(new Intreg(2));
        colectie3.add(new Intreg(8));

        colectie1.add(colectie2);

        System.out.println("Colectie 1: " + colectie1);
        System.out.println("Colectie 2: " + colectie2);
        System.out.println("Colectie 3: " + colectie3);

        if (colectie1.equals(colectie2)) {
            System.out.println("Colectiile sunt egale.");
        } else {
            System.out.println("Colectiile nu sunt egale.");
        }

        if (colectie2.equals(colectie3)) {
            System.out.println("Colectiile sunt egale.");
        } else {
            System.out.println("Colectiile nu sunt egale.");
        }
    
    }
}