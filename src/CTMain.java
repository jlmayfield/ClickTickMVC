public class CTMain {

    public static void main(String[] args){
        CTModel m = new Model();
        CTView v = new View();
        CTControl c = new Control();

        v.registerModel(m);
        c.registerModel(m);
        c.registerView(v);
    }
}
