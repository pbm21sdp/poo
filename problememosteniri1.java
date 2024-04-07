/* Intr-un program de gestionare a unei firme avem doua clase: Firma si Angajat. 
Un angajat este caracterizat de nume (sir de caractere) si salariu (int). Aceste caracteristici sunt setate prin constructor.
Clasa poate sa contina si alte elemente considerate necesare.
O firma este caracterizata de nume (sir de caractere) si de un buget (int) care sunt setate prin constructor. 
Fiecare firma mai contine un tablou de referinte la obiecte de tip angajat (eventual si un contor daca se considera necesar) 
reprezentand angajatii din cadrul firmei. Numarul maxim de angajati este 30.
Asupra unei firme se pot efectua urmatoarele operatii:
• adaugaAngajat: ce primeste ca parametru o referinta la un obiect angajat. 
Daca mai este loc disponibil in tabloul de angajati si daca acel angajat nu este deja prezent in firma 
(adica exact acel obiect nu este deja prezent in tabloul firmei, angajatul este adaugat in tablou si metoda intoarce true. 
Altfel, adaugarea nu are loc si metoda intoarce false.
• o operatie corespunzatoare care intoarce reprezentarea sub forma de sir de caractere a firmei sub forma 
"Nume firma: Angajat1 Angajat2 .AngajatN" unde Angajat este reprezentarea sub forma de sir de caractere a unui angajat, 
iar N corespunde numarului de angajati aflati deja in firma la momentul respectiv. Un angajat e reprezentat ca sir de caractere sub forma 
"Angajat <numes ~ <salariu>"
• platesteSalarii: ce calculeaza bugetul ce ramane / lipseste daca vor fi platite salarile angajatilor din cadrul firmei.
Se va implementa si o metoda main in care se va crea o firma si se vor adauga 3 angajati. 
Apoi se va incerca adaugarea unuia din obiectele angajat deja adaugate inca o data in cadrul firmei. 
Se va afisa firma la iesirea standard si apoi bugetul ramas / lipsa daca se vor plati salariile angajatilor. 

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

    public boolean adaugaAngajat(Angajat a1){
        if (numar_angajati < angajati.length){
            for (int i = 0; i < numar_angajati; i++){
                if (angajati[i]!= null && (a1.getNumeAngajat()).equals(angajati[i].getNumeAngajat())){
                    return false;
                }
            }
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
            inceput += "Angajat" + (i+1) + " " + angajati[i].toString();
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

        int buget = firma1.platesteSalarii();
        System.out.println("Bugetul ramas este: " + buget);
    }
} */


