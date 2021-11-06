/*Chattarin Muksagul 6213124
Tinh Chaisena 6213199*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
class SportTeam {
    protected String name;
    protected int totalscore;
    public SportTeam(String na) { name = na;}
    public String getName() { return name; }
    public int getScore() { return totalscore; }
    public void print() { /* override this method in child class */ }
}

class Football extends SportTeam {
    protected String league;
    protected int wins=0,draws=0,loses=0;
    //private String[] fcName;
    public Football(String na, String L, int w, int d, int l){
        //super.name=na;
        super(na);
        league=L;
        wins=w;
        draws=d;
        loses=l;
    }
    @Override
    public void print() {
        System.out.printf("%-20s %10s %-20s %10s %-20s %10s Total Score = %d\n",this.name ,"",this.league,"","","",this.totalscore);
    }
}

class FormulaOne extends SportTeam {
    protected String nationality;
    protected int finishes[];
    protected int fastestLap;
    public FormulaOne(String na, String N,int []f, int fl){
        super(na);
        nationality = N;
        finishes = f;
        fastestLap = fl;
    }
    @Override
    public void print() {
        System.out.printf("%-20s %10s %-20s %10s %-20s %10s Total Score = %d\n",this.name ,"","","",this.nationality,"",this.totalscore);
    }
}

class Statistics {

    public static void main(String[] args) {
        
        SportTeam teams[] = new SportTeam[10];
        
        try {
            int i=0;
            int wins,loses,draws;
            Scanner scan = new Scanner(new File("teams.txt"));

            while (scan.hasNext()){
                
                String line = scan.nextLine();
                String [] buf = line.split(",");
                
                if (buf[0].equals("1")) {
                    
                    wins = Integer.parseInt(buf[3].trim());
                    draws = Integer.parseInt(buf[4].trim());
                    loses = Integer.parseInt(buf[5].trim());
                    
                    teams[i] = new Football(buf[1],buf[2],wins,draws,loses);
                    teams[i].totalscore = (wins*3)+draws;
                    
                    //System.out.printf("%-20s %10s %-20s %10s Total Score = %d\n",teams[i].name ,"",buf[2],"",teams[i].totalscore);
                }
                
                if (buf[0].equals("2")) {
                    
                    int[] places = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
                    int j,t=0;

                    //System.out.println("" + teams[i].totalscore);

                    for(j=0;j<=9;j++) 
                    {
                        int b = Integer.parseInt(buf[j+3].trim());
                        places[j] = b;
                    }
                    
                    teams[i] = new FormulaOne(buf[1],buf[2],places,Integer.parseInt(buf[13].trim()));
                    teams[i].totalscore = 0;
                    
                    for(j=0;j<=9;j++)
                    {
                        //System.out.println("555");
                        
                        switch(j){
                            case 0 -> teams[i].totalscore += (places[j]*25);
                            case 1 -> teams[i].totalscore += (places[j]*18);
                            case 2 -> teams[i].totalscore += (places[j]*15);
                            case 3 -> teams[i].totalscore += (places[j]*12);
                            case 4 -> teams[i].totalscore += (places[j]*10);
                            case 5 -> teams[i].totalscore += (places[j]*8);
                            case 6 -> teams[i].totalscore += (places[j]*6);
                            case 7 -> teams[i].totalscore += (places[j]*4);
                            case 8 -> teams[i].totalscore += (places[j]*2);
                            case 9 -> teams[i].totalscore += (places[j]);
                            default -> teams[i].totalscore += (places[j]);                        
                        }
                        //System.out.println("" + teams[i].totalscore);
                        //teams[i].totalscore += t;
                        //System.out.printf("%d ",places[j]);
                    }
                    teams[i].totalscore += Integer.parseInt(buf[13].trim());
                    
                    //System.out.printf("\n");
                    //System.out.printf("%-20s %10s %-20s %10s Total Score = %d\n",teams[i].name ,"",buf[2],"",teams[i].totalscore);
                }
                    
                i++;
                
                //System.out.println("" + buf[0]);

            }

            scan.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n\t\t\t\t== Only Football Teams ==\n");
        for(int k=0;k<10;k++)
            if (teams[k] instanceof Football)   teams[k].print();
        
        System.out.println("\n\t\t\t      == Only Formula One Teams ==\n");
        for(int k=0;k<10;k++)
            if (teams[k] instanceof FormulaOne)   teams[k].print();
        
        System.out.println("\n\t\t\t    == All teams in reverse order ==\n");
        for(int k=9;k>=0;k--)
            teams[k].print();
        
        System.out.println("");
        
    }
    
}
