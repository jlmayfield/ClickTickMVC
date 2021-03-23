import java.util.Observable;

public abstract class CTModel extends Observable {

    public abstract int getClicks();

    public abstract int getTicks();

    public abstract int getPresses();

    public abstract void incrementClicks();

    public abstract void incrementTicks();

    public abstract void incrementPresses();
}
