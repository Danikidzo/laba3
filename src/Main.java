import blocks.*;
import chars.*;
import exceptions.JudNotFoundException;
import exceptions.JudNotSmokingException;
import exceptions.ToolBrokenException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ToolBrokenException, JudNotFoundException {
        Block[][][] grave = new Block[3][2][3];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    grave[0][j][k]=new Dirt();
                    grave[1][j][k]=new Stone();
                    grave[2][j][k]=new Bedrock();
                }
            }

        Jud jud = new Jud();
        Louis louis = new Louis();
        Cat cat = new Cat(State.DEAD);
        jud.sit(Location.TREE);
        louis.move(Location.TREE);

        try {
            jud.smoke();
        }
        catch (JudNotSmokingException e){
            if(louis.location==jud.location){
                Jud.Cigarette cig = jud.new Cigarette();
                louis.light(cig);
                System.out.println("Луис помог Джуду зажечь сигарету");
            }
            else throw e;
        }
        jud.say("Хочешь немного передохнуть?");
        louis.say("Да нет, я не устал");
        louis.say("А что, обязательно рыть яму? Земля кажется тонкой.");
        jud.nod();
        jud.say("Ага. Земля тонкая. Но ее достаточно для травы — значит, хватит и для того, чтобы закопать его. В ней хоронили очень многих.");
        MyThread mythread = new MyThread();
        jud.move(Location.GRAVE);
        mythread.start();
        louis.move(Location.GRAVE);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    louis.dig(grave[i][j][k]);
                }
            }
        }
        mythread.stop();
        try {
            louis.lookBack(jud);
        }catch (JudNotFoundException e){
            louis.call(jud);
            louis.lookBack(jud);
        }
        jud.say("Это для кургана");
        louis.say("А-а");
        louis.think("Проклятый кот разместится здесь, как в кадиллаке");
        jud.value();
        jud.say("По-моему, хватит. По крайней мере, для кота достаточно.");
        louis.say("Теперь ты можешь мне сказать, для чего это?");
        jud.smile();
        jud.say("Микмаки верили, что это волшебное место Весь этот лес, от болота к северу и востоку. ");
        jud.say("Они хоронили здесь своих мертвых. И другие племена знали про это — пенобскоты говорили, что в этих лесах полно духов.");
        jud.smile();
        louis.think("Это совсем не то, о чем ты думаешь");
        cat.move(Location.GRAVE);
        cat.revive();
        System.out.println(cat);
        louis.evaluateCat(cat);
    }
}
