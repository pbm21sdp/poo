/*
Asupra unei firme se pot efectua urmatoarele operatii:


Apoi se va incerca adaugarea unuia din obiectele angajat deja adaugate inca o data in cadrul firmei. 
Se va afisa firma la iesirea standard si apoi bugetul ramas / lipsa daca se vor plati salariile angajatilor. */



class Angajat{
    private String nume_angajat;
    private int salariu;
    private int vechime;

    public Angajat(String nume, int salar){
        this.nume_angajat = nume;
        this.salariu = salar;
        this.vechime = 5;
    }

    public String toString(){
        return this.nume_angajat + " ~ " + this.salariu;
    }

    public int getSalariu(){
        return this.salariu;
    }

    public String getNumeAngajat(){
        return this.nume_angajat;
    }

    public boolean equals(Object o){
        if(o instanceof Angajat){
            return ((((Angajat)o).getNumeAngajat()) == this.getNumeAngajat());
        }
        else{
            return false;
        }
    }
}

class Firma{
    private String nume_firma;
    private int buget;
    private Angajat[] angajati;
    private int numar_angajati;

    public Firma(String nume, int b){
        this.nume_firma = nume;
        this.buget = b;
        this.angajati = new Angajat[30];
        numar_angajati = 0;
    }

    private boolean existaAngajat(Angajat a1){
        int i;
        for(i = 0; i < numar_angajati; i++){
            if((a1.getNumeAngajat()).equals(angajati[i].getNumeAngajat())){
                return true;
            }
        }
        return false;
    }

    public boolean adaugaAngajat(Angajat a1){
        if((numar_angajati < angajati.length) && !(existaAngajat(a1))){
            angajati[numar_angajati] = a1;
            numar_angajati++;
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String inceput = nume_firma + ": ";
        int i;
        for(i = 0; i < numar_angajati; i++){
            inceput += "Angajat" + i + " " + angajati[i].toString();
            if(i < numar_angajati - 1){
                inceput += " ";
            }
        }
        return inceput;
    }

    public int platesteSalarii(){
        int cheltuieli = 0;
        int i;
        int buget_ramas = 0;
        for(i = 0; i < numar_angajati; i++){
            cheltuieli += angajati[i].getSalariu();
        }
        buget_ramas = this.buget - cheltuieli;
        return buget_ramas;
    }
}

class Main{
    public static void main(String args[]){
        Firma firma1 = new Firma("Briana", 10000);

        Angajat angajat1 = new Angajat("Briana", 1000);
        Angajat angajat2 = new Angajat("Patrick", 1000);
        Angajat angajat3 = new Angajat("Filip", 1000);
        Angajat angajat4 = new Angajat("Filip", 1000);

        firma1.adaugaAngajat(angajat1);
        firma1.adaugaAngajat(angajat2);
        firma1.adaugaAngajat(angajat3);
        firma1.adaugaAngajat(angajat4);

        System.out.println(firma1);

    }
}