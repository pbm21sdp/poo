// LECTIA 1
/* 1. Compilati si lansati in executie programul “Hello World!” dat ca exemplu in Sectiunea 1.2.6 

class PrimulProgram{
    public static void main(String argv[]){
        System.out.println("Acesta este primul meu program Java.");
    }
}
*/

/* 2. Scrieti un program Java care initializeaza doua variablile intregi cu doua valori constante oarecare. In continuare, programul va 
determina variabila ce contine valoarea maxima si va tipari continutul ei pe ecran. 

class Comparare{
    public static void main(String argv[]){
        int a = 25;
        int b = 23;

        if(a > b){
            System.out.println("Variabila cu valoarea mai mare este a, al carei continut este " + a);
        }
        else if(b > a){
            System.out.println("Variabila cu valoarea mai mare este b, al carei continut este " + b);
        }
        else{
            System.out.println("Variabilele au valori egale");
        }
    }
}
*/

/* 3. Scrieti un program Java care afiseaza pe ecran numerele impare si suma numerelor pare cuprinse in intervalul 1-100 inclusiv. 

class PareImpare{
    public static void main(String argv[]){
        int i = 0;
        int suma = 0;

        for(i = 0; i < 101; i++){
            if(i % 2 == 0){
                suma = suma + i;
            }
            else{
                System.out.println(i);
            }
        }

        System.out.println("Suma numerelor pare din intervalul 1-100 inclusiv este " + suma);
    }
}
*/

// LECTIA 2
/* 4. Un sertar este caracterizat de o latime, lungime si inaltime. Un birou are doua sertare si, evident, o latime, lungime si inaltime. 
Creati clasele Sertar si Birou corespunzatoare specificatiilor de mai sus. Creati pentru fiecare clasa constructorul potrivit astfel incat
carateristicile instantelor sa fie setate la crearea acestora.
Clasa Sertar contine o metoda tipareste al carei apel va produce tiparirea pe ecran a sertarului sub forma ”Sertar ” + l + L + H, unde l, 
L, H sunt valorile coresupunzatoare latimii, lungimii si inaltimii sertarului. Clasa Birou contine o metoda tipareste cu ajutorul careia
se vor tipari toate componentele biroului. Creati intr-o metoda main doua sertare, un birou si tipariti componentele biroului 

class Sertar{
    private float latime;
    private float lungime;
    private float inaltime;

    public Sertar(float lat, float lung, float h){
        this.latime = lat;
        this.lungime = lung;
        this.inaltime = h;
    }

    public void tiparesteSertar(){
        System.out.println("Sertar " + this.latime + " " + this.lungime + " " + this.inaltime);
    }
}

class Birou{
    private float latime;
    private float lungime;
    private float inaltime;
    private Sertar s1;
    private Sertar s2;

    public Birou(float lat, float lung, float h, Sertar s1, Sertar s2){
        this.latime = lat;
        this.lungime = lung;
        this.inaltime = h;
        this.s1 = s1;
        this.s2 = s2;
    }

    public void tiparesteBirou(){
        System.out.println("Birou " + this.latime + " " + this.lungime + " " + this.inaltime);
        s1.tiparesteSertar();
        s2.tiparesteSertar();
    }
}

class Main{
    public static void main(String argv[]){
        Sertar s1 = new Sertar(21, 23, 24);
        Sertar s2 = new Sertar(13, 43, 21);

        s1.tiparesteSertar();
        s2.tiparesteSertar();

        Birou b1 = new Birou(32, 43, 53, s1, s2);

        b1.tiparesteBirou();
    }
}
*/

/* 5. Definiti o clasa Complex care modeleaza lucrul cu numere complexe. Membrii acestei
clase sunt:
• doua atribute de tip double pentru partile reala, respectiv imaginara ale numarului complex
• un constructor cu doi parametri de tip double, pentru setarea celor doua parti
ale numarului(reala si imaginara)
• o metoda de calcul a modulului numarului complex. Se precizeaza ca modulul
unui numar complex este egal cu radical din (re*re+img*img) unde re este
partea reala, iar img este partea imaginara. Pentru calculul radicalului se va
folosi metoda statica predefinita Math.sqrt care necesita un parametru de tip
double si returneaza tot un double
• o metoda de afisare pe ecran a valorii numarului complex, sub forma re + i *
im
• o metoda care returneaza suma dintre doua obiecte complexe. Aceasta metoda
are un parametru de tip Complex si returneaza suma dintre obiectul curent
(obiectul care ofera serviciul de adunare) si cel primit ca parametru. Tipul
returnat de aceasta metoda este Complex.
• o metoda care returneaza de cate ori s-au afisat pe ecran numere complexe.
Pe langa clasa Complex se va defini o clasa ClientComplex care va contine intr-o
metoda main exemple de utilizare ale metodelor clasei Complex. 

class Complex{
    private double real;
    private double imaginar;
    private static int aparitii = 0;

    public Complex(double re, double im){
        this.real = re;
        this.imaginar = im;
    }

    public double Modul(){
        double nr = this.real * this.real + this.imaginar * this.imaginar;

        return Math.sqrt(nr);
    }

    public void tipareste(){
        System.out.println(this.real + "+ i * " + this.imaginar);
        aparitii++;
    }

    public Complex adunare(Complex c1){
        double realsuma = this.real + c1.real;
        double imaginarsuma = this.imaginar + c1.imaginar;

        Complex c2 = new Complex(realsuma, imaginarsuma);
        return c2;
    }

    public static void apare(){
        System.out.println("S-au afisat " + aparitii + " numere complexe");
    }
}

class ClientComplex{
    public static void main(String argv[]){
        Complex c1 = new Complex(21, 12);
        Complex c2 = new Complex(32, 23);

        c1.tipareste();
        c2.tipareste();

        Complex suma = c1.adunare(c2);
        suma.tipareste();

        Complex.apare();

        double modul = c1.Modul();
        System.out.println("Modulul numarului complex este " + modul);
    }
}
*/

// LECTIA 3
/* 2. O carte este caracterizata printr-un numar de pagini. Spunem ca doua carti sunt
identice daca acestea au acelasi numar de pagini. Creati clasa Carte si atasati-i o
metoda potrivita pentru compararea a doua carti. Apelati metoda care realizeaza
compararea a doua carti intr-o metoda main.  

class Carte{
    private int numar_pagini;

    public Carte(int nr){
        this.numar_pagini = nr;
    }

    public boolean equals(Object o){
        if(o instanceof Carte){
            return (((Carte)o).numar_pagini == this.numar_pagini);
        }
        else{
            return false;
        }
    }
}

class Main{
    public static void main(String argv[]){
        Carte c1 = new Carte(123);
        Carte c2 = new Carte(321);
        Carte c3 = new Carte(123);

        boolean egalitate1 = c1.equals(c2);
        if(egalitate1){
            System.out.println("Cele doua carti au acelasi numar de pagini.");
        }
        else{
            System.out.println("Cele doua carti au un numar diferit de pagini.");
        }

        boolean egalitate2 = c1.equals(c3);
        if(egalitate2){
            System.out.println("Cele doua carti au acelasi numar de pagini.");
        }
        else{
            System.out.println("Cele doua carti au un numar diferit de pagini.");
        }
    }
}
*/

