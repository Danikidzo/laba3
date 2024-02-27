package chars;

import interfaces.CanLight;
import interfaces.Movable;

abstract public class Human implements Movable, CanLight {
    String name;
    public Location location = Location.FOREST;


    int endurance = 100;
    static int max_endurance=100;
    public void say(String text) throws InterruptedException {
        System.out.println(name + ": " + text);
        Thread.sleep(2000);
    }

    public void think(String text) throws InterruptedException {
        System.out.println('"' + text + '"' + " - подумал " + name);
        Thread.sleep(2000);
    }


    @Override
    public void move(Location location) {
       this.location=location;

    }

    @Override
    public void light(Jud.Cigarette cigarette){
        cigarette.isLit=Boolean.TRUE;

    }
    public <T extends Movable> void call(T t){
        t.move(location);
    }

    public void evaluateCat(Cat cat){
        if(cat.equals(new Cat(State.ALIVE))){
            System.out.println(name + " не замечает ничего необычного в коте");
        }
        else{
            System.out.println(name + " замечает, что с котом что-то не так...");
        }
    }


}
