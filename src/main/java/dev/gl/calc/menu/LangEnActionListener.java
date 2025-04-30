package dev.gl.calc.menu;

import dev.gl.calc.Configuration;
import dev.gl.calc.EntryPoint;
import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gl
 */
public class LangEnActionListener implements ActionListener {

    private MainWindow mw;

    public LangEnActionListener(MainWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Configuration.getLang().equals("en")) {
        } else {
            Configuration.setLang("en");
            
            mw.dispose();
            // new thread?
            EntryPoint.main(null);
        }
    }

}
