import java.util.Objects;

public class Model extends CTModel{

    private int numClicks;
    private int numTicks;
    private int numPresses;

    public Model() {
        this.numPresses = 0;
        this.numTicks = 0;
        this.numClicks = 0;
    }

    public Model(int numClicks, int numTicks, int numPresses) {
        this.numClicks = numClicks;
        this.numTicks = numTicks;
        this.numPresses = numPresses;
    }

    @Override
    public int getClicks() {
        return this.numClicks;
    }

    @Override
    public int getTicks() {
        return this.numTicks;
    }

    @Override
    public int getPresses() {
        return this.numPresses;
    }

    @Override
    public void incrementClicks() {
        this.numClicks++;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void incrementTicks() {
        this.numTicks++;
        this.setChanged();
        this.notifyObservers();

    }

    @Override
    public void incrementPresses() {
        this.numPresses++;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "Model{" +
                "numClicks=" + numClicks +
                ", numTicks=" + numTicks +
                ", numPresses=" + numPresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return this.numClicks == model.numClicks &&
                this.numTicks == model.numTicks &&
                this.numPresses == model.numPresses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numClicks, numTicks, numPresses);
    }

    public static void main(String[] args){
        CTModel test = new Model(1,2,3);
        System.out.println(test.toString());

        test.incrementClicks();
        if( !test.equals(new Model(2,2,3)) ){
            System.out.println("IncrementClick Fail");
        }

        test.incrementTicks();
        if( !test.equals(new Model(2,3,3)) ){
            System.out.println("IncrementTick Fail");
        }

        test.incrementPresses();
        if( !test.equals(new Model(2,3,4)) ){
            System.out.println("IncrementPress Fail");
        }

        if( test.getClicks() != 2 || test.getPresses() != 4 || test.getTicks() !=3){
            System.out.println("One of the getters failed");
        }
    }
}