/* 3. Un patrat este caracterizat de latura sa. Scrieti o clasa Patrat ce are doi constructori,
un constructor fara nici un parametru care seteaza latura patratului ca fiind 10
iar altul care seteaza latura cu o valoare egala cu cea a unui parametru transmis
constructorului. Atasati clasei o metoda potrivita pentru tiparirea unui patrat sub
forma ”Patrat” l ”Aria” a, unde l este valoarea laturii iar a este valoarea ariei
patratului. Creati intr-o metoda main diferite obiecte de tip Patrat si tipariti-le.  

class Patrat{
    private int latura;

    public Patrat(){
        this.latura = 10;
    }

    public Patrat(int l){
        this.latura = l;
    }

    public String toString(){
        return "Patrat " + this.latura + " Aria " + this.latura * this.latura;
    }
}

class Main{
    public static void main(String argv[]){
        Patrat p1 = new Patrat();
        Patrat p2 = new Patrat(20);

        System.out.println(p1);
        System.out.println(p2);
    }
}
*/

/* Creati o clasa Piramida ce are un atribut intreg n. Atasati clasei o metoda potrivita pentru tiparirea unei piramide ca mai jos:
1 1 1 1
2 2 2
3 3
4 --> n
Creati intr-o metoda main diferite obiecte de tip Piramida si tipariti-le.

class Piramida{
    private int n;

    public Piramida(int nr){
        this.n = nr;
    }

    public void tiparestePiramida(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i + 1; j++){
                System.out.print(i + " ");
                if(i == n){
                    System.out.println("-> " + n);
                }
            }
            System.out.println();
        }
    }
}

class Main{
    public static void main(String argv[]){
        Piramida p1 = new Piramida(5);
        p1.tiparestePiramida();

        Piramida p2 = new Piramida(3);
        p2.tiparestePiramida();
    }
}
*/

/* 5. Definiti o clasa Suma cu metodele statice de mai jos:
// returneaza suma dintre a si b
a) public static int suma(int a, int b) ...
//returneaza suma dintre a, b si c
b) public static int suma(int a, int b, int c) ...
// returneaza suma dintre a, b, c si d
c) public static int suma(int a, int b, int c, int d) ...
Implementati metodele astfel incat fiecare metoda sa efectueze o singura adunare.
Apelati-le dintr-o metoda main. 

class Suma{
    public static int suma(int a, int b){
        return a + b;
    }

    public static int suma(int a, int b, int c){
        return suma(a, b) + c;
    }

        public static int suma(int a, int b, int c, int d){
            return suma(a, b, c) + d;
        }
}

class Main{
    public static void main(String argv[]){
        int a = 2;
        int b = 3;
        int c = 4;
        int d = 5;

        int suma1 = Suma.suma(a, b);
        int suma2 = Suma.suma(a, b, c);
        int suma3 = Suma.suma(a, b, c, d);

        System.out.println(suma1);
        System.out.println(suma2);
        System.out.println(suma3);
    }
}
*/

// LECTIA 4
/* 1. Rulati si studiati programul dat ca exemplu in Sectiunea 4.3.3. 

import java.io.*;

class ExempluIO{
    public static void main(String argv[]){
        int n, i, suma, temporar;
        try{
            BufferedReader in_stream_char = new BufferedReader(new InputStreamReader(System.in));
            PrintStream out_stream = new PrintStream(new FileOutputStream("out.txt"));
            System.out.print("Dati numarul de intregi:");
            n = Integer.parseInt(in_stream_char.readLine());
            suma = 0;
            for(i = 1; i <= n; i++){
                System.out.print("Dati numarul " + i + ":");
                temporar = Integer.parseInt(in_stream_char.readLine());
                suma+= temporar;
                out_stream.println(temporar);
            }
            out_stream.println(suma);
            System.out.println("Suma este:" + suma);
            out_stream.close();
        }catch(IOException e){
            System.out.println("Eroare la operatiile de intrare-iesire!");
            System.exit(1);
        }
    }
}
*/

/* 2. Un obiect tir este format dintr-un număr de maxim 5 obiecte remorcă. Un tir memorează 
într-un tablou referințe la obiectele remorcă pe care le conține la un moment dat. Fiecare remorcă 
este caracterizată de un întreg care reprezintă cantitatea de cutii de marfă pe care le poate 
transporta și de un număr de înmatriculare (String). Pentru o remorcă vom avea doi 
constructori. Unul va seta ambele caracteristici așa cum sunt date prin parametrii 
constructorului. Al doilea, primește ca valoare doar numărul de înmatriculare și va seta 
numărul de cutii ce pot fi transportate ca fiind 1 + numărul de cutii a ultimului obiect remorcă 
creat anterior celui curent. Dacă nu s-a mai creat un astfel de obiect până acum, numărul de 
cutii va fi setat pe 10. Evident, o remorcă poate conține și alte elemente de care considerați 
că este nevoie.
Asupra unui tir se pot realiza următoarele operații:
• adaugaRemorca: ce primește ca parametru numărul de cutii de marfă și un număr de 
înmatriculare. Dacă mai există poziții libere în tabloul de remorci, se crează un nou 
obiect remorcă ce este adăugat tirului iar metoda de adăugare întoarce true. Altfel, 
metoda întoarce false.
• adaugaRemorca: ce primește ca parametru o referință la o remorcă pe care o adaugă 
în tabloul de remorci a tirului pe următoarea poziție liberă. Dacă operația nu se poate 
efectua (nu mai este loc) metoda returnează false altfel true.
• stergeRemorca: ce primește ca parametru un număr de înmatriculare pentru o 
remorcă. Dacă în tir există o remorcă cu acel număr de înmatriculare, atunci ea va fi 
înlăturată din tir și metoda întoarce o referință la obiectul remorcă eliminat. Altfel, 
metoda întoarce null.
• o operație ce ne spune dacă două tiruri sunt egale, situație adevărată atunci când două 
tiruri pot transporta în total aceeași cantitate de cutii de marfă.
• o operație ce întoarce reprezentarea obiectului tir sub formă de șir de caractere. Acesta 
va avea forma: “T -> R1 -> … -> Rn” unde Ri sunt reprezentarea sub formă de șir de 
caractere a fiecărei remorci (sub forma “R(nr_inmatriculare, nr_cutii)” conținute de tir.
Se va implementa și o metodă main (într-o clasă separată) în care se vor crea cel puțin două 
tiruri distincte și se va exemplifica funcționarea fiecărei operații cu fiecare comportament 
distinct observabil de către client. 

class Remorca{
    private int numar_cutii;
    private String numar_inmatriculare;
    private static int cut = 10;

    public Remorca(int nr, String inm){
        this.numar_cutii = nr;
        this.numar_inmatriculare = inm;
    }

    public Remorca(String inm){
        this.numar_cutii = this.cut + 1;
        this.numar_inmatriculare = inm;
        cut = this.numar_cutii;
    }

    public boolean equals(Object o){
        if(o instanceof Remorca){
            return(((Remorca)o).numar_inmatriculare == this.numar_inmatriculare);            
        }
        else{
            return false;
        }
    }

    public int getNumarCutii(){
        return this.numar_cutii;
    }

    public String getNrInmatriculare(){
        return this.numar_inmatriculare;
    }
}

class Tir{
    private Remorca remorci[];
    private int numar_remorci;

    public Tir(){
        this.remorci = new Remorca[5];
        this.numar_remorci = 0;
    }

    public boolean adaugaRemorca(int cutii, String nr){
        if(this.numar_remorci < remorci.length){
            remorci[numar_remorci] = new Remorca(cutii, nr);
            numar_remorci++;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adaugaRemorca(Remorca r){
        if(this.numar_remorci < remorci.length){
            remorci[numar_remorci] = r;
            numar_remorci++;
            return true;
        }
        else{
            return false;
        }
    }

    public Remorca stergRemorca(String nr){
        int i = 0;
        int j = 0;

        if(numar_remorci < remorci.length){
            for(i = 0; i < numar_remorci; i++){
                if(remorci[i].equals(nr)){
                    Remorca rStearsa = remorci[i];
		            for(j = i; j < numarRemorci - 1; j++){
			            remorci[j] = remorci[j+1];
		            }
		            remorci[numarRemorci - 1] = null;
		            numarRemorci--;
		            return rStearsa;
                }
            }
            return null;
        }
    }
}

class Main{
    public static void main(String argv[]){

    }
}
*/

