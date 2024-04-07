/*Intr-un program de statistica peste String-uri, diversele feluri de statistici sunt caracterizate printre altele de operatia 
calculeaza(secventa _stringuri:String[*]):void avand rolul de a calcula/determina o statistica peste secventa de siruri de caractere 
data ca argument metodei (noat: puteti folosi liste sau tablouri, cum doriti). Detalille pentru diferitele feluri de statistici sunt 
prezentate in cele ce urmeazã.


StatisticaNumãrAparitii: este caracterizata de o secventa de siruri de caractere cautate specificata la crearea unui astfel de obiect
 si memoratã in starea obiectului. La calcularea acestei statistici se va determina câte din String-urile din aceasta secventa sunt egale 
 (adica reprezintã aceeasi seventa de caractere) cu String-urile date ca argument metodei calculează (nota: se consider cã nu avem 
 duplicate). Un astfel de obiect este caracterizat si de un jurnal avand forma unui sir de caractere in care se acumuleaza/concateneaza 
 toate rezultatele obtinute de aceasta statistica de-a lungul existentei obiectului. In acest sens, la sfârsitul metodei calculeaza, se 
 adaugã in jurnal un mesaj de forma "in secventa {String1, .., StringN} apar X siruri din secventa {String1, ..., StringM}" in care 
 prima secventa de String-uri e cea primita de metoda calculeaza ca argument, X e rezultatul statisticii iar a doua secventa corespunde 
 sirurilor din starea obiectului. Obiectul mai detine si o metoda pentru reprezentarea lui sub formã de sir de caractere care corespunde 
 continutului jurnalului obiectului (adicã toate mesajele de forma amintita mai sus produse de metoda calculeaza, fiecare pe linie noua).
StatisticaNumeraleNonReale: la calcularea acestei statistici se va determina câte din String-urile din aceasta secventa NU sunt numerale 
reale (Notă: metoda statica parseDouble(String) din clasa Double se termina cu exceptia NumberFormatException dacã argumentul primit nu 
este un numeral corespunzător unui numar real). Un astfel de obiect este caracterizat si de un jurnal avand forma unui sir de caractere 
in care se acumuleaza/concateneaza toate rezultatele obtinute de aceastã statistica de-a lungul existentei obiectului. In acest sens, 
la sfârsitul metodei calculeaza, se adauga in jural un mesaj de forma "In seventa {String1, ..., StringN} avem Y siruri ce nu sunt 
numerale reale" in care secventa de String-uri e cea primita de metoda calculeazã ca argument, iar Y e rezultatul statisticii. 
Obiectul mai detine si o metoda pentru reprezentarea lui sub forma de sir de caractere care corespunde continutului jurnalului obiectului 
(adica toate mesajele de forma amintitã mai sus produse de metoda calculeazã, fiecare pe linie noua).
Obiectele Executor primesc la crearea lor o secventa de statistici de orice fel si le memoreaza in starea lor. Executorii mai contin 
metoda executa(secventa_stringuri: String[*]):void care aplica statisticile continute peste secventa de siruri de caractere data ca 
argument metodei dupã care afiseazã statisticile la iesirea standard.
Pentru exemplificare, intr-o metoda main creati un executor care contine un obiect StatisticaNumarAparitii care cauta numarul de 
aparitii a sirurilor "mere", "pere", "banane" si un obiect StatisticaNumeraleNonReale. Se apeleaza executorul pentru seventele de 
siruri "Ana", "are", "mere" si a doua oara pentru secventa "Maria", "are", "pere". */

import java.util.*;

class StatisticaNumarAparitii {
    private List<String> cautate;
    private StringBuilder jurnal;

    public StatisticaNumarAparitii(String[] cautate) {
        this.cautate = new ArrayList<>();
        for (String cuvant : cautate) {
            this.cautate.add(cuvant);
        }
        this.jurnal = new StringBuilder();
    }

    public void calculeaza(String[] secventa_stringuri) {
        int rezultat = 0;
        for (String cuvant : cautate) {
            for (String s : secventa_stringuri) {
                if (cuvant.equals(s)) {
                    rezultat++;
                }
            }
        }
        jurnal.append(String.format("In secventa {%s} apar %d siruri din secventa {%s}\n",
                String.join(", ", cautate), rezultat, String.join(", ", secventa_stringuri)));
    }

    public String reprezinta() {
        return jurnal.toString();
    }
}

class StatisticaNumeraleNonReale {
    private StringBuilder jurnal;

    public StatisticaNumeraleNonReale() {
        this.jurnal = new StringBuilder();
    }

    public void calculeaza(String[] secventa_stringuri) {
        int rezultat = 0;
        for (String s : secventa_stringuri) {
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException e) {
                rezultat++;
            }
        }
        jurnal.append(String.format("In secventa {%s} avem %d siruri ce nu sunt numerale reale\n",
                String.join(", ", secventa_stringuri), rezultat));
    }

    public String reprezinta() {
        return jurnal.toString();
    }
}

class Executor {
    private List<Object> statistici;

    public Executor(List<Object> statistici) {
        this.statistici = statistici;
    }

    public void executa(String[] secventa_stringuri) {
        for (Object statistica : statistici) {
            if (statistica instanceof StatisticaNumarAparitii) {
                ((StatisticaNumarAparitii) statistica).calculeaza(secventa_stringuri);
            } else if (statistica instanceof StatisticaNumeraleNonReale) {
                ((StatisticaNumeraleNonReale) statistica).calculeaza(secventa_stringuri);
            }
        }
    }

    public void afiseazaStatistici() {
        for (Object statistica : statistici) {
            if (statistica instanceof StatisticaNumarAparitii || statistica instanceof StatisticaNumeraleNonReale) {
                System.out.println(statistica.getClass().getSimpleName() + ":\n" + ((Reprezentabil) statistica).reprezinta());
            }
        }
    }
}

interface Reprezentabil {
    String reprezinta();
}

public class Main {
    public static void main(String[] args) {
        String[] cautateNumarAparitii = {"mere", "pere", "banane"};
        StatisticaNumarAparitii statNumarAparitii = new StatisticaNumarAparitii(cautateNumarAparitii);

        StatisticaNumeraleNonReale statNumeraleNonReale = new StatisticaNumeraleNonReale();

        List<Object> statistici = new ArrayList<>();
        statistici.add(statNumarAparitii);
        statistici.add(statNumeraleNonReale);

        Executor executor = new Executor(statistici);

        String[] secventa1 = {"Ana", "are", "mere"};
        executor.executa(secventa1);

        String[] secventa2 = {"Maria", "are", "pere"};
        executor.executa(secventa2);

        executor.afiseazaStatistici();
    }
}
