import chars.Jud;
import interfaces.CarryingRocks;

public class MyThread extends Thread{
    @Override
    public void run() {
        while(Thread.currentThread().isAlive()){
            Carry(()->{Jud.Rocks.NumberOfRocks ++; System.out.println("Джуд перебирает камни");});
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

        }
        }
    }
    public void Carry(CarryingRocks carry){
        carry.carryRocks();
    }


}
