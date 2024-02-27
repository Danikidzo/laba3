package chars;

import blocks.Block;
import blocks.Dirt;
import blocks.Status;
import blocks.Stone;
import exceptions.JudNotFoundException;
import exceptions.ToolBrokenException;
import tools.Pickaxe;
import tools.Shovel;
import tools.Tools;

import java.util.ArrayList;

import static chars.Jud.Rocks.NumberOfRocks;

public class Louis extends Human {

    public Louis() {
        super.name = "Луис";
    }

    private Tools tool;
    ArrayList<Mozol> hands = new ArrayList<>();
    public Tools getTool() {
        return tool;
    }

    public void pickUpTool(Tools tool) {
        this.tool = tool;
    }

    public <T extends Block> void dig(T block) throws InterruptedException, ToolBrokenException {
        if (block instanceof Dirt & !(getTool() instanceof Shovel)) {
            pickUpTool(new Shovel());
            System.out.println("Луис берет в руки лопату");
        }
        if (block instanceof Stone & !(getTool() instanceof Pickaxe)) {
            pickUpTool(new Pickaxe());
            System.out.println("Луис берет в руки кирку");
        }
        hit(block);
    }

    public void sing() {
        System.out.println("Луис тихо напевает, пока копает");

    }

    public void lookBack(Jud jud) throws JudNotFoundException {
        if(location==jud.location){
            System.out.println("Луис оборачивается, видит Джуда и " + NumberOfRocks + " камня");
        }
        else{
            throw new JudNotFoundException("Луис оборачивается, но никого не видит");
        }

    }

    public void hit(Block block) throws ToolBrokenException, InterruptedException {
        while (block.getHp() > 0) {
            block.setHp((int) (block.getHp() - getTool().getDamage() * Math.round(Math.random() * 5)));
            endurance -= 5;
            getTool().setDurability(getTool().getDurability() - 1);
            if (Math.random() < 0.1) {
                sing();
                Thread.sleep(2000);
            }
            if (Math.random() < 0.05) {
                hands.add(new Mozol());
                System.out.println("Луис натер мозоль. Их всего " + hands.size());
                Thread.sleep(2000);
            }
            if (getTool().getDurability() <= 0) {
                throw new ToolBrokenException("Инструмент сломан!");
            }
            if (endurance <= 0) {
                System.out.println("Потный Луис устал, ему нужно отдохнуть");
                endurance = max_endurance;
                Thread.sleep(2000);
            }
            if (block.getHp() < 0) {
                block.setStatus(Status.BROKEN);
                System.out.println("Луис копает могилу всё глубже");
                Thread.sleep(2000);
            }
        }


    }

    class Mozol {

    }
}