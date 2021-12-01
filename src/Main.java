import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }

            }
        });
    }
}
