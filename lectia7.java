interface Risky{
    public double getRisk();
}

class Member{
    private int varsta;
    private String nume;

    public Member(int v, String n){
        this.varsta = v;
        this.nume = n;
    }
}

class Manager extends Member{
    public Manager(int v, String n){
        super(v, n);
    }
}

class Programator extends Member{
    public Programator(int v, String n){
        super(v, n);
    }
}

class Project implements Risky{
    private String titlu;
    private String obiectiv;
    private long fonduri;
    private Manager manager;
    private Member[] programatori;
    private int numarMembri;

    public Project(String t, String o, long f, Manager m){
        this.titlu = t;
        this.obiectiv = o;
        this.fonduri = f;
        this.manager = m;
        this.programatori = new Member[15];
        numarMembri = 0;
    }

    public void addMember(Member m){
        int i = 0;
        if(numarMembri == programatori.length) {
            Member[] tmp = new Member[programatori.length + 10];
            for(i = 0; i < programatori.length; i++) {
                tmp[i] = programatori[i];
            }
            programatori = tmp;
        }
        programatori[numarMembri] = m;
        numarMembri++;
    }

    public double getRisk(){
        return this.numarMembri / (double)this.fonduri;
    }

    public int getMembri(){
        return this.numarMembri;
    }

    public long getFonduri(){
        return this.fonduri;
    }

    public String getTitlu(){
        return this.titlu;
    }
}

class Comerciale extends Project{
    private String deadLine;
    private long fonduriMarketing;
    private int numarEchipe;

    public Comerciale(String t, String o, long f, Manager m, String d, int nr){
        super(t, o, f, m);
        this.deadLine = d;
        this.fonduriMarketing = f / 2;
        this.numarEchipe = nr;
    }

    public double getRisk(){
        return ((this.numarEchipe * 3) / this.getMembri()) / (this.getFonduri() - this.fonduriMarketing);
    }
}

class Militare extends Project{
    private String deadLine;
    private String parola;

    public Militare(String t, String o, long f, Manager m, String d, String p){
        super(t, o, f, m);
        this.deadLine = d;
        this.parola = p;
    }

    public double getRisk(){
        return (this.getMembri() / this.parola.length()) / this.getFonduri();
    }
}

class openSource extends Project{
    private String mailinglist;

    public openSource(String t, String o, long f, Manager m, String ml){
        super(t, o, f, m);
        this.mailinglist = ml;
    }
}

class InvestmentCompany{
    private Project[] proiecte;
    private int numarProiecte;

    public InvestmentCompany(){
        this.proiecte = new Project[15];
        this.numarProiecte = 0;
    }

    public void addProject(Project p){
        int i = 0;
        if(numarProiecte == proiecte.length) {
            Project[] tmp = new Project[proiecte.length + 10];
            for(i = 0; i < proiecte.length; i++) {
                tmp[i] = proiecte[i];
            }
            proiecte = tmp;
        }
        proiecte[numarProiecte] = p;
        numarProiecte++;
    }

    public Project getBestInvestment(){
        int i = 0;

        if (numarProiecte == 0) {
            System.out.println("Firma nu are proiecte.");
            return null;
        }

        Project bestProject = proiecte[0];
        double riscMinim = bestProject.getRisk();

        for (i = 1; i < numarProiecte; i++) {
            double risk = proiecte[i].getRisk();
            if (risk < riscMinim) {
                riscMinim = risk;
                bestProject = proiecte[i];
            }
        }
        return bestProject;
    }
    public static void main(String[] args){
        Manager manager = new Manager(35, "Manager1");
        Programator programmer1 = new Programator(28, "Programator1");
        Programator programmer2 = new Programator(30, "Programator2");

        Comerciale comercial1 = new Comerciale("ComercialProject1", "Obiectiv1", 100000, manager, "50000", 2);
        comercial1.addMember(manager);
        comercial1.addMember(programmer1);
        comercial1.addMember(programmer2);

        Militare militar1 = new Militare("MilitaryProject1", "Obiectiv2", 80000, manager, "2321", "parola123");
        militar1.addMember(manager);
        militar1.addMember(programmer1);

        openSource op1 = new openSource("OpenSourceProject1", "Obiectiv3", 50000, manager, "mailinglist@example.com");
        op1.addMember(manager);
        op1.addMember(programmer1);
        op1.addMember(programmer2);

        InvestmentCompany investmentCompany = new InvestmentCompany();
        investmentCompany.addProject(comercial1);
        investmentCompany.addProject(militar1);
        investmentCompany.addProject(op1);

        Project bestInvestment = investmentCompany.getBestInvestment();
        if (bestInvestment != null) {
            System.out.println("Cel mai putin riscant proiect este: " + bestInvestment.getTitlu());
        }
    }
}