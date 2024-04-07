import java.util.*;

/*
class A{
    public String toString(){
	return "A";
    }
}

class B extends A{
    public String toString(){
	return "B";
    }
}

class Main{
    public static void main(String args[]){
	List<A> l1 = new ArrayList<>();

	l1.add(new A());
	l1.add(new B());

	//Metoda 1 de iterare cu for obisnuit

	for(int i = 0; i < l1.size(); i++){
	    System.out.println(l1.get(i));
	}

	//Metoda 2 de iterare cu iterator

	Iterator<A> it = l1.iterator();

	while(it.hasNext()){ //iti zice daca exista un element urmator in lista
	    A o = it.next(); //iti consuma elementul urmator din lista
	    System.out.println(o);
	}

	//Metoda 3 de iterare foreach

	for(A o : l1){
	    System.out.println(o);
	}
    }
}
*/

abstract class Tip{
    public abstract String getTip();

    public abstract String toString();
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
	return numar + "";
    }

    public boolean equals(Object o){
	if(o instanceof Intreg){
	    return (this.numar == ((Intreg)o).numar);
	}
	return false;
    }
}

class Sir extends Tip{
    private String cuvant;

    public Sir(String cuvant){
	this.cuvant = cuvant;
    }

    public String getTip(){
	return "Tip: Sir";
    }

    public String toString(){
	return cuvant;
    }

    public boolean equals(Object o){
	if(o instanceof Sir){
	    return (this.cuvant == ((Sir)o).cuvant);
	}
	return false;
    }
}

class Colectie extends Tip{
    private List<Tip> l1;

    public Colectie(){
	this.l1 = new ArrayList<>();
    }

    public String getTip(){
	return "Tip: Colectie";
    }

    public String toString(){
	String tmp = "(";

	Iterator<Tip> it = l1.iterator();

	while(it.hasNext()){
	    tmp = tmp+ it.next().toString();

	    if(it.hasNext()){
		tmp = tmp + ", ";
	    }
	}
	tmp = tmp + ")";
	return tmp;
    }

    public void add(Tip o){
	l1.add(o);
    }

    public boolean equals(Object o){
	if(o instanceof Colectie){
	    if(this.l1.size() != ((Colectie)o).l1.size()){
		return false;
	    }
	    else{
		Iterator<Tip> it1 = this.l1.iterator();
		Iterator<Tip> it2 = ((Colectie)o).l1.iterator();

		while(it1.hasNext() && it2.hasNext()){
		    Tip elem1 = it1.next();
		    Tip elem2 = it2.next();

		    if(elem1.equals(elem2)){
			return true;
		    }
		    else{
			return false;
		    }
		}
	    }
	}
	return false;
    }
}


class Main{
    public static void main(String[] args){
	Intreg nr1 = new Intreg(7);
	Intreg nr2 = new Intreg(4);
	Intreg nr3 = new Intreg(12);
	Intreg nr4 = new Intreg(2);
	Intreg nr5 = new Intreg(8);

	Sir sir1 = new Sir("Eu");

	Colectie c1 = new Colectie();
	Colectie c2 = new Colectie();
	Colectie c3 = new Colectie();
	Colectie c4 = new Colectie();

	c1.add(nr1);
	c1.add(nr2);
	c1.add(sir1);
	c1.add(nr3);

	c2.add(nr4);
	c2.add(nr5);

	c3.add(nr1);
	c3.add(nr2);
	c3.add(sir1);
	c3.add(nr3);
	c3.add(c2);

	c4.add(nr4);
	c4.add(nr5);

	System.out.println("Colectia 1: " + c1);
	System.out.println("Colectia 2: " + c2);
	System.out.println("Colectia 3; " + c3);
	System.out.println("Colectia 4: " + c4);

	if(c1.equals(c3)){
	    System.out.println("Colectiile " + c1 + " si " + c3 + " sunt egale.");
	}
	else{
	    System.out.println("Colectiile " + c1 + " si " + c3 + " nu sunt egale.");
	}

	if(c2.equals(c4)){
	    System.out.println("Colectiile " + c2 + " si " + c4 + " sunt egale.");
	}
	else{
	    System.out.println("Colectiile " + c2 + " si " + c4 + " nu sunt egale.");
	}
    }
}

 
