/* 
Problema 1 Compilatti si lansati in executie programul “Hello World!” dat ca exemplu in Sectiunea 1.2.6. 

class PrimulProgram {
    public static void main(String args[]) {
        System.out.println("Hello world!");
    }
}
*/

/* 
Problema 2 Scrieti un program Java care initializeaza doua variabile intregi cu doua valori constante oarecare. 
In continuare, programul va determina variabila ce contine valoarea maxima si va tipari continutul ei pe ecran.
 
class Problema2 {
    public static void main(String args[]) {
        int a = 21;
        int b = 23;
        if(a > b) {
            System.out.println("Variabila cu valoarea maxima este a: " + a);
        }
        else {
            System.out.println("Variabila cu valoarea maxima este b: " + b);
        }
    }
}
*/

/* Problema 3 Scrieti un program Java care afiseaza pe ecran numerele impare si suma numerelor pare cuprinse in intervalul 1-100 inclusiv. */

class Problema3 {
    public static void main(String args[]) {
        int i;
        int suma = 0;
        for(i = 0; i < 101; i++) {
            if(i % 2 == 0) {
                suma = suma + i;
            }
            else {
                System.out.println(i);
            }
        }
        System.out.println("Suma numerelor pare cuprinse in intervalul 1-100 inclusiv este: " + suma);
    }
}