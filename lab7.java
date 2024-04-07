 class Avion{
    private String planeID;
    private int totalEnginePower;

    public Avion(String id, int pow){
        this.planeID = id;
        this.totalEnginePower = pow;
    }

    public String getPlaneID(){
        return this.planeID;
    }

    public int getTotalEnginePower(){
        return this.totalEnginePower;
    }

    public void takeoff(){
        System.out.println(this.planeID + " - Initiating takeoff procedure - Starting engines - Accelerating down the runway - Taking off - Retracting gear - Takeoff complete");
    }

    public void land(){
        System.out.println(this.planeID + " - Initiating landing procedure - Enabling airbrakes - Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing complete");
    }

    public void fly(){
        System.out.println(this.planeID + " - Flying");
    }
}

class Calatori extends Avion{
    private int maxPassengers;

    public Calatori(int pasageri, String id, int pow){
        super(id, pow);
        this.maxPassengers = pasageri;
    }

    public int getMaxPassengers(){
        return this.maxPassengers;
    }
}

class Concorde extends Calatori{
    public Concorde(int pas, String id, int pow){
        super(pas, id, pow);
    }

    public void goSuperSonic(){
        System.out.println(this.getPlaneID() + " - Supersonic mode activated");
    }

    public void goSubSonic(){
        System.out.println(this.getPlaneID() + " - Supersonic mode deactivated");
    }

}
    
class Lupta extends Avion{

    public Lupta(String id, int pow){
        super(id, pow);
    }

    public void launchMissile(){
        System.out.println(this.getPlaneID() + " - Initiating missile launch procedure - Acquiring target - Launching missile - Breaking away - Missile launch complete");
    }
}

class Mig extends Lupta{

    public Mig(String id, int pow){
        super(id, pow);
    }

    public void highSpeedGeometry(){
        System.out.println(this.getPlaneID() + " - High speed geometry selected");
    }

    public void normalGeometry(){
        System.out.println(this.getPlaneID() + " - Normal geometry selected");
    }
}

class TomCat extends Lupta{

    public TomCat(String id, int pow){
        super(id, pow);
    }

    public void refuel(){
        System.out.println(this.getPlaneID() + " - Initiating refueling procedure - Locating refueller - Catching up - Refueling - Refueling complete");
    }
}

class Main{
    public static void main(String args[]){
        Avion boeing747 = new Calatori(500, "Boeing 747", 40000);
        Avion concorde = new Concorde(200, "Concorde", 60000);
        Avion mig29 = new Mig("Mig-29", 30000);
        Avion tomcat = new TomCat("F-14 Tomcat", 35000);

        boeing747.takeoff();
        boeing747.fly();
        boeing747.land();

        concorde.takeoff();
        concorde.fly();
        concorde.land();
        ((Concorde) concorde).goSuperSonic();
        ((Concorde) concorde).goSubSonic();

        mig29.takeoff();
        mig29.fly();
        mig29.land();
        ((Mig) mig29).launchMissile();
        ((Mig) mig29).highSpeedGeometry();
        ((Mig) mig29).normalGeometry();

        tomcat.takeoff();
        tomcat.fly();
        tomcat.land();
        ((TomCat) tomcat).launchMissile();
        ((TomCat) tomcat).refuel();
    }
}
 