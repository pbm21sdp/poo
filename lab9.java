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

abstract class Project implements Risky{
    private String titlu; //atributele folosite doar in clasa asta sunt private
    private String obiectiv;
    protected long fonduri; //atributele care vor fi folosite in subclase sunt protected
    protected Member manager;
    protected Member[] programatori;
    protected int numarMembri;

    public Project(String t, String o, long f, Member m)
    {
	this.titlu = t;
	this.obiectiv = o;
	this.fonduri = f;
	this.manager = m;
	this.programatori = new Member[15];
	this.numarMembri = 0;
    }

    public void addMember(Member m)
    {
	int i = 0;
	if(numarMembri == programatori.length){
	    Member[] tmp = new Member[programatori.length + 10];
	    for(i = 0; i < programatori.length; i++){
		tmp[i] = programatori[i];
	    }
	    programatori = tmp;
	}
	programatori[numarMembri] = m;
	numarMembri++;
    }

    public double getRisk(){
	return (this.numarMembri / (double)this.fonduri);
    }

    public String getTitlu(){
	return this.titlu;
    }
}

class Comerciale extends Project{
    private String deadLine;
    private long fonduriMarketing;
    private int numarEchipe;

    public Comerciale(String t, String o, long f, Member m, String d, long fm, int nr)
    {
	super(t, o, f, m);
	this.deadLine = d;
	this.fonduriMarketing = (this.fonduri) / 2;
	this.numarEchipe = nr;
    }

    public void addMember(Member m){
	if(this.numarMembri < 15){
	    programatori[numarMembri++] = m;
	}
	else{
	    System.out.println("Nu puteti avea mai mult de 15 membri.");
	}
    }

    public double getRisk(){
	return ((this.numarEchipe*3) / this.numarMembri / (double)(this.fonduri - this.fonduriMarketing));
    }
}

class Militare extends Project{
    private String deadLine;
    private String parola;

    public Militare(String t, String o, long f, Member m, String d, String p)
    {
	super(t, o, f, m);
	this.deadLine = d;
	this.parola = p;
    }

    public void addMember(Member m){
	if(this.numarMembri < 15){
	    programatori[numarMembri++] = m;
	}
	else{
	    System.out.println("Nu puteti avea mai mult de 15 membri.");
	}
    }

    public double getRisk(){
	return (this.numarMembri / this.parola.length() / (double)this.fonduri);
    }
}

class openSource extends Project{
    private String mailingList;

    public openSource(String t, String o, long f, Member m, String ml){
	super(t, o, f, m);
	this.mailingList = ml;
    }

    public double getRisk(){
	return (this.numarMembri / (double)this.fonduri);	
    }
}

class InvestmentCompany{
    private Project[] proiecte;
    private int numarProiecte;

    public InvestmentCompany(){
	this.proiecte = new Project[15];
	numarProiecte = 0;
    }
    
    public void addProject(Project p){
	int i = 0;
	if(numarProiecte == proiecte.length){
	    Project[] tmp = new Project[proiecte.length + 10];
	    for(i = 0; i < proiecte.length; i++){
		tmp[i] = proiecte[i];
	    }
	    proiecte = tmp;
	}
	proiecte[numarProiecte] = p;
	numarProiecte++;
    }

    public Project getBestInvestment(){
	int i = 0;

	Project bun = proiecte[0];
	double riscMinim = bun.getRisk();

	for(i = 1; i < numarProiecte; i++){
	    double risc = proiecte[i].getRisk();
	    if(risc < riscMinim){
		riscMinim = risc;
		bun = proiecte[i];
	    }
	}
	return bun;
    }

    public static void main(String args[]){
	Member manager = new Member(25, "Manager");
	Member programator1 = new Member(34, "P1");
	Member programator2 = new Member(45, "P2");
	Member programator3 = new Member(43, "P3");
	Member programator4 = new Member(32, "P4");

	Project c1 = new Comerciale("Comercial1", "Vanzari", 10000, manager, "11/11", 5000, 3);
	c1.addMember(programator1);
	c1.addMember(programator2);
	c1.addMember(programator3);
	c1.addMember(programator4);

	Project m1 = new Militare("Militar1", "Armata", 12000, manager, "12/12", "123pass");
	m1.addMember(programator1);
	m1.addMember(programator2);
	m1.addMember(programator3);
	m1.addMember(programator4);

	Project o1 = new openSource("OpenSource1", "Surse", 13000, manager, "mail@source");
	o1.addMember(programator1);
	o1.addMember(programator2);
	o1.addMember(programator3);
	o1.addMember(programator4);

	InvestmentCompany i1 = new InvestmentCompany();

	i1.addProject(c1);
	i1.addProject(m1);
	i1.addProject(o1);

	Project bun = i1.getBestInvestment();
	if(bun != null){
	    System.out.println("Cel mai putin riscant proiect este: " + bun.getTitlu());
	}
    }
}