/* Intr-un program de desenat avem doua clase: Desen si Figura. O figura e caracterizata de o arie(numar real) setata prin constructor.
    Clasa poate sa contina si alte elemente considerate necesare.
    Un desen e caracterizat de un sir de caractere reprezentand titlul desenului si care este setat prin constructor. Fiecare desen
    mai contine un tablou de referinte la obiecte de tip figura (si eventual si un contor daca se considera necesar), reprezentand figurile 
    care exista in desen. Numarul maxim de figuri permise este de 1024. Pe un desen putem efectua urmatoarele operatii:
    adaugaFigura ce primeste ca parametru o referinta la un obiect figura. Daca exact acelasi obiect figura nu este deja prezent in desen
    si daca mai exista loc disponibil in tabloul de figuri al desenului, figura e adaugata la desen si metoda intoarce valoarea true. Altfel,
    adaugarea nu are loc si metoda intoarce valoarea false.
    o operatie corespunzatoare care intoarce reprezentarea sub forma de sir de caractere a desenului sub forma "Titlu desen: Figura1 Figura2.."
    unde Figura este reprezentarea sub forma de sir de caractere a unei figuri, iar N corespunde numarului de figuri aflate deja in desen
    la momentul respectiv. O figura e reprezentata ca sir de caractere sub forma "Figura - Arie: valoarea_ariei".
    medieArie ce returneaza media ariilor tuturor figurilor din desen (0 daca nu exista nici o figura in desen).

    Se va implementa si o metoda main in care se va crea un desen si se vor adauga la el 3 figuri. Apoi se va incerca adaugarea unuia din
    obiectele figura deja adaugate inca o data la desen. Apoi se afiseaza desenul la iesirea standard si se afiseaza media ariilor
    tuturor figurilor din desen.
 

class Figura{
    private double arie;
    
    public Figura(double ar){
        this.arie = ar;
    }

    public double getArie(){
        return this.arie;
    }

    public String toString(){
        return " Arie: " + this.arie;
    }
}

class Desen{
    private String numeDesen;
    private Figura[] figuri;
    private int numarFiguri;

    public Desen(String nume){
        this.numeDesen = nume;
        this.figuri = new Figura[1024];
        numarFiguri = 0;
    }

    public boolean adaugaFigura(Figura fig1) {
        int i;
        if (numarFiguri < figuri.length) {
            for (i = 0; i < numarFiguri; i++) {
                if (figuri[i].getArie() == fig1.getArie()) {
                    return false;
                }
            }
            figuri[numarFiguri] = fig1;
            numarFiguri++;
            return true;
        } 
        else {
            return false;
        }
    }
   
    public String toString(){
        String inceput = this.numeDesen + ": ";
        int i;
        for(i = 0; i < numarFiguri; i++){
            inceput += "Figura" + (i+1) + figuri[i].toString();
            if(i < numarFiguri - 1){
                inceput += " ";
            }
        }
        return inceput;
    }

    public double medieArie(){
        double suma = 0;
        double medie = 0;
        int i;
        for(i = 0; i < numarFiguri; i++){
            suma += figuri[i].getArie();
        }
        medie = suma/numarFiguri;
        return medie;
    }
}

class Main{
    public static void main(String args[]){
        Desen desen1 = new Desen("Briana");
        Figura figura1 = new Figura(123.5);
        Figura figura2 = new Figura(432.5);
        Figura figura3 = new Figura(32.7);
        Figura figura4 = new Figura(32.7);

        desen1.adaugaFigura(figura1);
        desen1.adaugaFigura(figura2);
        desen1.adaugaFigura(figura3);
        desen1.adaugaFigura(figura4);

        System.out.println(desen1);

        double medie = desen1.medieArie();
        System.out.println("Media ariilor este: " + medie);
    }
}
*/