// LECTIA 5
/* 2. Fie o clasa Punct care are doua campuri private x si y reprezentand coordonatele sale in plan. Clasa are un singur constructor 
cu doi parametri care permite initializarea coordonatelor unui obiect Punct la crearea sa. Clasa PunctColorat extinde (mosteneste) 
clasa Punct si mai contine un camp c reprezentand codul unei culori. Argumentati daca este sau nu necesara existenta unui constructor 
in clasa PunctColorat pentru ca sa putem crea obiecte PunctColorat si, daca da, dati un exemplu de posibil constructor pentru 
aceasta clasa. 

class Punct{
    private int x;
    private int y;

    public Punct(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getCoordonataX(){
        return this.x;
    }

    public int getCoordonataY(){
        return this.y;
    }

    public String toString(){
        return "Coordonatele in plan sunt (" + this.x + ", " + this.y + ")";
    }
}

class PunctColorat extends Punct{
    private int c;

    public PunctColorat(int x, int y, int c){
        super(x, y);
        this.c = c;
    }

    public String toString(){
        return "Coordonatele in plan sunt (" + this.getCoordonataX() + ", " + this.getCoordonataY() + ") si are culoarea " + this.c;
    }
}

class Main{
    public static void main(String argv[]){
        Punct p1 = new Punct(12, 32);
        PunctColorat p2 = new PunctColorat(32, 12, 123455);

        System.out.println(p1);
        System.out.println(p2);
    }
}
*/

/* Un obiect telefon este caracterizat de numele proprietarului (String) ce se setează la crearea obiectului
respectiv. Un telefon mai conține un tablou (eventual și un contor dacă se consideră necesar ;)) ce 
memorează nume de proprietari de telefoane (String-uri) care au apelat telefonul respectiv. Pentru 
simplitate, acest tablou va conține maxim 100 de elemente.
Cu un telefon se pot realiza următoarele operații: 
• apeleaza: această metodă primește ca parametru o referință la obiectul telefon apelat de 
telefonul curent. În continuare se adaugă numele proprietarului telefonului pe care s-a apelat 
metoda, în lista de nume a telefonului dat ca parametru la aceasta metodă. Dacă nu mai este 
loc în tabloul respectiv, metoda apelare întoarce valoarea false (adică apelul nu a reușit). 
Altfel, metoda întoarce valoarea true.
• numarDeApeluri: această metodă primește ca parametru un String reprezentând numele unui 
proprietar de telefon și întoarce o referintă la un obiect Integer ce conține numărul de apeluri 
efectuate de respectiva persoană la telefonul curent.
• toString: returnează un șir de caractere conținând numele proprietarului și numele tuturor 
persoanelor care au apelat telefonul respectiv.
Pentru exemplificare, creați o clasă separată care conține o metodă main în care:
• Se citește de la intrarea standard un număr întreg. Acest număr reprezintă câte telefoane 
trebuie create. Se vor crea apoi aceste telefoane și se vor memora într-un tablou referințe la 
ele. Numele proprietarilor vor fi citite tot de la intrarea standard.
• Se citește de la intrarea standard un număr A reprezentând un număr de apeluri de efectuat. 
Apoi se generează aleator A perechi de numere întregi (x,y) semnificând faptul ca telefonul x 
din tabloul de mai sus apelează telefonul y din același tablou. Pentru generarea de numere 
aleatoare vezi documentația de aici sau de aici (în al doilea caz trebuind să aveți un import 
java.util.Random; la începutul fișierului).
• Se citește de la intrarea standard un nume de proprietar. Pentru fiecare telefon se va afișa la 
ieșirea standard reprezentarea sa sub formă de șir de caractere și de căte ori persoana cu 
numele dat a apelat acel telefon */
/* 
class Telefon{
    private String nume;
    private String apelanti[];
    private static int numar_apelanti = 0;

    public Telefon(String n){
        this.nume = n;
        this.apelanti = new String[100];
    }
}*/

