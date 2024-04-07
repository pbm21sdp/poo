/* Problema 1 Creati o clasa cu un constructor privat. Vedeti ce se intampla la compilare daca
creati o instanta a clasei intr-o metoda main. 

class Ceas {
    int ora;

    private Ceas() {
        this.ora = 23;
    }
}

class Main{
    public static void main(String args[]) {
        Ceas ceas1 = new Ceas();
    }
}
*/

/* Problema 2 Creati o clasa ce contine doua atribute nestatice private, un int si un char care nu sunt initializate si 
tipariti valorile acestora pentru a verifica daca Java realizeaza initializarea implicita 

class Motor {
    private int capacitate;
    private char marca;
    
    public void tipareste() {
        System.out.println("Motor de capacitate " + capacitate);
        System.out.println("Marca " + marca);
    }
}

class Main {
    public static void main(String args[]) {
        Motor motor1 = new Motor();
        motor1.tipareste();
    }
}
*/

/* Problema 3 Fiind data implementarea clasei Motor, se cere sa se precizeze ce se va afisa in urma
rularii secventei: 

class Motor {
    private int capacitate;

    public Motor(int c) {
        capacitate = c;
    }

    public void setCapacitate(int c) {
        capacitate = c;
    }

    public void tipareste() {
        System.out.println("Motor de capacitate " + capacitate);
    }
}

class Main{
    public static void main(String args[]) {
        Motor m1, m2;
        m1 = new Motor(5);
        m1.tipareste();
        m2 = m1;
        m2.tipareste();
        m2.setCapacitate(10);
        m1.tipareste();
        m2.tipareste();
    }
}
*/ 

/* Problema 4 Un sertar este caracterizat de o latime, lungime si inaltime. Un birou are doua sertare si, evident, o latime, 
lungime si inaltime. Creati clasele Sertar si Birou corespunzatoare specificatiilor de mai sus. 
Creati pentru fiecare clasa constructorul potrivit astfel incat caracteristicile instantelor sa fie setate la crearea acestora.
Clasa Sertar contine o metoda tipareste al carei apel va produce tiparirea pe ecran a sertarului sub forma 
"Sertar " + l + L + H, unde l, L, H sunt valorile coresupunzatoare latimii, lungimii ¸si inaltimii sertarului. 
Clasa Birou contine o metoda tipareste cu ajutorul careia se vor tipari toate componentele biroului. Creati intr-o
metoda main doua sertare, un birou si tipariti componentele biroului. 

class Sertar{
    private int latime;
    private int lungime;
    private int inaltime;

    public Sertar(int lat, int lung, int inalt) {
        this.latime = lat;
        this.lungime = lung;
        this.inaltime = inalt;
    }

    public void tipareste() {
        System.out.println("Sertar " + latime + " " + lungime + " " + inaltime);
    }
}

class Birou{
    private int latime;
    private int lungime;
    private int inaltime;
    private Sertar sertar1;
    private Sertar sertar2;

    public Birou(int lat, int lung, int inalt, Sertar ser1, Sertar ser2){
        this.latime = lat;
        this.lungime = lung;
        this.inaltime = inalt;
        this.sertar1 = ser1;
        this.sertar2 = ser2;
    }

    public void tipareste(){
        System.out.println("Birou " + latime + " " + lungime + " " + inaltime);
        sertar1.tipareste();
        sertar2.tipareste();
    }
}

class Main{
    public static void main(String args[]) {
        Sertar sertar1 = new Sertar(12, 13, 14);
        Sertar sertar2 = new Sertar(15, 43, 43);
        Birou birou1 = new Birou(123, 323, 254, sertar1, sertar2);
        birou1.tipareste();
    }
}
*/

/* Problema 5 Definiti o clasa Complex care modeleaza lucrul cu numere complexe. Membrii acestei clase sunt:
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
metoda main exemple de utilizare ale metodelor clasei Complex. */

class Complex{
    private double real;
    private double imaginar;
    private static int numar_afisari = 0;

    public Complex(double re, double im) {
        this.real = re;
        this.imaginar = im;
    }

    public double modulComplex() {
        return Math.sqrt(this.real * this.real + this.imaginar * this.imaginar);
    }

    public void tiparire(){
        System.out.println(real + " + i* " + imaginar);
        numar_afisari++;
    }

    public Complex sumaComplex(Complex complex1){
        double sumaReal = this.real + complex1.real;
        double sumaImaginar = this.imaginar + complex1.imaginar;
        return new Complex(sumaReal, sumaImaginar);
    }

    public static void returnNumarAfisari(){
        System.out.println("S-au afisat " + numar_afisari + " numere complexe");
    }
}

class ClientComplex{
    public static void main(String args[]) {
        Complex nr1 = new Complex(2, 3);
        Complex nr2 = new Complex(3, 4);
        nr1.tiparire();
        nr2.tiparire();
        (nr1.sumaComplex(nr2)).tiparire();
        Complex.returnNumarAfisari();
        System.out.println(nr1.modulComplex());
    }
}