/* Intr-un program de gestiune avem doua clase: Benzinarie si Masina. O Masina e caracterizata de numarul ei de inmatriculare (String)
   si cantitatea de benzina in litri (int) care ii este necesara pentru alimentare. Aceste caracteristici sunt setate prin constructor. 
   Clasa poate sa contina si alte elemente considerate necesare. 
   O Benzinarie e caracterizata de cantitatea de benzina disponibila in litri (int). Fiecare benzinarie mai contine si un tablou de 
   referinte la obiecte Masina (eventual si un contor daca se considera necesar), reprezentand masinile care asteapta la coada pentru
   a fi alimentate. Dimensiunea maxima a cozii este de 10 masini. Pe o benzinarie putem efectua urmatoarele operatii:
   alimenteazaMasina ce primeste ca parametru o referinta la un obiect masina. Daca exista suficienta benzina in benzinarie pentru a 
   alimenta acea masina complet, se actualizeaza corespunzator cantitatea de benzina din benzinarie si metoda intoarce valoarea True. 
   Daca nu exista suficienta benzina in benzinarie pentru a alimenta total acea masina, se incearca amplasarea masinii in tabloul de 
   asteptare. Daca mai este loc, masina e pusa in coada de asteptare iar metoda intoarce valoarea true. Altfel, alimentarea masinii e 
   abandonata iar metoda intoarce valoarea false.
   O operatie corespunzatoare care intoarce reprezentarea sub forma de sir de caractere a benzinariei sub forma "Coada benzinarie: 
   Masina1 Masina2 ... MasinaN", unde MasinaX este reprezentarea sub forma de sir de caractere a masinii ce asteapta la coada pe 
   pozitia X la benzinarie, iar N corespunde numarului de masini ce stau la coada. O masina e reprezentata sub forma "Numar inmatriculare
   - Cantitatea necesara".
   alimenteazaBenzinarie - ce primeste ca parametru o cantitate de combustibil ce e adaugat la cantitatea de benzina curenta din
   benzinarie. Apoi, daca exista masini la coada, metoda alimenteaza masinile in ordinea in care ele stau la coada. Procedura se 
   opreste la prima masina care nu mai poate fi alimentata complet sau cand nu mai sunt masini la coada. Masinile alimentate se elimina
   din coada de asteptare iar cele nealimentate raman la coada.

   Se va implementa si o metoda main unde se va crea o benzinarie si 3 masini cu numere de inmatriculare la alegere si avand un necesar
   de combustibil de 5,10, respectiv 15 litri. Se va apela metoda alimenteazaMasina pe benzinarie avand ca parametru masinile create anterior
   in ordinea indicata a necesarului de combustibil de mai sus. Se tipareste la iesirea standard benzinaria. Apoi se alimenteaza benzinaria
   cu 15 litri de combustibil si apoi se tipareste iar la iesirea standard benzinaria. 
 */

 /* Intr-un program pentru gestiunea finantelor personale avem doua clase: Card si Portofel. Un card e caracterizat de un numar (sir de
    caractere) si un sold(numar real). Aceste caracteristici sunt setate prin constructor. Clasa poate sa contina si alte elemente 
    considerate necesare.
    Un portofel e caracterizat de un sir de caractere reprezentand numele proprietarului care este setat prin constructor. Fiecare 
    portofel mai contine un tablou de referinte la obiecte de tip Card (eventual si un contor daca se considera necesar) reprezentand 
    cardurile care exista in portofel. Numarul maxim de carduri permise este de 6. Pe un portofel putem efectua urmatoarele operatii:
    adaugaCard - ce primeste ca parametru un sir de caractere si o valoare reala reprezentand numarul cardului, respectiv soldul. Daca mai
    exista loc disponibil in tablou si daca un card cu numarul respectiv nu a fost adaugat inainte, se instantiaza o referinta la un obiect
    card folosind datele primite ca parametru si metoda intoarce True. Altfel, adaugarea nu are loc si metoda intoarce valoarea false.
    O operatie corespunzatoare care intoarce reprezentarea sub forma de sir de caractere a portofelului sub forma "Portofel numeProprietar
    : Card1 Card2 ... CardN", unde CardX este reprezentarea sub forma de sir de caractere a unui card, iar N corespunde numarului de 
    carduri aflate in portofel la momentul respectiv. Un card e reprezentat sub forma "Numar - sold".
    calculeazaSold - ce returneaza suma soldurilor tuturor cardurilor din portofel.
    Se va implementa si o metoda main in care se va crea un portofel si se vor adauga la el 4 carduri dintre care unul cu acelasi numar ca 
    a unui card adaugat anterior. Apoi se afiseaza portofelul la iesirea standard si se calculeaza soldul total disponibil pentru
    portofelul respectiv.

    class Card{
        private String numarCard;
        private double sold;

        public Card(String numar, double s){
            this.numarCard = numar;
            this.sold = s;
        }

        public String getNumarCard(){
            return this.numarCard;
        }

        public double getSold(){
            return this.sold;
        }

        public boolean equals(Object o){
            if(o instanceof Card){
                return(((Card)o).getNumarCard() == this.getNumarCard());
            }
            else{
                return false;
            }
        }

        public String toString(){
            return numarCard + " - " + sold;
        }
    }

    class Portofel{
        private String numeProprietar;
        private Card[] carduri;
        private int numarCarduri;

        public Portofel(String nume){
            this.numeProprietar = nume;
            this.carduri = new Card[6];
            this.numarCarduri = 0;
        }

        public boolean adaugaCard(String nume, double sol) {
            if (numarCarduri < carduri.length) {
                for (int i = 0; i < numarCarduri; i++) {
                    if (carduri[i] != null && carduri[i].getNumarCard().equals(nume)) {
                        return false; 
                    }
                }
                carduri[numarCarduri] = new Card(nume, sol);
                numarCarduri++;
                return true;
            }
            return false; 
        }
        

        public String toString(){
            String inceput = "Portofel " + numeProprietar + " ";
            int i;
            for(i = 0; i < numarCarduri; i++) {
                inceput += "Card" + (i+1) + " " + carduri[i].toString();
                if(i < numarCarduri - 1){
                    inceput += " ";
                }
            }
            return inceput;
        }

        public double calculeazaSold(){
            double soldTotal = 0;
            int i;
            for(i = 0; i < numarCarduri; i++){
                soldTotal += carduri[i].getSold();
            }
            return soldTotal;
        }
    }

    class Main{
        public static void main(String args[]){
            Portofel portofel1 = new Portofel("Briana");

            portofel1.adaugaCard("324", 1000);
            portofel1.adaugaCard("675", 2000);
            portofel1.adaugaCard("3848", 3000);
            portofel1.adaugaCard("675", 2000);

            System.out.println(portofel1);

            double sold = portofel1.calculeazaSold();
            System.out.println("Soldul total de pe aceste carduri este: " + sold);
        }
    }
    */

    /*
Asupra unei firme se pot efectua urmatoarele operatii:
• platesteSalarii: ce calculeaza bugetul ce ramane / lipseste daca vor fi platite salarile angajatilor din cadrul firmei.
Se va implementa si o metoda main in care se va crea o firma si se vor adauga 3 angajati. 
Apoi se va incerca adaugarea unuia din obiectele angajat deja adaugate inca o data in cadrul firmei. 
Se va afisa firma la iesirea standard si apoi bugetul ramas / lipsa daca se vor plati salariile angajatilor. */

