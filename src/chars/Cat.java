package chars;

import interfaces.Movable;

import java.util.Objects;

public class Cat implements Movable {
    State state;
    Boolean possessed;
    String name = "Чёрчь";
    Location location = Location.FOREST;

    public Cat(State state) {
        this.state = state;
        possessed = Boolean.FALSE;
    }

    public void revive() {
        if (location.equals(Location.GRAVE)) {
            state = State.ALIVE;
            possessed = Boolean.TRUE;
        }

    }

    @Override
    public String toString() {
       return  (state == State.DEAD) ? "Кот мёртв" : "Кот жив";
    }

    @Override
    public void move(Location location) {
        this.location = location;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return state == cat.state && Objects.equals(name, cat.name) && possessed == cat.possessed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, name, possessed);
    }




}