/* Dorim sa modelam printr-un program Java mai multe feluri de avioane care formeaza flota aeriana a unei tari. Stim ca aceasta tara
 dispune de avioane de calatori si de avioane de lupta. Avioanele de calatori sunt de mai multe feluri, si anume Boeing si Concorde. 
 De asemenea, avioanele de lupta pot fi Mig-uri sau TomCat-uri(F14). Fiecare tip de avion va fi modelat printr-o clasa, iar 
 avioanele propriu-zise vor fi instante ale claselor respective.
 Fiecare avion poate sa execute o anumita gama de operatii si proceduri, dupa cum se specifica in continuare. 
 Astfel, orice avion trebuie sa contina un membru planeID de tip String si o metoda public String getPlaneID() care sa 
 returneze valoarea acestui membru. Mai mult, orice avion trebuie sa contina un membru totalEnginePower de tip intreg 
 si o metoda public int getTotalEnginePower() care sa returneze valoarea acestui membru. Deoarece fiecare avion trebuie sa poata decola, 
 zbura si ateriza, este normal ca pentru fiecare avion sa putem apela metodele public void takeOff(), public void land() si 
 public void fly(). Metoda takeOff() va produce pe ecran textul ”PlaneID Value - Initiating takeoff procedure - Starting engines - 
 Accelerating down the runway - Taking off - Retracting gear - Takeoff complete”. Metoda fly() va produce pe ecran textul ”PlaneID Value -
 Flying”. Metoda land() va produce pe ecran textul ”PlaneID Value - Initiating landing procedure - Enabling airbrakes -
 Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing complete”.
 Avioanele de calatori si numai acestea trebuie sa contina un membru maxPassengers de tip intreg si o metoda public int getMaxPassengers()
 care sa returneze valoarea acestui membru. Avioanele de calatori de tip Concorde sunt supersonice, deci are sens sa apelam pentru 
 un obiect de acest tip metodele public void goSuperSonic() si public void goSubSonic() care vor produce pe ecran ”PlaneID Value - 
 Supersonic mode activated”, respectiv ”PlaneID Value - Supersonic mode deactivated”.
 Avioanele de lupta si numai acestea au posibilitatea de a lansa rachete asupra diferitelor tinte, de aceea pentru orice avion de lupta 
 trebuie sa putem apela metoda public void launchMissile() care va produce pe ecran urmatorul text ”PlaneID Value - Initiating 
 missile launch procedure - Acquiring target - Launching missile - Breaking away - Missile launch complete”. 
 Avioanele Mig ¸si numai acestea au geometrie variabila pentru zbor de mare viteza, respectiv pentru zbor normal. Clasa corespunzatoare 
 trebuie sa contina metodele public void highSpeedGeometry() si public void normalGeometry() care vor produce pe ecran ”PlaneID Value - 
 High speed geometry selected”, respectiv ”PlaneID Value - Normal geometry selected”. Avioanele TomCat si numai acestea au posibilitatea 
 de realimentare in zbor, deci pentru astfel de avioane are sens sa apelam o metoda public void refuel() care va produce pe ecran
 ”PlaneID Value - Initiating refueling procedure - Locating refueller - Catching up - Refueling - Refueling complete”.
 Se cere:
 • Implementati corespunzator clasele diferitelor feluri de avioane. Din cerinte rezulta ca o parte din functionalitate/date este 
 comuna tuturor sau mai multor feluri de avioane, in timp ce o alta parte este specifica doar avioanelor de un anumit tip. Prin urmare, 
 partile comune vor trebui factorizate facand uz de mostenirea de clasa.
 • Intr-o metoda main, declarati mai multe variabile referinta. Obligatoriu, toate variabilele vor avea acelasi tip declarat. 
 Creati apoi mai multe avioane (cel putin unul de fiecare fel). Pentru a referi aceste obiecte folositi doar variabilele
 amintite anterior bazandu-va pe mostenirea de tip. In continuare apelati diferitele operatii disponibile fiecarui avion/fel de avion.
 • Desenati diagrama UML de clase pentru ierarhia de clase obtinuta. */

 // LECTIA 10
/* 1. Biblioteca
Folosind clasa ArrayList creati o clasa Biblioteca ce poate stoca un numar nelimitat de obiecte de tip Carte. O carte are doua atribute 
ce stocheaza titlul precum si autorul cartii iar afisarea acesteia pe ecran va furniza utilizatorului valorile atributelor mentionate.
Clasa Biblioteca ofera doar doua servicii, unul pentru adaugarea de elemente de tip Carte si altul pentru afisarea elementelor continute. 
Se cere implementarea claselor mentionate precum si crearea intr-o metoda main a unei biblioteci ce are trei carti.
Cartile ce exista in biblioteca vor fi tiparite. 

import java.util.*;

class Carte{
    private String titlu;
    private String autor;

    public Carte(String t, String a){
        this.titlu = t;
        this.autor = a;
    }

    public String toString(){
        return this.titlu + " de " + this.autor;
    }
}

class Biblioteca{
    private ArrayList<Carte> carti;

    public Biblioteca(){
        this.carti = new ArrayList<Carte>();
    }

    public void add(Carte c){
        this.carti.add(c);
    }

    public String toString(){
        return carti.toString();
    }
}

class Main{
    public static void main(String argv[]){
        Carte c1 = new Carte("Mara", "Ioan Slavici");
        Carte c2 = new Carte("Harry Potter", "J.K.Rowling");
        Carte c3 = new Carte("Hercule Poirot", "Agatha Christie");

        Biblioteca b1 = new Biblioteca();

        b1.add(c1);
        b1.add(c2);
        b1.add(c3);

        System.out.println(b1);
    }
}
*/

/* 2. Interfata Intrare contine:
• o metoda denumita continut, fara argumente si care returneaza o referinta String.
Clasa Fisier implementeaza interfata Intrare si contine: 
• un atribut de tip String denumit informatie, specific fiecarui obiect Fisier in parte.
• un constructor ce permite setarea atributului anterior cu o valoare String data ca
parametru constructorului.
• implementarea metodei continut intoarce valoarea atributului informatie descris
mai sus.
Clasa Director implementeaza interfata Intrare si contine:
• un atribut denumit intrari de tip ArrayList<Intrare>. Campul este specific fiecarei
instante a acestei clase si se va initializa cu un obiect lista gol.
• o metoda adauga cu un singur parametru; acesta trebuie sa fie declarat in asa fel
incat sa poata referi atat obiecte a clasei Director, cat si obiecte a clasei Fisier
dar sa NU poata referi orice fel de obiect Java (spre exemplu, NU va putea
referi un obiect String). Metoda introduce in lista anterioara referinta primita ca
parametru.
• obligatoriu in implementarea metodei continut se parcurge lista intrari si se apeleaza metoda continut pe fiecare referinta din lista 
concatenandu-se String-urile intoarse de aceste apeluri; metoda va returna o referinta spre String-ul rezultat in urma concatenarii.
In toata aceasta ultima clasa, obiectele Fisier si obiectele Director din lista trebuie sa fie tratate uniform.

import java.util.*;

interface Intrare{
    String continut();
}

class Fisier implements Intrare{
    private String informatie;

    public Fisier(String info){
        this.informatie = info;
    }

    public String continut(){
        return this.informatie;
    }
}

class Director implements Intrare{
    private ArrayList<Intrare> intrari = new ArrayList<Intrare>();

    public void add(Intrare i){
        this.intrari.add(i);
    }

    public String continut(){
        String rezultat = "";

        Iterator<Intrare> it = intrari.iterator();
        while(it.hasNext()){
            Intrare i = it.next();
            if(it.hasNext()){
                rezultat = rezultat + i.continut() + " ";
            }
            else{
                rezultat = rezultat + i.continut();
            }
        }
        return rezultat;
    }
}

class Main{
    public static void main(String argv[]){
        Fisier f1 = new Fisier("A");
        Fisier f2 = new Fisier("B");
        Fisier f3 = new Fisier("C");
        Fisier f4 = new Fisier("D");

        Director d1 = new Director();
        Director d2 = new Director();

        d1.add(f1);
        d1.add(f2);

        d2.add(d1);
        d2.add(f3);
        d2.add(f4);

        System.out.println(d1.continut());
        System.out.println(d2.continut());
    }
}
*/

