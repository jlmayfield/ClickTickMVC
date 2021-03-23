import java.util.Observable;

public abstract class CTModel extends Observable {

    abstract int getClicks();

    abstract int getTicks();

    abstract int getPresses();

    abstract void incrementClicks();

    abstract void incrementTicks();

    abstract void incrementPresses();
}
