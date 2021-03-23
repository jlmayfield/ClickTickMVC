import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface CTControl {

    void registerModel(CTModel model);
    void registerView(CTView view);

    ActionListener getTickHandler();
    ActionListener getPressHandler();
    MouseListener getClickHandler();
}