/* 3. Sa se implementeze ierarhia de clase descrisa mai jos:
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
Se va testa si egalitatea elementelor dintre doua colectii. 

import java.util.*;

abstract class Tip{
    public abstract String getTip();

    public abstract String toString();
}

class Intreg extends Tip{
    private int informatie;

    public Intreg(int info){
        this.informatie = info;
    }

    public String getTip(){
        return "Tip: Intreg";
    }

    public String toString(){
        return this.informatie + "";
    }

    public boolean equals(Object o){
        if(o instanceof Intreg){
            return (this.informatie == ((Intreg)o).informatie);
        }
        else{
            return false;
        }
    }
}

class Sir extends Tip{
    private String informatie;

    public Sir(String info){
        this.informatie = info;
    }

    public String getTip(){
        return "Tip: Sir";
    }

    public String toString(){
        return this.informatie;
    }

    public boolean equals(Object o){
        if(o instanceof Sir){
            return ((this.informatie).equals(((Sir)o).informatie));
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
        Iterator<Tip> it = this.elemente.iterator();

        while(it.hasNext()){
            Tip element = it.next();
            if(it.hasNext()){
                rezultat = rezultat + element.toString() + ", ";
            }
            else{
                rezultat = rezultat + element.toString();
            }
        }

        rezultat = rezultat + ")";
        return rezultat;
    }

    public void add(Tip element){
        this.elemente.add(element);
    }

    public boolean equals(Object o){
        if(o instanceof Colectie){
            if(this.elemente.size() != ((Colectie)o).elemente.size()){
                return false;
            }
            else{
                Iterator<Tip> i1 = this.elemente.iterator();
                Iterator<Tip> i2 = ((Colectie)o).elemente.iterator();

                while(i1.hasNext() && i2.hasNext()){
                    Tip element1 = i1.next();
                    Tip element2 = i2.next();

                    if(element1.equals(element2)){
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
*/

