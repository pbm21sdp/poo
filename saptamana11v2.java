import java.util.Random;
import java.util.Date;

class CoordinateGenerator{
    private Random randomGenerator;

    public CoordinateGenerator(){
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }

    public int generateX(){
        int x = randomGenerator.nextInt(101);
        if(x < 5){
            x = 0;
        } 
        else if(x > 95){
            x = 100;
        } 
        else{
            x = randomGenerator.nextInt(99) + 1;
        }
        return x;
    }

    public int generateY(){
        int y = randomGenerator.nextInt(101);
        if(y < 5){
            y = 0;
        } 
        else if(y > 95){
            y = 50;
        } 
        else{
            y = randomGenerator.nextInt(49) + 1;
        }
            return y;
        }
}

class Out extends Exception{}
class Gol extends Exception{}
class Corner extends Exception{}

class Minge{
    private int X;
    private int Y;

    public Minge(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getCoordonataX(){
        return this.X;
    }

    public int getCoordonataY(){
        return this.Y;
    }

    public void suteaza(CoordinateGenerator cg1) throws Out, Gol, Corner{
        this.X = cg1.generateX();
        this.Y = cg1.generateY();
        
        if(Y == 0 || Y == 50){
            throw new Out();
        }
        else if((X == 0 || X == 100) && (Y >= 20 && Y <= 30)){
            throw new Gol();
        }
        else if((X == 0 || X == 100) && (((Y > 0) && (Y < 20)) || (Y > 30) && (Y < 50))){
            throw new Corner();
        }
    }
}

class Joc{
    private String numeEchipa1;
    private String numeEchipa2;
    private int goluriEchipa1;
    private int goluriEchipa2;
    private int outTotal;
    private int cornerTotal;
    private CoordinateGenerator g1;

    public Joc(String nume1, String nume2){
        this.numeEchipa1 = nume1;
        this.numeEchipa2 = nume2;
        this.goluriEchipa1 = 0;
        this.goluriEchipa2 = 0;
        this.outTotal = 0;
        this.cornerTotal = 0;
        this.g1 = new CoordinateGenerator();
    }

    public void simuleaza(){
        Minge m1 = new Minge(50, 25);
        int i = 0;

        for(i = 0; i < 1000; i++){
            try{
                m1.suteaza(g1);
            } catch(Out o){
                this.outTotal++;
                int altX = m1.getCoordonataX();
                int altY = m1.getCoordonataY();
                System.out.println("Out");
                m1 = new Minge(altX, altY);
            } catch(Gol g){
                if(m1.getCoordonataX() == 0){
                    this.goluriEchipa2++;
                }
                else if(m1.getCoordonataX() == 100){
                    this.goluriEchipa1++;
                }
                System.out.println("Gol");
                m1 = new Minge(50, 25);
            } catch(Corner c){
                this.cornerTotal++;
                System.out.println("Corner");
                if(m1.getCoordonataX() == 0){ 
                    if((m1.getCoordonataY() > 0) && (m1.getCoordonataY() < 20)){
                        m1 = new Minge(0, 0);
                    }
                    else{
                        m1 = new Minge(0, 50);
                    }
                }
                else{
                    if((m1.getCoordonataY() > 0) && (m1.getCoordonataY() < 20)){
                        m1 = new Minge(100, 0);
                    }
                    else{
                        m1 = new Minge(100, 50);
                    }
                }
            } finally {
                System.out.println(this.numeEchipa1 + " - " + this.numeEchipa2 + " : Mingea se afla la coordonatele (" + m1.getCoordonataX() + ", " + m1.getCoordonataY() + ")");
            }
        }
    }

    public String toString(){
        return "Echipe\n" + this.numeEchipa1 + " - " + this.numeEchipa2 + "\nScor\n" + this.goluriEchipa1 + " - " + this.goluriEchipa2 + "\nOut\n" + this.outTotal + "\nCorner\n" + this.cornerTotal;
    }

    public void castiga(){
        if(this.goluriEchipa1 > this.goluriEchipa2){
            System.out.println("Castigatoarea este " + this.numeEchipa1);
        }
        else if(this.goluriEchipa2 > this.goluriEchipa1){
            System.out.println("Castigatoarea este " + this.numeEchipa2);
        }
        else{
            System.out.println("Egal");
        }
    }
}

class Main{
    public static void main(String args[]){
        Joc joc1 = new Joc("FC Barcelona", "Real Madrid");
        Joc joc2 = new Joc("Manchester City", "Manchester United");

        joc1.simuleaza();
        System.out.println("\n" + joc1);
        joc1.castiga();
        
        joc2.simuleaza();
        System.out.println(joc2);
        joc2.castiga();
    }
}