import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements  CTControl{

    private CTModel model;
    private CTView view;

    private ActionListener tickHandler;
    private ActionListener pressHandler;
    private MouseListener clickHandler;

    public Control(){
        this.tickHandler = new Ticker();
        this.pressHandler = new Presser();
        this.clickHandler = new Clicker();

    }

    @Override
    public void registerModel(CTModel model) {
        this.model = model;
    }

    @Override
    public void registerView(CTView view) {
        this.view = view;
        this.view.addClickHandler(this.clickHandler);
        this.view.addPressHandler(this.pressHandler);
        this.view.addTickHandler(this.tickHandler);
    }

    @Override
    public ActionListener getTickHandler() {
        return this.tickHandler;
    }

    @Override
    public ActionListener getPressHandler() {
        return this.pressHandler;
    }

    @Override
    public MouseListener getClickHandler() {
        return this.clickHandler;
    }

    private class Ticker implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            model.incrementTicks();
        }
    }

    private class Presser implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            view.toggleTimer();
            model.incrementPresses();
        }
    }

    private class Clicker implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            view.toggleTimer();
            model.incrementClicks();
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    public static void main(String[] args){
        CTModel testmodel = new Model(1,2,3);
        CTView testView = new View();
        testView.registerModel(testmodel);

        CTControl testctrl = new Control();
        testctrl.registerModel(testmodel);
        testctrl.registerView(testView);
    }
}
