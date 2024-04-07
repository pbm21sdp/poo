// Interfața pentru a calcula riscul
interface Risky {
    double getRisk();
}

// Clasa de bază pentru proiecte
class Project implements Risky {
    private String title;
    private String objective;
    private long funds;
    private Manager manager;
    private Programmer[] participants;
    private int numParticipants;

    // Constructor
    public Project(String title, String objective, long funds, Manager manager) {
        this.title = title;
        this.objective = objective;
        this.funds = funds;
        this.manager = manager;
        this.participants = new Programmer[15]; // Număr maxim de participanți
        this.numParticipants = 0;
    }

    // Adaugă un membru în proiect
    public void addMember(Programmer programmer) {
        if (numParticipants < 15) {
            participants[numParticipants++] = programmer;
        } else {
            System.out.println("Proiectul este plin. Nu se mai pot adăuga membri.");
        }
    }

    // Metoda pentru a calcula riscul (implementată din interfata Risky)
    public double getRisk() {
        // Implementarea generică pentru toate tipurile de proiecte
        return numParticipants / (double) funds;
    }
}

// Clasa pentru proiectele comerciale
class CommercialProject extends Project {
    private long marketingFunds;
    private int numTeams;

    // Constructor
    public CommercialProject(String title, String objective, long funds, Manager manager, long marketingFunds, int numTeams) {
        super(title, objective, funds, manager);
        this.marketingFunds = marketingFunds;
        this.numTeams = numTeams;
    }

    // Suprascrie metoda getRisk pentru a calcula riscul specific proiectelor comerciale
    @Override
    public double getRisk() {
        return (numTeams * 3) / (double) (getNumParticipants() * getFunds() - marketingFunds);
    }
}

// Clasa pentru proiectele militare
class MilitaryProject extends Project {
    private String password;

    // Constructor
    public MilitaryProject(String title, String objective, long funds, Manager manager, String password) {
        super(title, objective, funds, manager);
        this.password = password;
    }

    // Suprascrie metoda getRisk pentru a calcula riscul specific proiectelor militare
    @Override
    public double getRisk() {
        return getNumParticipants() / (double) (password.length() * getFunds());
    }
}

// Clasa pentru proiectele open-source
class OpenSourceProject extends Project {
    private String mailingList;

    // Constructor
    public OpenSourceProject(String title, String objective, long funds, Manager manager, String mailingList) {
        super(title, objective, funds, manager);
        this.mailingList = mailingList;
    }
}

// Clasa pentru manager și programatori
class Member {
    private String name;
    private int age;

    // Constructor
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Clasa pentru manager
class Manager extends Member {
    // Constructor
    public Manager(String name, int age) {
        super(name, age);
    }
}

// Clasa pentru programatori
class Programmer extends Member {
    // Constructor
    public Programmer(String name, int age) {
        super(name, age);
    }
}

// Clasa pentru firma de investiții
class InvestmentCompany {
    private Project[] projects;
    private int numProjects;

    // Constructor
    public InvestmentCompany() {
        this.projects = new Project[100]; // Număr maxim de proiecte
        this.numProjects = 0;
    }

    // Adaugă un proiect în firmă
    public void addProject(Project project) {
        if (numProjects < 100) {
            projects[numProjects++] = project;
        } else {
            System.out.println("Firma are prea multe proiecte. Nu se mai pot adăuga altele.");
        }
    }

    // Returnează proiectul cel mai puțin riscant
    public Project getBestInvestment() {
        if (numProjects == 0) {
            System.out.println("Firma nu are proiecte.");
            return null;
        }

        Project bestProject = projects[0];
        double minRisk = bestProject.getRisk();

        for (int i = 1; i < numProjects; i++) {
            double risk = projects[i].getRisk();
            if (risk < minRisk) {
                minRisk = risk;
                bestProject = projects[i];
            }
        }

        return bestProject;
    }

    // Metoda main pentru exemplificarea utilizării clasei
    public static void main(String[] args) {
        // Creați un manager și programatori
        Manager manager = new Manager("Manager1", 35);
        Programmer programmer1 = new Programmer("Programmer1", 28);
        Programmer programmer2 = new Programmer("Programmer2", 30);

        // Creați un proiect comercial și adăugați membri
        CommercialProject commercialProject = new CommercialProject("ComercialProject1", "Obiectiv1", 100000, manager, 50000, 2);
        commercialProject.addMember(manager);
        commercialProject.addMember(programmer1);
        commercialProject.addMember(programmer2);

        // Creați un proiect militar și adăugați membri
        MilitaryProject militaryProject = new MilitaryProject("MilitaryProject1", "Obiectiv2", 80000, manager, "parola123");
        militaryProject.addMember(manager);
        militaryProject.addMember(programmer1);

        // Creați un proiect open-source și adăugați membri
        OpenSourceProject openSourceProject = new OpenSourceProject("OpenSourceProject1", "Obiectiv3", 50000, manager, "mailinglist@example.com");
        openSourceProject.addMember(manager);
        openSourceProject.addMember(programmer1);
        openSourceProject.addMember(programmer2);

        // Creați o firmă de investiții și adăugați proiectele
        InvestmentCompany investmentCompany = new InvestmentCompany();
        investmentCompany.addProject(commercialProject);
        investmentCompany.addProject(militaryProject);
        investmentCompany.addProject(openSourceProject);

        // Afișați proiectul cel mai puțin riscant
        Project bestInvestment = investmentCompany.getBestInvestment();
        if (bestInvestment != null) {
            System.out.println("Cel mai puțin riscant proiect este: " + bestInvestment.getTitle());
        }
    }
}
