/* Problema 1 Metodele de mai jos sunt supraincarcate?
public void faCeva(int x) {...}
public int faCeva(int x) {...} 
Da, pentru ca au acelasi nume, dar distinctia intre ele se realizeaza prin tipul returnat */

/* Problema 2 O carte este caracterizata printr-un numar de pagini. Spunem ca doua carti sunt
identice daca acestea au acelasi numar de pagini. Creati clasa Carte si atasati-i o
metoda potrivita pentru compararea a doua carti. Apelati metoda care realizeaza
compararea a doua carti intr-o metoda main. 

class Carte{
    private int numar_pagini;

    public Carte(int nr_pag){
        this.numar_pagini = nr_pag;
    }

    public boolean equals(Object o){
        if(o instanceof Carte) {
            return (((Carte)o).numar_pagini == this.numar_pagini);
            }
        else {        
            return false;
        }
    } 
}

class Main{
    public static void main(String args[]){
        Carte carte1 = new Carte(132);
        Carte carte2 = new Carte(132);
        if(carte1.equals(carte2)) {
            System.out.println("Cartile au acelasi numar de pagini");
        }
        else{
            System.out.println("Cartile nu au acelasi numar de pagini");
        } 
    }
}
*/

/* Problema 3 Un patrat este caracterizat de latura sa. Scrieti o clasa Patrat ce are doi constructori,
un constructor fara nici un parametru care seteaza latura patratului ca fiind 10
iar altul care seteaza latura cu o valoare egala cu cea a unui parametru transmis
constructorului. Atasati clasei o metoda potrivita pentru tiparirea unui patrat sub
forma ”Patrat” l ”Aria” a, unde l este valoarea laturii iar a este valoarea ariei
patratului. Creati intr-o metoda main diferite obiecte de tip Patrat si tipariti-le 

class Patrat{
    private int latura;
    private int arie;

    public Patrat(){
        this.latura = 10;
    }

    public Patrat(int lat){
        this.latura = lat;
    }

    public String toString(){
        return "Patrat " + latura + " Aria " + latura*latura;
    }
}

class Main{
    public static void main(String args[]) {
        Patrat p1 = new Patrat();
        System.out.println(p1);

        Patrat p2 = new Patrat(12);
        System.out.println(p2);
    }
}
*/

/* Problema 4 Creati o clasa Piramida ce are un atribut intreg n. Atasati clasei o metoda potrivita
pentru tiparirea unei piramide ca mai jos:
1 1 1 1
2 2 2
3 3
4 --> n
Creati intr-o metoda main diferite obiecte de tip Piramida ¸si tipariti-le 

class Piramida{
    private int n;

    public Piramida(int nr){
        this.n = nr;
    }

    public void tiparestePiramida() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
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
    public static void main(String args[]){
        Piramida p1 = new Piramida(4);
        p1.tiparestePiramida();

        Piramida p2 = new Piramida(3);
        p2.tiparestePiramida();
    }
}
*/

/* Problema 5 Definiti o clasa Suma cu metodele statice de mai jos:
// returneaza suma dintre a si b
a) public static int suma(int a, int b) ...
//returneaza suma dintre a, b si c
b) public static int suma(int a, int b, int c) ...
// returneaza suma dintre a, b, c si d
c) public static int suma(int a, int b, int c, int d) ...
Implementati metodele astfel incat fiecare metoda sa efectueze o singura adunare.
Apelati-le dintr-o metoda main. */

class Suma{
    public static int suma(int a, int b){
        return a + b;
    }

    public static int suma(int a, int b, int c){
        return suma(a, b) + c;
    }

    public static int suma(int a, int b, int c, int d) {
        return suma(a, b, c) + d;
    }
    public static void main(String args[]){
        int a = 5;
        int b = 7;
        int c = 10;
        int d = 3;

        int result1 = suma(a, b);
        int result2 = suma(a, b, c);
        int result3 = suma(a, b, c, d);

        System.out.println("Suma a si b este: " + result1);
        System.out.println("Suma a, b si c este: " + result2);
        System.out.println("Suma a, b, c si d este: " + result3);
    }
}