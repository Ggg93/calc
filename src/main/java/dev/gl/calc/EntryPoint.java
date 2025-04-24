package dev.gl.calc;

import dev.gl.calc.main.gui.MainWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author gl
 */
public class EntryPoint {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }
        
        SwingUtilities.invokeLater(() -> {
            MainWindow mw = new MainWindow();
            mw.setVisible(true);
        });
    }
}