// PROBLEME TEST
/* 1. Intr-un program de executie de sarcini exista mai multe feluri de task-uri. Toate sunt caracterizate de o metoda denumita execute 
 ce primeste ca parametru un double reprezentand numarul de secunde cat timp se va executa task-ul si intoarce true / false daca task-ul a 
 fost terminat respectiv nu in urma apelului la metoda execute. Task-urile concrete au urmatoarele caracteristici:
 SimpleTask: caracterizat de un nume (String) si un timp necesar / ramas pentru a fi terminat integral (double). Aceste proprietati 
 sunt setate la crearea obiectului. La executia unui astfel de task, daca task-ul nu a fost inca terminat complet se decrementeaza 
 timpul ramas cu valoarea primita ca parametru de metoda execute. Task-ul simplu e terminat integral cand timpul ramas este mai mic sau 
 egal cu 0. Un task simplu e caracterizat si de o metoda adecvata ce intoarce reprezentarea sub forma de sir de caractere a sa sub 
 forma "Name: nume_task, Time: valoare_timp_ramas".
 ComposedTask: caracterizat de un nume (String) si o secventa de oricate elemente de tip simple task. Aceste proprietati sunt 
 setate la crearea obiectului. La executia unui astfel de task, se executa fiecare din task-urile simple continute un numar de 
 secunde obtinut prin impartirea parametrului metodei execute la numarul de task-uri simple continute (pt. simplitate se presupune 
 ca exista tot timpul task-uri simple). Un task compus se considera indeplinit integral cand toate task-urile simple continute 
 sunt indeplinite integral. Un task compus e caracterizat si de o metoda adecvata ce intoarce reprezentarea sub forma sir de caractere 
 a sa sub forma "Name: nume_task, Content: (Simple_Task1 ... SimpleTaskN)", unde Simple_TaskX este reprezentarea sub forma de sir de 
 caractere a task-ului X continut de task-ul compus, iar N e numarul de task-uri simple continute de task-ul compus.
 Sistemul mai contine clasa Procesor ce contine o secventa de oricate task-uri de orice fel si in orice combinatie. Secventa e setata 
 la crearea unui obiect procesor. Un astfel de obiect e caracterizat de metoda finishAllTasks care executa fiecare task continut timp 
 de 5 secunde. Daca nu s-au terminat toate task-urile continute procedura se repeta pana cand toate task-urile sunt terminate. Un 
 procesor e caracterizat si de o metoda adecvata ce intoarce reprezentarea sun forma de sir de caractere a procesorului sub forma 
 "Procesor: Task1; ... TaskN;", unde TaskX este reprezentarea sub forma de sir de caractere a task-ului X continut de procesor, iar 
 N e numarul de task-uri continute.
 Intr-o metoda main se va crea un procesor ce contine un task compus care la randul sau contine 2 task-uri simple cu timp de executie 
 necesar de 5, respectiv de 10 secunde. Se tipareste la iesirea standard procesorul, apoi se apeleaza metoda finishAllTasks si apoi 
 se reafiseaza la iesirea standard procesorul. 
 

 import java.util.*;

abstract class Task{
    public abstract boolean execute(double nr);
}

class SimpleTask extends Task{
    private String nume;
    private double timp;

    public SimpleTask(String nume, double timp){
        this.nume = nume;
        this.timp = timp;
    }

    public boolean execute(double nr){
        if (this.timp > 0){
            this.timp = this.timp - nr;
            return this.timp <= 0; 
        } else{
            return true;
        }
    }

    public String toString(){
        return "Name: " + this.nume + " Time: " + this.timp;
    }
}

class ComposedTask extends Task{
    private String nume;
    private ArrayList<SimpleTask> tasks;
    private int numarTasks;

    public ComposedTask(String nume){
        this.nume = nume;
        this.tasks = new ArrayList<SimpleTask>();
        this.numarTasks = 0;
    }

    public void add(SimpleTask s1){
        this.tasks.add(s1);
        numarTasks++;
    }

    public boolean execute(double nr){
        double nr_secunde = nr / this.numarTasks;
        boolean decizie = true; 
        Iterator<SimpleTask> it1 = this.tasks.iterator();

        while (it1.hasNext()){
            SimpleTask simp = it1.next();
            decizie = decizie && simp.execute(nr_secunde); 
        }

        return decizie;
    }

    public String toString(){
        String rezultat = "Name: " + this.nume + ", Content: (";
        Iterator<SimpleTask> it = this.tasks.iterator();

        while (it.hasNext()){
            SimpleTask smp = it.next();
            if (it.hasNext()){
                rezultat = rezultat + smp.toString() + ", ";
            }else{
                rezultat = rezultat + smp.toString();
            }
        }

        rezultat = rezultat + ")";
        return rezultat;
    }
}

class Procesor{
    private ArrayList<Task> sarcini;

    public Procesor(){
        this.sarcini = new ArrayList<Task>();
    }

    public void add(Task s1){
        this.sarcini.add(s1);
    }

    public String toString(){
        String rezultat = "Procesor: ";
        Iterator<Task> i1 = this.sarcini.iterator();

        while (i1.hasNext()){
            Task tsk = i1.next();
            rezultat = rezultat + tsk.toString() + "; ";
        }
        return rezultat;
    }

    public void finishAllTasks(){
        int verificare = 0;
        boolean reusit = false;

        do{
            Iterator<Task> i2 = this.sarcini.iterator();
            verificare = 0;

            while (i2.hasNext()){
                Task t1 = i2.next();
                reusit = t1.execute(5);

                if (reusit == false){
                    verificare++;
                }
            }
        }while(verificare > 0);
    }
}

class Main{
    public static void main(String argv[]){
        SimpleTask st1 = new SimpleTask("A", 5);
        SimpleTask st2 = new SimpleTask("B", 10);

        ComposedTask ct1 = new ComposedTask("C");

        ct1.add(st1);
        ct1.add(st2);

        Procesor p1 = new Procesor();

        p1.add(ct1);

        System.out.println(p1);

        p1.finishAllTasks();

        System.out.println(p1);
    }
}
 */

 /* 2. In acest program se gestioneaza un sistem de transport pe apa a autovehiculelor, existand mai multe tipuri de autovehicule ce se 
 pot transporta. Toate sunt caracterizate de o metoda denumita calculeazaGreutateTotala ce returneaza un double reprezentand greutatea 
 autovehiculului la care se adauga greutatea transportata de acesta. Autovehiculele concrete sunt: Autoturism si Camion.
 Autoturism: caracterizat de un numar de inmatriculare (String), de greutatea autovehiculului (double) si de greutatea pasagerilor 
 (double). Caracteristicile se seteaza la crearea unui astfel de obiect. Pentru acest tip de autovehicul, metoda 
 calculeazaGreutateTotala returneaza suma dintre greutatea autovehiculului si greutatea pasagerilor. Obiectul mai pune la dispozitie 
 o metoda adecvata pentru reprezentarea sub forma de sir de caractere a autoturismului: "Numar inmatriculare: nr_inmatriculare, 
 Greutate autovehicul: greutate_autovehicul, Greutate pasageri: greutate_pasageri".
 Camion: caracterizat de numar de inmatriculare (String) si de greutatea autovehiculului (double), ce sunt setate la crearea obiectului. 
 Camionul poate transporta autoturisme, prin urmare contine o secventa de oricate autoturisme. Autoturismele sunt adaugate folosind 
 metoda adaugaAutoturism. Metoda calculeazaGreutateTotala returneaza suma dintre greutatea autovehiculului si greutatea totala a 
 autoturismelor ce sunt transportate de camion. Obiectul mai pune la dispozitie o metoda adecvata pentru reprezentarea sub forma 
 de sir de caractere a camionului: "Numar inmatriculare: nr_inmatriculare, Greutate autovehicul: greutate_autovehciul, 
 (Autoturism1, ... AutoturismN), unde AutoturismX e reprezentarea ca sir de caractere a Autoturismului cu numarul X continut de camion, 
 iar N este numarul total de autoturisme transportate de camion.
 Sistemul mai contine o clasa Bac ce este folosita pentru transportul autovehiculelor pe apa, fiind caracterizat de o greutate maxima 
 autorizata pe care o poate transporta, setata la crearea obicetului. Bacul mai contine si o secventa de oricate Autovehicule de 
 orice fel. Autovehiculele sunt adaugate bacului printr-o metoda denumita adaugaAutovehciul ce primeste ca parametru autovehiculul 
 ce se doreste a fi transportat. Adaugarea se face numai si numai daca, prin adaugarea autovehiculului, nu se depaseste greutatea 
 maxima pe care o poate transporta bacul. Daca autovehiculul nu poate sa fie adaugat, metoda intoarce false, in caz contrar metoda 
 intoarce true. Un bac mai pune la dispozitie o metoda adecvata pentru reprezentarea sa sub forma de sir de caractere: "Greutate maxima:
 greutate_maxima, (Autovehicul1, ... AutovehiculN)", unde AutovehiculX este reprezentarea ca sir de caractere a Autovehiculului cu 
 numarul X continut de bac, iar N este numarul total de autovehicule transportate de bac.
 Se va scrie si o metoda main in care se vor crea 3 autoturisme, Autoturism1 cu greutatea autovehiculului de 4 si greutatea 
 pasagerilor 0,3 tone. Autoturism2 cu greutatea autovehiculului de 5 si greutatea pasagerilor 0,25 tone si Autoturism3 cu greutatea 
 autovehiculului de 4,5 si greutatea pasagerilor 0,15 tone. Se va crea un Camion cu greutatea autovehiculului de 10 tone, ce va contine 
 Autoturism1 si Autoturism2. Se va mai crea si un obiect Bac cu greutatea maxima de 20 de tone, la care se va incerca adaugarea 
 Camionului si Autoturism3. Se tipareste la iesirea standard bacul.

 3. Sa se implementeze o aplicatie de gestionare a diferitelor bauturi de tip whiskey. Fiecare instanta va oferi metodele getNrCalorii, 
 ce primeste ca parametru un double reprezentand un numar de mililitri de bautura si intoarce nr de calorii aferent (double), 
 getConcentratieAlcool si o metoda adecvata pentru reprezentarea obiectului sub forma de sir de caractere. Exista mai multe feluri 
 concrete de bauturi tip whiskey.
 ClassicWhiskey: acesta va fi caracterizat de un nume (String) si de o concentratie de alcool (double), ambele setate la crearea unui 
 obiect de acest fel. Pentru whiskey-ul clasic, numarul de calorii se va calcula ca fiind concentratie_alcool * 
 numar_mililitrii_consumati * 5. Reprezentarea sub forma de sir de caractere va avea forma "Nume_whiskey, Concentratie_alcool: 
 concentratia%, Calorii pe 100 ml: numar_calorii kcal". 
 JackAndHoney: va fi caracterizat printr-un nume (String), concentratia de alcool (double), si cantitatea de indulcitor (int), 
 toate setate la crearea obiectului. Numarul de calorii se va calcula ca fiind concentratia_alcool * numar_mililitrii_consumati * 5 
 + cantitate_indulctior * numar_mililitrii_consumati * 15. Reprezentarea sa sub forma de sir de caractere va fi de forma: "Nume_whiskey, 
 Concentratie alcool: concentratia%, Calorii pe 100 ml: numar_calorii kcal, Cantitate indulcitor: cantitate_indulcitor g.
 BlendedWhiskey: va fi caracterizat printr-un nume (String) si printr-o secventa de oricate feluri de whiskey-uri din care este compusa 
 bautura (pot fi de oricare ClassicWhiskey, JackAndHoney si chiar si alte bauturi BlendedWhiskey). Aceasta clasa va dispune de o metoda 
 de adaugare de bauturi in secventa amintita anterior. Concentratia de alcool va fi media aritmetica a tuturor concentratiilor din 
 amestec, iar numarul de calorii va fi suma numarului de calorii a fiecarei bauturi componente, considerand ca se va consuma din 
 fiecare numar_mililitrii_consumati primit ca parametru impartit la numarul de componente al amestecului. Reprezentarea sa sub forma de 
 sir de caractere va avea forma "Nume_whiskey, Concentratie alcool: concentratia%, Calorii pe 100 ml: numar_calorii kcal, Compozitie: 
 Whiskey1, ... WhiskeyN", unde WhiskeyX este reprezentarea sub forma de sir de caractere a obiectului whiskey de pe pozitia X din 
 secventa de bauturi.
 Se va scrie si o metoda main care va instantia un obiect ClassicWhiskey si un obiect JackAndHoney, un obiect BlendedWhiskey ce contine 
 alte doua obiecte ClassicWhiskey si un obiect BlendedWhiskey ce contine primele 3 obiecte mentionate. Pe urma se va printa la iesirea 
 standard ultimul obiect BlendedWhiskey creat si numarul de calorii pentru un consum de 150 de mililitrii din acest fel de bautura.

 4. Intr-un sistem care modeleaza o platforma de tip Twitch avem doua tipuri de utilizatori: subscriberi si creatori. Ambii au o 
 metoda calculeazaVenit ce primeste ca parametru un numar intreg (reprezentand numarul de minute vizionate) si intoarce un numar 
 real reprezentand venitul rezultat in urma vizionarii. Obiectele corespunzatoare utilizatorilor au urmatoarele particularitati:
Subscriber: este caracterizat de un nume (sir de caractere) si un nivel al subscriptiei (numar intreg), ambele setate la crearea 
obiectului. Servicile puse la dispozitie sunt:
• calculeazaVenit - care primeste ca parametru un numar intreg (corespunzator minutelor) si returneaza un numar real obtinut prin 
inmultirea acestuia cu 1.5 * atributul corespunzator nivelului
• un serviciu corespunzator care returneaza reprezentarea sub forma de sir de caractere a subscriber-ului in urmatorul format: 
nume - subscriber - nivel
Creator: este caracterizat de un nume (sir de caractere) setat la crearea obiectului si o seventa nelimitata de subscriberi. 
Serviciile puse la dispozitie sunt:
• adaugaSubscriber - care primeste ca parametru un obiect de tip Subscriber si il adauga in secvența
• calculeazaVenit - care primeste ca parametru un numar intreg (corespunzator minutelor) si returneaza un numar real obtinut prin 
insumarea rezultatelor apelurilor metodei calculeazaVenit pe fiecare subscriber din seventa cu numarul intreg ca si parametru
• un serviciu corespunzator care returneaza reprezentarea sub forma de sir de caractere a creator-ului in urmatorul format: nume 
- creator - reprezentarea sub forma de sir de caractere a fiecarui subscriber din seventa
Sistemul mai furnizeaza si obiecte Platforma a caror clasa contine:
• un atribut referinta la un tablou de utilizatori de orice fel corespunzator utilizatorilor sistemului; un sistem poate contine 
maximum 1000 de utilizatori
• o metoda numita adaugaUtilizator care primeste ca parametru un utilizator si il adauga in tablou (daca mai este loc) si intoarce 
true in caz de adaugare altfel false.
• o metoda numita determinaVIP care primeste ca parametru un numar intreg reprezentand minutele si intoarce o referinta la utilizatorul 
cu cel mai mare venit pentru numarul de minute dat (daca nu exista niciun utilizator se returnează null; daca se găsesc mai multe vip-uri 
se returneaza unul din ele).
Sa se implementeze clasele descrise si sa se demonstreze functionarea lor prin crearea unei platforme cu 2 creatori (cu 2, respectiv 
3 subscriberi) si 1 subscriber. Se va afisa apoi pe ecran utilizatorul cu cel mai mare venit pentru un timp de 30 de minute. */

