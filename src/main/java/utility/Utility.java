package utility;

import org.openqa.selenium.Dimension;
import java.awt.Toolkit;

public class Utility {

    public Dimension getScreenSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenResolution = new Dimension(
                (int) toolkit.getScreenSize().getWidth(),
                (int) toolkit.getScreenSize().getHeight()
        );
        return screenResolution;
    }

}
