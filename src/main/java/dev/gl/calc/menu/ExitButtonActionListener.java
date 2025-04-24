package dev.gl.calc.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gl
 */
public class ExitButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        //        this.dispose();
        System.exit(0);
    }

}
