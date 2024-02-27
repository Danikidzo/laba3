package blocks;

abstract public class Block {
    private int hp;
    private Status s;

    public Block(int hp) {
        if (hp != 0) {
            setStatus(Status.EXIST);
        } else {
            setStatus(Status.BROKEN);
        }
        setHp(hp);
    }
    public void setStatus(Status s) {
        this.s = s;
    }

    public Status getStatus() {
        return s;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

}