/* 
5. Se doreste gestionarea diferitelor teste software de catre o aplicatie java. Exista mai multe tipuri de teste pe care dorim sa le 
modelam: teste de integrare, teste de componente si suite de teste. Toate sunt caracterizate de o operatie getNumarTeste care intoarce 
un int indicand numarul de teste reprezentate de obiect. Detaliile pentru diferitele feluri de teste sunt prezentate in cele ce urmeaza.
Integration Test: acesta va fi caracterizat de un nume (String) si de un indicator de calitate (int), acesta fiind un numar de la 1 la 
10. Ambele atribute vor fi setate la crearea obiectului. Daca indicatorul de calitate primit la creare nu este in intervalul [1, 10] 
atunci se va arunca o exceptie neverificata WrongQualityindicatorException. Numarul de teste reprezentate de un astfel de obiect este 1. 
Clasa va mai contine o metoda adecvata pentru reprezentarea ca sir de caractere a unui astfel de test sub forma:
*IntegrationTest(name=(name], quality indicator=[calitate])*.
ComponentTest: acesta va fi caracterizat de un nume (String), un indicator de calitate al testului (int), acesta find un numar de la 1 
la 10 si un numar natural nenul (int) care va reprezenta complexitatea componentei testate. Daca indicatorul de calitate nu face parte 
din intervalul [1, 10), se va arunca exceptie neverificata WrongQualityIndicatorException. Daca valoarea primita ca parametru care 
reprezinta complexitatea componentei testate nu este un numar natural nenul, se va arunca o exceptie verificata 
WrongComponentComplexityIndicatorException. Numarul de teste reprezentate de un astfel de obiect este 1. Clasa va mai contine o metoda 
adecvata pentru reprezentarea ca sir de caractere a unui astfel de test sub forma: "ComponentTest(name=[nume], quality indicator
=(calitate), component complexity indicator=[complexitate)*
TestSuite: aceasta e caracterizat de o seventa de oricate teste de orice fel (de integrare, de componenta sau alte suite),
secvența setata la crearea unui suite.
Numarul de teste reprezentate de o suita e dat de numarul de teste din aceasta secventa. Suita va mai contine metoda de forma: boolean
addNewIntegrationTest(String name, int indicator) care va incerca sa creeze un test de integrare si, in caz de succes, il va adauga 
in seventa de teste, returnand true, iar in caz contrar, va returna false.
De asemenea, o suita va mai contine o metoda de forma: boolean addNewComponentTest(String name, int indicator, int complexity) care 
va incerca sa creeze un test de componenta. In caz de reusita testul e adaugat la seventa de teste a suitei si metoda intoarce true. 
In caz de esec cauzat de o exceptie WrongQualityIndicatorException, metoda intoarce false, iar in caz de esec cauzat de exceptia 
WrongComponentComplexityIndicatorException, metoda propaga exceptia apelatului. In fine, clasa va mai contine o metoda adecvata 
pentru reprezentarea ca sir de caractere a unei suite de teste sub forma TestSuite (Test1 … Test ... TestN), unde Test este 
reprezentarea sub forma de sir de caractere a testului X din seventa de teste a suitei.
Sa se scrie si o clasa Main cu o metoda main in care se va crea o sulta de teste si se vor adauga in aceasta diferite teste de 
integrare (2) si de componenta (2) folosind metodele de adaugare descrise (adica addNewintegrationTest si addNewComponentTest).
In caz de aparitia exceptiei WrongComponentComplexityndicatorException, aceasta se va trata scriind la iesirea standard 
"a aparut o exceptie". 
*/

