import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;

public class View implements CTView{

    private Timer ticker;
    private JButton button;
    private JLabel clickme;
    private JLabel modelReport;

    private CTModel model;

    public View() {
        // setup main frame/window
        Frame frame = new Frame("ClickTick MVC");
        frame.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosing(WindowEvent windowEvent) {
                                        super.windowClosing(windowEvent);
                                        windowEvent.getWindow().setVisible(false);
                                        System.exit(0);
                                    }
                                });
        frame.setSize(200,100);
        frame.setLocation(100,100);

        this.button = new JButton("Press Me");
        this.clickme = new JLabel("Click Me");
        this.modelReport = new JLabel("Initialize Model");

        this.ticker = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { }
        });

        JPanel ctrlPanel = new JPanel();
        ctrlPanel.add(this.button);
        ctrlPanel.add(this.clickme);

        JPanel rprtPanel = new JPanel();
        rprtPanel.add(this.modelReport);

        JPanel UI = new JPanel();
        UI.setLayout(new GridLayout(2,1,10,5));
        UI.add(ctrlPanel);
        UI.add(rprtPanel);

        frame.add(UI);
        frame.setVisible(true);
    }

    @Override
    public void registerModel(CTModel model) {
        this.model = model;
        this.model.addObserver(this);
        this.modelReport.setText("Clicks: " + this.model.getClicks() +
                " Ticks: " + this.model.getTicks() +
                " Presses: " + this.model.getPresses());
    }

    @Override
    public void addClickHandler(MouseListener clickctrl) {
        this.clickme.addMouseListener(clickctrl);

    }

    @Override
    public void addTickHandler(ActionListener tickctrl) {
        this.ticker.addActionListener(tickctrl);

    }

    @Override
    public void addPressHandler(ActionListener pressctrl) {
        this.button.addActionListener(pressctrl);

    }

    @Override
    public void toggleTimer() {
        if(this.ticker.isRunning()){
            this.ticker.stop();
        }
        else{
            this.ticker.start();
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        this.modelReport.setText("Clicks: " + this.model.getClicks() +
                " Ticks: " + this.model.getTicks() +
                " Presses: " + this.model.getPresses());

    }

    public static void main(String[] args){
        CTModel testmodel = new Model(2,4,6);
        CTView testview = new View();
        testview.registerModel(testmodel);

        testmodel.incrementPresses();
        testmodel.incrementTicks();
        testmodel.incrementClicks();
    }
}
