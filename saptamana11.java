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

    public void suteaza() throws Out, Gol, Corner{
        if(this.Y == 0 || this.Y == 50){
            throw new Out();
        }
        else if((this.X == 0 || this.X == 100) && (this.Y >= 20 && this.Y <= 30)){
            throw new Gol();
        }
        else if((this.X == 0 || this.X == 100) && (((this.Y > 0) && (this.Y < 20)) || (this.Y > 30) && (this.Y < 50))){
            throw new Corner();
        }

        CoordinateGenerator cg1 = new CoordinateGenerator();
        this.X = cg1.generateX();
        this.Y = cg1.generateY();
    }
}

class Joc{
    private String numeEchipa1;
    private String numeEchipa2;
    private int goluriEchipa1;
    private int goluriEchipa2;
    private int outTotal;
    private int cornerTotal;

    public Joc(String nume1, String nume2){
        this.numeEchipa1 = nume1;
        this.numeEchipa2 = nume2;
        this.goluriEchipa1 = 0;
        this.goluriEchipa2 = 0;
        this.outTotal = 0;
        this.cornerTotal = 0;
    }

    public String simuleaza(){
        Minge m1 = new Minge(55, 24);
        int i = 0;
        String rezultat = "";

        for(i = 0; i < 1000; i++){
            try{
                m1.suteaza();
            } catch(Out o){
                this.outTotal++;
                int altX = m1.getCoordonataX();
                int altY = m1.getCoordonataY();
                rezultat = rezultat + "Out";
                m1 = new Minge(altX, altY);
            } catch(Gol g){
                if(m1.getCoordonataX() == 0){
                    this.goluriEchipa2++;
                }
                else{
                    this.goluriEchipa1++;
                }
                rezultat = rezultat + "Gol";
                m1 = new Minge(50, 25);
            } catch(Corner c){
                this.cornerTotal++;
                rezultat = rezultat + "Corner";
                if(m1.getCoordonataX() == 0){ 
                    if((m1.getCoordonataY() > 0) && (m1.getCoordonataY() < 20))
                    {
                        m1 = new Minge(0, 0);
                    }
                    else{
                        m1 = new Minge(0, 50);
                    }
                }
                else{
                    if((m1.getCoordonataY() > 0) && (m1.getCoordonataY() < 20))
                    {
                        m1 = new Minge(100, 0);
                    }
                    else{
                        m1 = new Minge(100, 50);
                    }
                }
            } finally {
                rezultat = rezultat + this.numeEchipa1 + " - " + this.numeEchipa2 + " : Mingea se afla la coordonatele (" + m1.getCoordonataX() + ", " + m1.getCoordonataY() + ")";
            }
        }
        return rezultat;
    }

    public String toString(){
        return "Echipe\n" + this.numeEchipa1 + " - " + this.numeEchipa2 + "\nScor\n" + this.goluriEchipa1 + " - " + this.goluriEchipa2 + "\nOut\n" + this.outTotal + "\nCorner\n" + this.cornerTotal;
    }
}

class Main{
    public static void main(String args[]){
        Joc joc1 = new Joc("FC Barcelona", "Real Madrid");
        Joc joc2 = new Joc("Manchester City", "Manchester United");

        joc1.simuleaza();
        joc2.simuleaza();

        System.out.println(joc1);
        System.out.println(joc2);
    }
}