package chars;

import exceptions.JudNotSmokingException;
import interfaces.CarryingRocks;

import java.util.ArrayList;

public class Jud extends Human implements CarryingRocks {
    public Jud(){
        super.name = "Джуд";
    }

    FacialExpressions face = FacialExpressions.DEFAULT;
ArrayList<Rocks> kurgan = new ArrayList<>();


    public void sit(Location location){
        move(location);
        System.out.println("Джуд садится");

    }
    public void smile(){
        face = FacialExpressions.SMILE;
        System.out.println("Джуд улыбнулся");
        

    }

    public void nod(){
        System.out.println("Джуд кивнул");

    }

   @Override
    public void carryRocks(){
       kurgan.add(new Rocks());
       System.out.println("Джуд перебирает камни");
    }

    public void value(){
        move(Location.GRAVE);
        System.out.println("Джуд оценивает проделанную работу");

    }
public Cigarette cigarette = new Cigarette();
    public void smoke() throws InterruptedException {
        for (int i = 0; i<3; i++) {
            if (Math.random()<=0.5) {
                light(cigarette);
                System.out.println(name + " зажёг сигарету спичкой и начинает курить");
                Thread.sleep(2000);
                break;
            }
            if(i<2){
                System.out.println(name + " не смог зажечь спичку");
                Thread.sleep(2000);
            }
            else throw new JudNotSmokingException("Джуд не смог зажечь сигарету, умер от недостатка курения");
        }

    }


enum FacialExpressions{SMILE, DEFAULT}
public class Cigarette{
        public boolean isLit=Boolean.FALSE;
}
    public class Rocks{
        public static int NumberOfRocks;
        Rocks(){
            NumberOfRocks++;
        }
    }
}