class Angajat{
    private String numeAngajat;
    private int salariu;

    public Angajat(String nume, int s){
        this.numeAngajat = nume;
        this.salariu = s;
    }

    public String getNume(){
        return this.numeAngajat;
    }

    public int getSalariu(){
        return this.salariu;
    }

    public boolean equals(Object o){
        if(o instanceof Angajat) {
            return (this.numeAngajat == (((Angajat)o).numeAngajat));
        }
        else{
            return false;
        }
    }

    public String toString(){
        return this.numeAngajat + " ~ " + this.salariu;
    }
}

class Firma{
    private String numeFirma;
    private int buget;
    private Angajat[] angajati;
    private int numarAngajati;

    public Firma(String nume, int b){
        this.numeFirma = nume;
        this.buget = b;
        this.angajati = new Angajat[30];
        this.numarAngajati = 0;
    }

    public boolean adaugaAngajat(Angajat a1){
        if (numarAngajati < angajati.length){
            for (int i = 0; i < numarAngajati; i++){
                if (angajati[i]!= null && (a1.getNume()).equals(angajati[i].getNume())){
                    return false;
                }
            }
            angajati[numarAngajati] = a1;
            numarAngajati++;
            return true;
        } 
        else{
            return false;
        }
    }

    public String toString(){
        String inceput = this.numeFirma + ": ";
        int i;
        for(i = 0; i < numarAngajati; i++){
            inceput += "Angajat" + (i+1) + " " + angajati[i].toString();
            if(i < numarAngajati - 1){
                inceput += " ";
            }
        }
        return inceput;
    }

    public int platesteSalarii(){
        int cheltuieli = 0;
        int bugetRamas = 0;
        int i;
        for(i = 0; i < numarAngajati; i++){
            cheltuieli += angajati[i].getSalariu();
        }
        bugetRamas = this.buget - cheltuieli;
        return bugetRamas;
    }
}

class Main{
    public static void main(String args[]){
        Firma firma1 = new Firma("Briana", 10000);

        Angajat angajat1 = new Angajat("Hepp", 1000);
        Angajat angajat2 = new Angajat("Patrick", 1000);
        Angajat angajat3 = new Angajat("Christian", 1000);
        Angajat angajat4 = new Angajat("Adrian", 1000);
        Angajat angajat5 = new Angajat("Loredana-Ramona", 1000);
        Angajat angajat6 = new Angajat("Christian", 1000);

        firma1.adaugaAngajat(angajat1);
        firma1.adaugaAngajat(angajat2);
        firma1.adaugaAngajat(angajat3);
        firma1.adaugaAngajat(angajat4);
        firma1.adaugaAngajat(angajat5);
        firma1.adaugaAngajat(angajat6);

        System.out.println(firma1);

        int bugetRamas = firma1.platesteSalarii();
        System.out.println("Bugetul ramas este de: " + bugetRamas);

    }
}