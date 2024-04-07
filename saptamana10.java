abstract class Angajat{
    protected String nume;
    
    public Angajat(String nume){
        this.nume = nume;
    }
    
    public abstract double calculSalar();
    
    public abstract void schimbaSalar(double salarNou);

    public abstract boolean equals(Object o);
}

class AngajatCuSalarFix extends Angajat{
    private double salarFix;
    private double salarNou;

    public AngajatCuSalarFix(String nume, double salarFix){
        super(nume);
        this.salarFix = salarFix;
        this.salarNou = 0;
    }

    public void schimbaSalar(double salarNou){
        this.salarNou = salarNou;
    }

    public double calculSalar(){
        if(this.salarNou != 0){
            return this.salarNou;
        }
        return this.salarFix;
    }

    public boolean equals(Object o){
        if(o instanceof Angajat){
            return (((Angajat)o).nume == nume);
        }
        else{
            return false;
        }
    }
}

class AngajatCuOra extends Angajat{
    private double salarOra;
    private double[] oreLucrate;
    private double totalOre;
    private int numarIntrari;

    public AngajatCuOra(String nume, double salarOra){
        super(nume);
        this.salarOra = salarOra;
        this.oreLucrate = new double[31];
        this.totalOre = 0;
        this.numarIntrari = 0;
    }

    public boolean adaugaOre(double ore){
        if(numarIntrari < oreLucrate.length){
            oreLucrate[numarIntrari] = ore;
            numarIntrari++;
            totalOre = totalOre + ore;
            return true;
        }
        else{
            return false;
        }
    }

    public void schimbaSalar(double salarNou){
        this.salarOra = salarNou;
    }

    public double calculSalar(){
        return totalOre * salarOra;
    }
}

class Firma{
    private String nume;
    private Angajat[] angajati;
    private int numarAngajati;
    private double salarTotal;

    public Firma(String nume){
        this.nume = nume;
        this.angajati = new Angajat[1024];
        this.numarAngajati = 0;
        this.salarTotal = 0;
    }

    public int angajeaza(Angajat a1){
        int i = 0;
        if(numarAngajati > angajati.length){
            return -1;
        }
        else{
            for (i = 0; i < numarAngajati; i++){
                if (angajati[i] != null && (angajati[i].equals(a1))){
                    return -2; 
                }
            }
        }
        angajati[numarAngajati] = a1;
        numarAngajati++;
        return 0;
    }

    public double calculeazaTotal(){
        int i = 0;
        salarTotal = 0;
        for(i = 0; i < numarAngajati; i++){
            this.salarTotal = this.salarTotal + angajati[i].calculSalar();
            }
        return salarTotal;
    }

    public double salariuMediu(){
        salarTotal = calculeazaTotal();
        double medie = 0;
        if(numarAngajati == 0){
            return 0;
        }
        else{
            medie = (this.salarTotal) / (this.numarAngajati);
        }
        return medie;
    }
}

class Main{
    public static void main(String args[]){
        Firma f1 = new Firma("Firma");

        double medieFaraAngajati = f1.salariuMediu();
        System.out.println("Media salariilor inainte de a avea angajati este: " + medieFaraAngajati);

        AngajatCuSalarFix a1 = new AngajatCuSalarFix("Briana", 2500);
        AngajatCuSalarFix a2 = new AngajatCuSalarFix("Sara", 3000);

        AngajatCuOra a3 = new AngajatCuOra("Filip", 45);
        a3.adaugaOre(8);
        a3.adaugaOre(8);
        a3.adaugaOre(4);
        AngajatCuOra a4 = new AngajatCuOra("Marius", 40);
        a4.adaugaOre(12);
        a4.adaugaOre(12);
        a4.adaugaOre(8);

        f1.angajeaza(a1);
        f1.angajeaza(a2);
        f1.angajeaza(a3);
        f1.angajeaza(a4);
         
        int angajare = f1.angajeaza(a1);
        if(angajare == -2){
            System.out.println("Acest angajat exista deja in firma.");
        }

        System.out.println(f1.angajeaza(a2));
        
        double salarMediu = f1.salariuMediu();
        System.out.println("Salariul mediu al firmei inainte de schimbari este: " + salarMediu);

        a1.schimbaSalar(2800);
        double salarMediu2 = f1.salariuMediu();
        System.out.println("Salariul mediu al firmei este: " + salarMediu2);

        a3.schimbaSalar(50);
        double salarMediu3 = f1.salariuMediu();
        System.out.println("Salariul mediu al firmei este: " + salarMediu3);
    }
}