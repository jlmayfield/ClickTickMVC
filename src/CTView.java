import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Observer;

public interface CTView extends Observer {

    void registerModel(CTModel model);

    void addClickHandler(MouseListener clickctrl);
    void addTickHandler(ActionListener tickctrl);
    void addPressHandler(ActionListener pressctrl);


    void toggleTimer();
}