import java.util.*;

class WrongQualityIndicatorException extends RuntimeException{
    public WrongQualityIndicatorException(String mesaj){
        super(mesaj);
    }
}

class WrongComponentComplexityIndicatorException extends Exception{
    public WrongComponentComplexityIndicatorException(String mesaj){
        super(mesaj);
    }
};

abstract class Test{
    protected String nume;

    public Test(String nume){
        this.nume = nume;
    }

    public abstract int getNumarTeste();

    public abstract String toString();
}

class IntegrationTest extends Test{
    private String nume;
    private int indicator_calitate;

    public IntegrationTest(String nume, int ind){
        super(nume);
        this.indicator_calitate = ind;

        if(ind < 1 || ind > 10){
            throw new WrongQualityIndicatorException("Numarul introdus nu se afla in interval.");
        }
    }

    public int getNumarTeste(){
        return 1;
    }

    public String toString(){
        return "IntegrationTest(name=[" + this.nume + "], quality indicator=[" + this.indicator_calitate + "])";
    }
}

class ComponentTest extends Test{
    private String nume;
    private int indicator_calitate;
    private int complexitate;

    public ComponentTest(String nume, int ind, int co) throws WrongComponentComplexityIndicatorException{
        super(nume);
        this.indicator_calitate = ind;
        this.complexitate = co;

        if(ind < 1 || ind > 10){
            throw new WrongQualityIndicatorException("Indicatorul de calitate nu se afla in intervalul corespunzator.");
        }

        if(co <= 0){
            throw new WrongComponentComplexityIndicatorException("Nu ati introdus un numar natural nenul.");
        }
    }

    public int getNumarTeste(){
        return 1;
    }

    public String toString(){
        return "ComponentTest(name=[" + this.nume + "], quality indicator=[" + this.indicator_calitate + "], component complexity indicator=[" + this.complexitate + "])";
    }
}

class TestSuite extends Test{
    private String nume;
    private ArrayList<Test> suita;
    private int numar_teste;

    public TestSuite(String nume){
        super(nume);
        this.suita = new ArrayList<Test>();
        this.numar_teste = 0;
    }

    public boolean addNewIntegrationTest(String name, int indicator){
        try{
            IntegrationTest it1 = new IntegrationTest("IT1", 2);
            this.suita.add(it1);
            return true;
        }catch(WrongQualityIndicatorException e){
            System.out.println("A aparut o exceptie: ")
        }
    }

    public int getNumarTeste(){
        return this.numar_teste;
    }
}

/* 6. Intr-un program de statistica peste String-uri, diversele feluri de statistici sunt caracterizate printre altele de operatia 
calculeaza (secventa _stringuri:String[*]):void avand rolul de a calcula/determina o statistica peste secvența de siruri de caractere 
data ca argument metodei (nota: puteti folosi liste sau tablouri, cum doriti). Detalille pentru diferitele feluri de statistici sunt 
prezentate in cele ce urmeazã.
Statistica NumãrAparitii: este caracterizata de o secvență de siruri de caractere cautate specificata la crearea unui astfel de obiect 
si memoratã in starea obiectului. La calcularea acestei statistici se va determina câte din String-urile din aceasta secventa sunt 
egale (adica reprezintã aceeasi secvență de caractere) cu String-urile date ca argument metodei calculează (nota: se consider cã nu 
avem duplicate). Un astfel de obiect este caracterizat si de un jurnal având forma unui sir de caractere in care se acumuleaza
/concateneaza toate rezultatele obtinute de aceasta statistica de-a lungul existentei obiectului. In acest sens, la sfârsitul metodei 
calculeaza, se adaugã in jurnal un mesaj de forma "in secventa {String1, ..., StringN} apar X siruri din secvența
{String1, ..., StringM}" in care prima secventa de String-uri e cea primita de metoda calculeaza ca argument, X e rezultatul statisticii 
iar a doua secvență corespunde Sirurilor din starea obiectului. Obiectul mai detine si o metoda pentru reprezentarea lui sub formã de 
sir de caractere care corespunde continutului jurnalului obiectului (adicã toate mesajele de forma amintita mai sus produse de metoda 
calculeaza, fiecare pe linie noua).
StatisticaNumeraleNonReale: la calcularea acestei statistici se va determina câte din String-urile din aceasta secvență NU sunt 
numerale reale (Notă: metoda statica parseDouble(String) din clasa Double se termina cu exceptia NumberFormatException dacã argumentul 
primit nu este un numeral corespunzător unui numar real). Un astfel de obiect este caracterizat si de un jurnal având forma unui sir 
de caractere in care se acumuleaza/concateneaza toate rezultatele obtinute de aceastã statistica de-a lungul existentei obiectului. 
In acest sens, la sfârsitul metodei calculeaza, se adauga in jural un mesaj de forma "In seventa {String1, ..., StringN} avem Y siruri 
ce nu sunt numerale reale" in care seventa de String-uri e cea primita de metoda calculeazã ca argument, iar Y e rezultatul statisticii. 
Obiectul mai detine si o metoda pentru reprezentarea lui sub forma de sir de caractere care corespunde continutului jurnalului obiectului 
(adica toate mesajele de forma amintitã mai sus produse de metoda calculeazã, fiecare pe linie noua).
Obiectele Executor primesc la crearea lor o seventa de statistici de orice fel si le memoreaza in starea lor. Executorii mai conțin metoda
executa(secventa_stringuri: Stringl]):void care aplica statisticile continute peste secvența de siruri de caractere data ca argument 
metodei dupã care afiseazã statisticile la iesirea standard.
Pentru exemplificare, intr-o metoda main creati un executor care contine un obiect StatisticaNumarAparitii care cauta numarul de 
aparitii a sirurilor "mere", "pere", “banane" si un obiect StatisticaNumeraleNonReale. Se apeleaza executorul pentru seventele de 
siruri "Ana", "are", "mere" si a doua oara pentru secventa "Maria", "are", "pere".
 */

